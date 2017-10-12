import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends Thread {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    private static final By COMPOSE_BUTTON = By.cssSelector("#\\3a 3o > div > div");
    private static final By INPUT_MAIL_FIELD = By.xpath("//*[@class=\"vO\"]");
    private static final By INPUT_TEXT_FIELD = By.xpath("//*[@class=\"Am Al editable LW-avf\"]");
    private static final By SEND_LETTER_BUTTON = By.xpath("//*[@class=\"T-I J-J5-Ji aoO T-I-atl L3\"]");
    private static final By MY_ACCOUNT_BUTTON = By.xpath("//*[@class=\"gb_7a gbii\"]");
    private static final By SIGN_OUT_BUTTON = By.xpath("//*[@class=\"gb_Ea gb_Ef gb_Mf gb_ue gb_yb\"]");

    public void MainLogic() throws InterruptedException {


        final WebElement someid4 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(COMPOSE_BUTTON));
        driver.findElement(COMPOSE_BUTTON).click();
        final WebElement someid2 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(INPUT_MAIL_FIELD));

        driver.findElement(INPUT_MAIL_FIELD).sendKeys("userrtestt1@gmail.com");
        driver.findElement(INPUT_TEXT_FIELD).sendKeys("test_letter");
        driver.findElement(SEND_LETTER_BUTTON).click();
        driver.findElement(MY_ACCOUNT_BUTTON).click();
        driver.findElement(SIGN_OUT_BUTTON).click();
        driver.close();
        WebDriver driver2 = new FirefoxDriver();
        driver2.get("http:\\gmail.com");
        driver2.manage().window().maximize();

        driver2.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys("userrtestt1@gmail.com");
        driver2.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        final WebElement someid3 = new WebDriverWait(driver2, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
        driver2.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("p9660220_");
        driver2.findElement(By.xpath(("//*[@id=\"passwordNext\"]/content/span"))).click();
        final WebElement someid13 = new WebDriverWait(driver2, 10).until(ExpectedConditions.elementToBeClickable(By.name("Oip Tops")));

        driver2.findElement(By.name("Oip Tops")).click();
        Thread.sleep(2000);
        driver2.findElement(By.cssSelector("#\\:87")).click();
        final WebElement someid5 = new WebDriverWait(driver2, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Report spam\"]")));

        driver2.findElement(By.xpath("//*[@aria-label=\"Report spam\"]")).click();
    }


}
