package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    BrowserFactory bf = new BrowserFactory();
    protected Properties prop = new Properties();
    public WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void launchApplication(String browser) throws IOException {
        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        String propFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\configuration.properties";
        prop.load(new FileInputStream(propFilePath));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
    }
}
