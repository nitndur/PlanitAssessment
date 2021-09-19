package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static DriverFactory instance = new DriverFactory();
    private DriverFactory(){

    }
    public static DriverFactory getInstance(){
        return instance;
    }
    public  void setDriver(WebDriver driverParam){
        driver.set(driverParam);
    }

    public  WebDriver getDriver(){
        return driver.get();
    }

    public  void closeBrowser(){
        driver.get().close();
        driver.remove();
    }
}
