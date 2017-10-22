package Test;

import Data.DataSet;
import Driver.DriverSingleton;
import Pages.HomePage;
import Pages.LetterPage;
import Pages.LoginPage;
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
    public void gmailSpamTest()  {
        loginpage = new LoginPage(driver);
        homepage = loginpage.open(DataSet.URL_PAGE).loginFlow(DataSet.USER_4, DataSet.PASS_4);
        letter = homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(DataSet.USER_1,DataSet.PASS_1);
        homepage.markSpamLetter().reportSpam().quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(DataSet.USER_4,DataSet.PASS_4);
        homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(DataSet.URL_PAGE).loginFlow(DataSet.USER_1,DataSet.PASS_1);
        homepage.openSpamFolder().verifySpamLetter();
        Assert.assertTrue(homepage.verifySpamLetter());
    }


    @AfterTest(description = "close browser")
    public void kill(){
        DriverSingleton.closeDriver();
    }

}
