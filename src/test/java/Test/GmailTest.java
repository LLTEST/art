package Test;
import Data.DataSet;
import Driver.DriverSingleton;
import Pages.HomePage;
import Pages.LetterPage;
import Pages.LoginPage;
import businessObjects.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {

    private WebDriver driver;
    private LoginPage loginpage;
    private HomePage homepage;
    private LetterPage letter;

    @BeforeTest(description = "start browser")
    private void initBrowser() {

          driver= DriverSingleton.getWebDriverInstance("chrome");

    }


    @Test(description = "gmail Spam Test")
    public void gmailSpamTest(User user1, User user2)  {
        loginpage = new LoginPage(driver);
        homepage = loginpage.open(DataSet.URL_PAGE).loginFlow(user1.getUSER1(),user1.getPASS1());
        letter = homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(user2.getUSER4(),user2.getPASS4());
        homepage.markSpamLetter().reportSpam().quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(user1.getUSER1(),user1.getPASS1());
        homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(user2.getUSER4(),user2.getPASS4());
        Assert.assertTrue(homepage.openSpamFolder().verifySpamLetter());
    }


    @AfterTest(description = "close browser")
    public void kill(){
        DriverSingleton.closeDriver();
    }

}
