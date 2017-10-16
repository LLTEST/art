package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static String USER_1="userrtestt1@gmail.com";

    public static String PASS_1="p9660220_";

    public static String USER_2="userrtestt2@gmail.com";

    public static String PASS_2="p9660220_";

    public LoginPage(WebDriver driver) {
        super(driver) ;
    }


    public LoginPage LoginFlow(String user, String pass) {

        waitForElementPresent(INPUT_EMAIL);
        INPUT_EMAIL.sendKeys(user);
        IDENT_NEXT_BUTTON.click();
        waitForElementPresent(INPUT_PASSWORD);
        INPUT_PASSWORD.sendKeys(pass);
        PASS_NEXT_BUTTON.click();
        return new LoginPage(driver);
    }


    public LoginPage open() {

        driver.get(URL_PAGE);
        driver.manage().window().maximize();
        return this;
    }

    public void ChangeAccount(){
        final WebElement someid2 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/content/span/span/svg")));
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/content/span/span/svg")).click();
    }
}
