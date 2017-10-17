import Pages.HomePage;
import Pages.LetterPage;
import Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
      //    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
      //     driver=new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();

    }

    @Test(description = "Gmail Spam Test")
    public void gmailSpamTest() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = loginpage.open(URL_PAGE).LoginFlow(USER_4, PASS_4);
        LetterPage letter = homepage.mainLogic();
        letter.SendEmail();
        homepage.quitFromGmail();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.manage().deleteAllCookies();
        loginpage.open(URL_PAGE).LoginFlow(USER_1,PASS_1);
        homepage.markSpamLetter();
        homepage.deleteSpam();
        homepage.quitFromGmail();
        driver.switchTo().alert();
        alert.accept();
        driver.manage().deleteAllCookies();
        loginpage.open(URL_PAGE).LoginFlow(USER_4,PASS_4);
        homepage.mainLogic();
        letter.SendEmail();
        homepage.quitFromGmail();
        driver.switchTo().alert();
        alert.accept();
        driver.manage().deleteAllCookies();
        loginpage.open(URL_PAGE).LoginFlow(USER_1,PASS_1);



    }


    @AfterTest(description = "close browser")
    public void kill(){
        driver.close();
    }

}
