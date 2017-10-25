package Driver;

import org.openqa.selenium.*;

import java.util.List;

public class WebDecorator implements WebElement {

    private WebDriver driver;

    private WebElement element;

    public WebDecorator(WebDriver driver, WebElement element){
        this.element=element;
        this.driver=driver;
    }

    public void highlightElementYellow(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public void highlightElementRed(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", element);
    }

    @Override
    public void click() {
        highlightElementRed();
        element.click();
    }

    @Override
    public void submit() { }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        highlightElementYellow();
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() { }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
