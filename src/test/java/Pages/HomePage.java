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

    @FindBy(xpath = "//*[@id=':68']/tbody/tr")
    List<WebElement> allSpamLetters;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public LetterPage openLetter() {

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

    public void verifySpamLetter(){

        String expectedText = "test name";
        for (WebElement webElement : allSpamLetters){
            if (webElement.findElement(By.xpath("./td[6]")).getText().contains(expectedText)){
                System.out.println(webElement.findElement(By.xpath("./td[6]")).getText());
            } else {
                System.out.println("Letter doesn't exist- TEST FAILED");
            }
        }
    }


    public void openSpamFolder() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'More ')]")).click();
        driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#spam']")).click();
        Thread.sleep(4000);
    }


    public void deleteSpam(){

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div[contains(@act,'9')]")));
        driver.findElement(By.xpath("//div[contains(@act,'9')]")).click();
    }
}
