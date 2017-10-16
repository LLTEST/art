package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractPage{

    public LetterPage(WebDriver driver){
    super(driver); }

    @FindBy(xpath = "//textarea[@class='vO'][1]")
    WebElement inputMailField;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    WebElement inputTextField;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    WebElement sendLetterButton;

public void SendEmail(){
    waitForElementClickable(inputMailField);
    inputMailField.sendKeys("userrtestt1@gmail.com");
    inputTextField.sendKeys("test_letter");
    sendLetterButton.click();

}


}
