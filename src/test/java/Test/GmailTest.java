package Test;

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

    private static String URL_PAGE="http:\\gmail.com";

    private static String USER_1="userrtestt1@gmail.com";

    private static String PASS_1="p9660220_";

    private static String USER_2="userrtestt2@gmail.com";

    private static String PASS_2="p9660220_";

    private static String USER_3="userrtestt3@gmail.com";

    private static String PASS_3="p9660220_";

    private static String USER_4="userrtestt4@gmail.com";

    private static String PASS_4="p9660220_";




    @BeforeTest(description = "start browser")
    private void initBrowser() {

          driver= DriverSingleton.getWebDriverInstance("firefox");

    }

    @Test(description = "gmail Spam Test")
    public void gmailSpamTest()  {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = loginpage.open(URL_PAGE).loginFlow(USER_4, PASS_4);
        LetterPage letter = homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(URL_PAGE).loginFlow(USER_1,PASS_1);
        homepage.markSpamLetter().reportSpam().quitFromGmail();
        loginpage.open(URL_PAGE).loginFlow(USER_4,PASS_4);
        homepage.openLetter();
        letter.sendEmail("test name");
        homepage.quitFromGmail();
        loginpage.open(URL_PAGE).loginFlow(USER_1,PASS_1);
        homepage.openSpamFolder().verifySpamLetter();
        Assert.assertTrue(homepage.verifySpamLetter());
    }


    @AfterTest(description = "close browser")
    public void kill(){
        DriverSingleton.closeDriver();
    }

}
