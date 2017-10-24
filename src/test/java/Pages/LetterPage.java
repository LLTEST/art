package Pages;
import Driver.WebDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LetterPage extends AbstractPage{

    public LetterPage(WebDriver driver){
    super(driver); }

    @FindBy(xpath = "//textarea[@class='vO'][1]")
    private WebElement inputMailField;
    @FindBy(xpath = "//*[@name='subjectbox']")
    private WebElement inputSubject;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
    private WebElement inputTextField;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement sendLetterButton;

public void sendEmail(String nameLetter, String subject) {
    waitForElementClickable(inputMailField);

    WebDecorator highlightedInputEmail = new WebDecorator(inputMailField);
    highlightedInputEmail.highlightElement(driver);
    highlightedInputEmail.sendKeys("userrtestt1@gmail.com");
    WebDecorator highlightedInputSubject = new WebDecorator(inputSubject);
    highlightedInputSubject.highlightElement(driver);
    highlightedInputSubject.sendKeys(nameLetter);
    WebDecorator highlightedInputTextFiled = new WebDecorator(inputTextField);
    highlightedInputTextFiled.highlightElement(driver);
    highlightedInputTextFiled.sendKeys(subject);
    WebDecorator highightedbutton = new WebDecorator(sendLetterButton);
    highightedbutton.highlightElement(driver);
    highightedbutton.click();


}


}
