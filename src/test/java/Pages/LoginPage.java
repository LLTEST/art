package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath ="//*[@id='identifierId']")
    WebElement INPUT_EMAIL;

    @FindBy(xpath ="//*[@id='password']")
    WebElement INPUT_PASSWORD;

    @FindBy(xpath ="//*[@id='identifierNext']")
    WebElement IDENT_NEXT_BUTTON;

    @FindBy(xpath ="//*[@id='passwordNext']")
    WebElement PASS_NEXT_BUTTON;

    private static String URL_PAGE="http:\\gmail.com";

    private static String USER_2="userrtestt2@gmail.com";

    private static String PASS_2="p9660220_";

    public LoginPage(WebDriver driver) {
        super(driver) ;
    }


    public LoginPage LoginFlow() {

        waitForElementPresent(INPUT_EMAIL);
        INPUT_EMAIL.sendKeys(USER_2);
        IDENT_NEXT_BUTTON.click();
        waitForElementPresent(INPUT_PASSWORD);
        INPUT_PASSWORD.sendKeys(PASS_2);
        PASS_NEXT_BUTTON.click();
        return new LoginPage(driver);
    }


    public LoginPage open() {
        driver.get(URL_PAGE);
        driver.manage().window().maximize();
        return this;
    }
}
