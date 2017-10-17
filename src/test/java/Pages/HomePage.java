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

    @FindBy(xpath = "//*[@id=':34']/tbody/tr")
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

    public void markSpamLetter()  {


        String expectedText = "test name";
        for (WebElement webElement : allLetters){
            if (webElement.findElement(By.xpath("./td[6]")).getText().contains(expectedText)){
                System.out.println(webElement.findElement(By.xpath("./td[6]")).getText());
                webElement.findElement(By.xpath("./td[2]/div/div")).click();
            }
        }
    }

    public void deleteSpam(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[contains(@act,'9')]")));
        driver.findElement(By.xpath("//div[contains(@act,'9')]")).click();
    }

}
