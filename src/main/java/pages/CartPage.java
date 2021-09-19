package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage{
    By funnyCow_quan = By.xpath("(//td[text()=' Funny Cow']//following::input)[1]");
    By fluffyBunny_quan = By.xpath("(//td[text()=' Fluffy Bunny']//following::input)[1]");
    By cartCount = By.className(".cart-count");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage verifyFunnyCowQuantity(){
        Assert.assertTrue(GetAttributeValue(funnyCow_quan).equals("2"),"Funny Cow quantity is not 2 in Cart");
        return this;
    }
    public CartPage verifyFluffyBunnyQuantity(){
        Assert.assertTrue(GetAttributeValue(fluffyBunny_quan).equals("1"),"Fluffy Bunny quantity is not 1 in Cart");
        return this;
    }

    public CartPage verifyCartCount(){
        List<WebElement> list = driver.findElements(cartCount);
        for (WebElement elem: list ) {
            Assert.assertTrue(elem.getText().equals("3"),"No. of items displayed in Cart is not correct");
        }
        return this;
    }
}
