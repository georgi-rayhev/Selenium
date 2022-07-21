import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static WebDriver driver = null;
    public static void openBrowser() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4545"), chromeOptions);
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();
    }
    public static void closeBrowser() {
        driver.quit();
    }

}

