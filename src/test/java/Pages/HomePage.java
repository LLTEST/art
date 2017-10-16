package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class HomePage extends AbstractPage  {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    WebElement COMPOSE_BUTTON;

    @FindBy(xpath = "//span[@class='gb_7a gbii']")
    WebElement MY_ACCOUNT_BUTTON;

    @FindBy(css = "#gb_71")
    WebElement SIGN_OUT_BUTTON;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage MainLogic() {



        waitForElementClickable(COMPOSE_BUTTON);
        COMPOSE_BUTTON.click();
        return new HomePage(driver);

    }

    public HomePage QuitFromGmail(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MY_ACCOUNT_BUTTON.click();
        SIGN_OUT_BUTTON.click();
        return new HomePage(driver);
    }

    public HomePage markLetter() throws InterruptedException {
        driver.findElement(By.xpath("//*[@role='checkbox'][1]")).click();

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")));
        driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")).click();

        return new HomePage(driver);
    }


}
