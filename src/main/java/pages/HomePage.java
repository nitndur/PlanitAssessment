package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    By contactMenu = By.linkText("Contact");
    By shopMenu = By.linkText("Shop");
    By cartMenu = By.partialLinkText("Cart");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public ContactPage clickContact(){
        click(contactMenu);
        return new ContactPage(driver);
    }
    public ShopPage clickShop(){
        click(shopMenu);
        return new ShopPage(driver);
    }
    public CartPage clickCart(){
        click(cartMenu);
        return new CartPage(driver);
    }

}
