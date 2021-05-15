package Utils;

import com.sun.javafx.PlatformUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Browser {

    private WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void invokeBrowser() {
        //File file = new File("/Users/.../src/test/resources/Drivers/chromedriver");
        //File file = new File("/binfordrivers/chromedriver");
        File file = null;
        if (PlatformUtil.isMac()) {
            file = new File("src/test/resources/Drivers/Mac/chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            file = new File("src/test/resources/Drivers/Window/chromedriver.exe");
        }
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void quitBrowser(Scenario scenario) {

        if (scenario.isFailed()) {

        }
        driver.close();
        driver.quit();
    }

}
