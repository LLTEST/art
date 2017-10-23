package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver factoryMethod() {
        driver= new FirefoxDriver();
        return driver;}
}
