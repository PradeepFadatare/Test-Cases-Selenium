package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends AbstractComponent {
    WebDriver driver;
    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement OrdersTab;
    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/div[2]/text()")
    WebElement NoOrderMsg;
    @FindBy(css = "a.woocommerce-Button")
    WebElement BrowseProductButton;

    public ShopPage clickBrowseProduct(){
        BrowseProductButton.click();
        ShopPage shopPage=new ShopPage(driver);
        return shopPage;
    }

    public String NoOrderMsg(){
        String msg=NoOrderMsg.getText();
        return msg;
    }

}
