package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utils.Browser;

import static selenium.utils.Browser.driver;

public class BasePage {

    public WebDriverWait wait;

    public void clickOn(By element) {
        driver.findElement(element).click();
    }
    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void writeText(By elementBy, String text) {
        findElement(elementBy).sendKeys(text);
    }
    public void navigateTo(String url) {
        Browser.driver.get(url);
    }
    public void verifyTitlesAreEquals(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
