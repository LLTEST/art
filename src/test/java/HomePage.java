import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends AbstractPage  {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    WebElement COMPOSE_BUTTON;

    @FindBy(xpath = "//*[@class=\"gb_7a gbii\"]")
    WebElement MY_ACCOUNT_BUTTON;

    @FindBy(xpath = "//*[@class=\"gb_Ea gb_Ef gb_Mf gb_ue gb_yb\"]")
    WebElement SIGN_OUT_BUTTON;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() { }

    public HomePage MainLogic() {


        final WebElement someid4 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(COMPOSE_BUTTON));
        COMPOSE_BUTTON.click();
        return new HomePage(driver);

    }

    public HomePage QuitFromGmail(){
        MY_ACCOUNT_BUTTON.click();
        SIGN_OUT_BUTTON.click();
        return new HomePage(driver);
    }





}
