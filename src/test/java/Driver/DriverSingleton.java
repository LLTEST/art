package Driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String SRC_MAIN_RESOURCES_CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    private static final String SRC_MAIN_RESOURCES_GECKODRIVER_EXE = "src/main/resources/geckodriver.exe";
    private static WebDriverCreator creator;
    private DriverSingleton(){}

    public static WebDriver getWebDriverInstance(String browsername){
        if (null == driver){
            switch (browsername) {
                case "chrome":
                    System.setProperty(WEBDRIVER_CHROME_DRIVER, SRC_MAIN_RESOURCES_CHROMEDRIVER_EXE);
                    creator = new ChromeDriverCreator();
                    break;
                case "firefox":
                    System.setProperty(WEBDRIVER_GECKO_DRIVER, SRC_MAIN_RESOURCES_GECKODRIVER_EXE);
                    creator = new FirefoxDriverCreator();
                    break;
                default:
                    System.setProperty(WEBDRIVER_CHROME_DRIVER, SRC_MAIN_RESOURCES_CHROMEDRIVER_EXE);
                    creator = new ChromeDriverCreator();
                    break;
            }
            driver = creator.factoryMethod();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
