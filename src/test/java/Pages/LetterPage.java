package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage extends AbstractPage{




    public LetterPage(WebDriver driver){
    super(driver); }

    @FindBy(xpath = "//textarea[@class='vO'][1]")
    WebElement INPUT_MAIL_FIELD;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    WebElement INPUT_TEXT_FIELD;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    WebElement SEND_LETTER_BUTTON;





public void SendEmail(){

    final WebElement someid2 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(INPUT_MAIL_FIELD));

    INPUT_MAIL_FIELD.sendKeys("userrtestt1@gmail.com");
    INPUT_TEXT_FIELD.sendKeys("test_letter");
    SEND_LETTER_BUTTON.click();




}


}
