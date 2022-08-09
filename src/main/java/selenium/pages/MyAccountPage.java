package selenium.pages;

public class MyAccountPage extends BasePage {
    String title = "Default store | Login";
    public void titleVerification() {
        verifyTitlesAreEquals(title);
    }
}
