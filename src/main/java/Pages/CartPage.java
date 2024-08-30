package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    WebElement proceedToCheckoutButton;
    @FindBy(css = "td.product-name a")
    WebElement prodName;
    @FindBy(css = "td.product-name p")
    WebElement Sku;
    @FindBy(css = ".wc-empty-cart")
    WebElement EmptyCardButton;
    @FindBy(css = ".button.wc-backward")
    WebElement ReturnToshop;

    public ProductsPage ClickReturnToShop(){
        ReturnToshop.click();
        ProductsPage productsPage=new ProductsPage(driver);
        return productsPage;
    }

    public void EmptyCard(){
        EmptyCardButton.click();
    }

    public String getSKU(){
        return Sku.getText();
    }

    public String getProdName(){
        return prodName.getText();
    }
    public CheckoutPage goToCheckoutPage(){
        proceedToCheckoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
