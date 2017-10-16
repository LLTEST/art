package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(xpath ="//*[@id='identifierId']")
    WebElement inputEmail;

    @FindBy(xpath ="//*[@id='password']//input")
    WebElement inputPassword;

    @FindBy(xpath ="//*[@id='identifierNext']")
    WebElement identNextButton;

    @FindBy(xpath ="//*[@id='passwordNext']")
    WebElement passNextButton;





    public LoginPage(WebDriver driver) {
        super(driver) ;
    }


    public HomePage LoginFlow(String user, String pass) throws InterruptedException {

        waitForElementPresent(inputEmail);
        inputEmail.sendKeys(user);
        identNextButton.click();
        waitForElementClickable(inputPassword);
        Actions action = new Actions(driver);
        action.moveToElement(inputPassword).click();
        inputPassword.sendKeys(pass);
        passNextButton.click();
        return new HomePage(driver);
    }


    public LoginPage open(String URL_PAGE) {

        driver.get(URL_PAGE);
        driver.manage().window().maximize();
        return this;
    }

    public void ChangeAccount(){
        final WebElement someid2 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/content/span/span/svg")));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/content/span/span/svg")).click();
    }
}
