import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTest {

    private WebDriver driver;

    @BeforeClass(description = "start browser")
    private void initBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();

    }

    @Test(description = "Gmail Spam Test")
    public void GmailSpamTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open().LoginFlow();
        HomePage homepage = new HomePage(driver);
        homepage.MainLogic();
        LetterPage letter = new LetterPage(driver);
        letter.SendEmail();
        homepage.QuitFromGmail();
    }


    @AfterClass(description = "close browser")
    public void kill(){
        driver.close();
    }

}
