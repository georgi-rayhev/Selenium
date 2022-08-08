package selenium.pages;

public class MyAccountPage extends BasePage {

    String title = "Default store | My Account";
    String secondTitle = "Default store | Login";

    public void verifyTitle() {
        verifyTitlesAreEquals(title);
    }

    public void verifyTitleAfterLogin() {
        verifyTitlesAreEquals(secondTitle);
    }
}
