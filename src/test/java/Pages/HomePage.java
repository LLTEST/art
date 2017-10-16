package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomePage extends AbstractPage  {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    WebElement composeButton;

    @FindBy(xpath = "//span[@class='gb_7a gbii']")
    WebElement myAccountButton;

    @FindBy(css = "#gb_71")
    WebElement signOutButton;

    List<WebElement> allLetters;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public LetterPage mainLogic() {

        waitForElementClickable(composeButton);
        composeButton.click();
        return new LetterPage(driver);

    }

    public LoginPage quitFromGmail(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myAccountButton.click();
        signOutButton.click();
        return new LoginPage(driver);
    }

    public HomePage markLetter() throws InterruptedException {

        String expectedText = "";
        for (WebElement webElement : allLetters){
            if (webElement.findElement(By.xpath("./td[6]")).getText().contains(expectedText)){
                webElement.findElement(By.xpath("./td[]")).click();
                Actions action = new Actions(driver);

                action.moveToElement(driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")));
                driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")).click();
            }
        }



//        driver.findElement(By.xpath("//*[@role='checkbox'][1]")).click();
//
//        Actions action = new Actions(driver);
//
//        action.moveToElement(driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")));
//        driver.findElement(By.xpath("//*[@id=':5']/div/div[1]/div[1]/div/div/div[2]/div[2]")).click();

        return new HomePage(driver);
    }


}
