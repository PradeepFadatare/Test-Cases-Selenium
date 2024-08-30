package Pages;

import Abstract.AbstractComponent;
import Abstract.AbstractElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(id = "wp-block-search__input-1")
    WebElement searchBox;
    @FindBy(css = "button[aria-label='Search']")
    WebElement searchButton;
    @FindBy(id = "or-choose-a-category")
    WebElement mostPopularSec;
    @FindBy(css = ".cards-block a")
    List<WebElement> cardblocks;
    @FindBy(xpath = "//*[@id='product-categories-66c841786c39a-select']")
    WebElement CategoryDropDown;
    @FindBy(css = "[aria-label$='Go to category']")
    WebElement categorySearch;
    @FindBy(tagName = "h1")
    WebElement SearchForProduct;

    public void CheckEmptyCartMessage(){
        AbstractElements abstractElements=new AbstractElements(driver);
        abstractElements.hoverOnCartIcon();
    }
    public ShopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeading(){
        return SearchForProduct.getText();
    }

    public List<WebElement> DropdownList() {
        Select select = new Select(CategoryDropDown);
        return select.getOptions();
    }

    public ProductsPage selctCategroty(Integer num) {
        selectFromDropdownByIndex(CategoryDropDown, num);
//        selectFromDropdownByValue(categoryDropdown,val);
        categorySearch.click();
        ProductsPage productsPage = new ProductsPage(driver);
        return productsPage;
    }



    public ProductsPage serchProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
        ProductsPage productsPage = new ProductsPage(driver);
        return productsPage;
    }

    public ProductsPage getReqCard(String name) {
        System.out.println(cardblocks.size());
        for (WebElement e : cardblocks) {
            String prod = e.findElement(By.tagName("h5")).getText();
            System.out.println(prod);
            if (prod.contains(name)) {
                e.click();
                break;
            }else {
                System.out.println("No Match Found");
            }
        }
//    public ProductsPage goToCardProductPage(String name){
//         WebElement card=getReqCard(name);
//         scrollToViewElement(card);
//         card.click();
//         ProductsPage productsPage=new ProductsPage(driver);
//         return productsPage;
//    }

        ProductsPage productsPage=new ProductsPage(driver);
        return productsPage;
    }
}

