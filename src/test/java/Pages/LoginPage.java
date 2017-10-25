package Pages;

import Driver.WebDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath ="//*[@id='identifierId']")
    private WebElement inputEmail;

    @FindBy(xpath ="//*[@id='password']//input")
    private WebElement inputPassword;

    @FindBy(xpath ="//*[@id='identifierNext']")
    private WebElement identNextButton;

    @FindBy(xpath ="//*[@id='passwordNext']")
    private WebElement passNextButton;

    public LoginPage(WebDriver driver) {
        super(driver) ;
    }

    public HomePage loginFlow(String email,String pass) {

        waitForElementPresent(inputEmail);
        WebDecorator highlightEmailInput = new WebDecorator(driver, inputEmail);
        highlightEmailInput.sendKeys(email);
        new WebDecorator(driver, identNextButton).click();
        waitForElementClickable(inputPassword);
        Actions action = new Actions(driver);
        action.moveToElement(inputPassword).click();
        new WebDecorator(driver, inputPassword).sendKeys(pass);
        new WebDecorator(driver, passNextButton).click();
        return new HomePage(driver);
    }

    public LoginPage open(String URL_PAGE) {

        driver.get(URL_PAGE);
        driver.manage().window().maximize();
        return this;
    }

}
