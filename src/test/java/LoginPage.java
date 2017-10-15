import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By INPUT_EMAIL = By.xpath("//*[@id='identifierId']");
    private static final By INPUT_PASSWORD = By.xpath("//*[@id='password']");



    private static final By IDENT_NEXT_BUTTON = By.xpath("//*[@id='identifierNext']");


    private static final By PASS_NEXT_BUTTON = By.xpath(("//*[@id='passwordNext']"));




    public LoginPage LoginFlow() {
        final WebElement someid11 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(INPUT_EMAIL));

        driver.findElement(INPUT_EMAIL).sendKeys("userrtestt2@gmail.com");
        driver.findElement(IDENT_NEXT_BUTTON).click();
        final WebElement someid1 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(INPUT_PASSWORD));
        driver.findElement(INPUT_PASSWORD).sendKeys("p9660220_");
        driver.findElement(PASS_NEXT_BUTTON).click();
        return new LoginPage(driver);
    }


    public void open() {
        driver.get("http:\\gmail.com");
        driver.manage().window().maximize();
    }
}
