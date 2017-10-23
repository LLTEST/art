package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends WebDriverCreator {

    @Override
    public WebDriver factoryMethod() {
        driver = new ChromeDriver();
        return driver;
    }
}
