package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {
    By funnyCow_buy = By.xpath("(//h4[text()='Funny Cow']/following::a)[1]");
    By fluffyBunny_buy = By.xpath("(//h4[text()='Fluffy Bunny']/following::a)[1]");
    public ShopPage(WebDriver driver) {
        super(driver);
    }
    public ShopPage buyFunnyCowTwice(){
        click(funnyCow_buy);
        click(funnyCow_buy);
        return this;
    }
    public ShopPage buyFluffyBunnyOnce(){
        click(fluffyBunny_buy);
        return this;
    }
}
