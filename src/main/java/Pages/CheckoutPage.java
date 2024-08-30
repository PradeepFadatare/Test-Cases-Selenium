package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".cart_item")
    WebElement CartItems;

    public String getProductName(){
        return CartItems.findElement(By.cssSelector("td.product-name")).getText();
    }
    public String getAmount(){
        return CartItems.findElement(By.cssSelector("td span")).getText();
    }
}
