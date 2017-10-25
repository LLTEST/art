package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends AbstractPage  {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    private WebElement composeButton;

    @FindBy(xpath = "//span[@class='gb_bb gbii']")
    private WebElement myAccountButton;

    @FindBy(css = "#gb_71")
    private WebElement signOutButton;

    @FindBys({@FindBy(xpath = "//*[@id=':34']/tbody/tr")})
    private List<WebElement> allInboxLetters;

    @FindBy(xpath = "//*[@id=':2e']/tbody/tr")
    private List<WebElement> allSpamLetters;

    @FindBy(xpath = "//span[contains(.,'More ')]")
    private WebElement moreButton;

    @FindBy (xpath = "//a[@href='https://mail.google.com/mail/u/0/#spam']")
    private WebElement spamButton;

    @FindBy (xpath = "//div[contains(@act,'9')]")
    private WebElement reportSpamButton;

    private By messageName = By.xpath("./td[6]");

    private By letterCheckbox = By.xpath("./td[2]/div/div");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public LetterPage openLetter() {

        waitForElementClickable(composeButton);
        composeButton.click();
        return new LetterPage(driver);
    }

    public LoginPage quitFromGmail(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myAccountButton.click();
        signOutButton.click();
        isElementPresent();
        driver.manage().deleteAllCookies();
        return new LoginPage(driver);
    }

    public HomePage markSpamLetter()  {

        String expectedText = "test name";
        for (WebElement webElement : allInboxLetters ){
            if (webElement.findElement(messageName).getText().contains(expectedText)){
                System.out.println(webElement.findElement(messageName).getText());
                webElement.findElement(letterCheckbox).click();
            }
        }
        return this;
    }

    public boolean verifySpamLetter()  {

        String expectedText = "test name";
        for (WebElement webElement : allSpamLetters ){
            if (webElement.findElement(messageName).getText().contains(expectedText)){
                System.out.println(webElement.findElement(messageName).getText());
                return true;
            }
        }
        return false;
    }


    public HomePage openSpamFolder() {
        waitForElementClickable(moreButton);
        moreButton.click();
        spamButton.click();
         return this;
    }


    public HomePage reportSpam(){

        Actions action = new Actions(driver);
        action.moveToElement(reportSpamButton);
        reportSpamButton.click();
        return this;
    }
}
