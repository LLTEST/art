package Test;

import Data.DataSet;
import Driver.DriverSingleton;
import Pages.HomePage;
import Pages.LetterPage;
import Pages.LoginPage;
import businessObjects.Letter;
import businessObjects.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GmailTest {

    private static final Logger Log = Logger.getLogger(GmailTest.class);
    private WebDriver driver;
    private LoginPage loginpage;
    private HomePage homepage;
    private LetterPage letter;

    @BeforeTest(description = "start browser")
    private void initBrowser() {
      //  DOMConfigurator.configure("log4j.xml");
        PropertyConfigurator.configure("log4j.properties");
        driver = DriverSingleton.getWebDriverInstance("chrome");
        Log.info("Instance is initialized");

    }

    @Test(description = "gmail Spam Test", dataProvider = "data")
    public void gmailSpamTest(User user1, User user2,Letter message) {


        loginpage = new LoginPage(driver);
        Log.info("LoginPage is opened");
        homepage = loginpage.open(DataSet.URL_PAGE).loginFlow(user2.getUSER1(), user2.getPASS1());
        Log.info("User1 is logged");
        letter = homepage.openLetter();
        Log.info("Letter draw is opened");
        letter.sendEmail(message.getNAME1(),message.getSUBJECT1());
        Log.info("Email1 is sent to User2");
        homepage.quitFromGmail();
        Log.info("User1 is logged out");
        loginpage.open(DataSet.URL_PAGE).loginFlow(user1.getUSER1(), user1.getPASS1());
        Log.info("User2 is logged");
        homepage.markSpamLetter().reportSpam().quitFromGmail();
        Log.info("User2 marked email as spam and logged out");
        loginpage.open(DataSet.URL_PAGE).loginFlow(user2.getUSER1(), user2.getPASS1());
        Log.info("User1 is logged again");
        homepage.openLetter();
        Log.info("Letter draw is opened");
        letter.sendEmail(message.getNAME1(),message.getSUBJECT1());
        Log.info("Email1 is sent to User2");
        homepage.quitFromGmail();
        Log.info("User1 is logged out");
        loginpage.open(DataSet.URL_PAGE).loginFlow(user1.getUSER1(), user1.getPASS1());
        Log.info("User2 is logged");
        Assert.assertTrue(homepage.openSpamFolder().verifySpamLetter());
        Log.info("Test is successfully finished");
    }

    @AfterTest(description = "close browser")
    public void kill() {
        DriverSingleton.closeDriver();
        Log.info("Instance is closed");
    }

    @DataProvider(name = "data")
    private Object[][] testData() {
        User user1 = new User("userrtestt1@gmail.com", "p9660220_");
        User user2 = new User("userrtestt4@gmail.com", "p9660220_");
        Letter letter1 = new Letter("test name", "Hello CI");
        return new Object[][]{{user1,user2,letter1}};
    }

}




