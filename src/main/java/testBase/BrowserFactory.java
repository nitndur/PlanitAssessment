package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {
    public WebDriver createBrowserInstance(String browser){
        WebDriver driver = null;
        switch(browser){
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");
                driver = new FirefoxDriver(options);
                break;
            }
            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.addCommandSwitches("-private");
                driver = new InternetExplorerDriver(ieOptions);
                break;
        }
        return driver;

    }

}
