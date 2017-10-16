import Pages.HomePage;
import Pages.LetterPage;
import Pages.LoginPage;
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
        driver=new FirefoxDriver();

    }

    @Test(description = "Gmail Spam Test")
    public void GmailSpamTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.open().LoginFlow(LoginPage.USER_2, LoginPage.PASS_2);
        HomePage homepage = new HomePage(driver);
        homepage.MainLogic();
        LetterPage letter = new LetterPage(driver);
        letter.SendEmail();
        homepage.QuitFromGmail();
        loginpage.ChangeAccount();
     //   loginpage2.open().LoginFlow(LoginPage.USER_1,LoginPage.PASS_1);
      //  homepage.markLetter();
    }


    @AfterClass(description = "close browser")
    public void kill(){
        driver.close();
    }

}
