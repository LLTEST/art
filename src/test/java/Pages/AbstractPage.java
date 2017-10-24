package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;
    private static int WAIT_FOR_TIMEOUT_SECOND=10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isElementPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            return false;
        }
    }

    public void waitForElementPresent(WebElement locator){
        new WebDriverWait(driver, WAIT_FOR_TIMEOUT_SECOND).until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElementClickable(WebElement locator){
        new WebDriverWait(driver, WAIT_FOR_TIMEOUT_SECOND).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
