package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends AbstractComponent {
    WebDriver driver;
    public ProductDetailsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(css = "div[role='alert'] a[class='button wc-forward']")
    WebElement viewCartButton;
    @FindBy(css = "div h1")
    WebElement ProductName;
    @FindBy(css = "div.summary p span")
    WebElement price;
    @FindBy(css = ".input-text.qty.text")
    WebElement quantity;
    @FindBy(className = "sku")
    WebElement ProductSKU;
    @FindBy(css = "a[href='https://mdsforkliftparts.com/product-category/ad-advance/']")
    WebElement ProductCategory;

    public void clickOnProductCategory(){
        ProductCategory.click();
    }
    public void AddQuantity(String reqQuant){
        quantity.clear();
        quantity.sendKeys(reqQuant);
    }

    public String getPrice(){
        return price.getText();
    }

    public void AddProductToCArt(){
        addToCartButton.click();
    }

    public CartPage goTOcart(){
        viewCartButton.click();
        CartPage cartPage=new CartPage(driver);
        return cartPage;
    }


    public String getProductName(){
        String prodName=ProductName.getText();
        return prodName;
    }
}
