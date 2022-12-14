package base;
import util.WebEventListener;
import util.testutil;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() {

        try {

            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    "C:\\Users\\darsh\\IdeaProjects\\BooksWagonFinalProject\\src\\main\\java\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() throws FileNotFoundException {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with
        // EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}

