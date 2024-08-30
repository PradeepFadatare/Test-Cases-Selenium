package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li")
    List<WebElement> products;
    @FindBy(id = "category-filter")
    WebElement categoryDropdown;
    By productsBy = By.xpath("//*[@id=\"main\"]/ul/li");
    @FindBy(tagName = "h1")
    WebElement title;

    public String getTitleOfPage(){
        return title.getText();
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String selectedValue() {
        String val = getDropdownselectedValue(categoryDropdown);
        return val;
    }

    public List<WebElement> getProductCatalog() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public String getProductNames() {
        String pName = "";
        for (WebElement e : products) {
            pName = e.findElement(By.tagName("h2")).getText();
        }
        return pName;
    }

    public WebElement getProductByName(String productName) {
        WebElement reqProd = products.stream().filter(p -> p.findElement(By.tagName("h2")).getText().equalsIgnoreCase(productName))
                .findFirst().orElse(null);
        return reqProd;
    }

    public String getSKU(String productName) {
        WebElement product = getProductByName(productName);
        String SKU = product.findElement(By.tagName("p")).getText();
        return SKU;
    }

    public ProductDetailsPage goToProductDetailsPage(String productName) {
        getProductByName(productName).click();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        return productDetailsPage;
    }

}
