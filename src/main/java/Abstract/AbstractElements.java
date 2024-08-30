package Abstract;

import Pages.ContactUsPage;
import Pages.MDSIndustrialCorpPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractElements extends AbstractComponent {
    WebDriver driver;
    @FindBy(id = "woocommerce-product-search-field-0")
    WebElement GlobalSearch;
    @FindBy(id = "menu-item-1200")
    WebElement MyAccount;
    @FindBy(id = "menu-item-1949")
    WebElement ContactUS;
    @FindBy(id = "menu-item-15026852")
    WebElement MdsCorp;
    @FindBy(css = ".woocommerce-mini-cart__empty-message")
    WebElement NoProductInCartWidget;
    @FindBy(css = "#site-header-cart")
    WebElement CartIcon;

    public void hoverOnCartIcon(){
        Actions actions=new Actions(driver);
        actions.moveToElement(CartIcon).build().perform();
        System.out.println(NoProductInCartWidget.getText());
    }

    public MDSIndustrialCorpPage goToMdsCorp(){
        MdsCorp.click();
        MDSIndustrialCorpPage corpPage=new MDSIndustrialCorpPage();
        return corpPage;
    }

    public void goToMyAccount(){
        MyAccount.click();
    }

    public ContactUsPage goToContactUs(){
        ContactUS.click();
        ContactUsPage contactUsPage=new ContactUsPage(driver);

        return contactUsPage;
    }

    public AbstractElements(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void globalSearch(String sku) {
        GlobalSearch.sendKeys(sku);
        GlobalSearch.sendKeys(Keys.ENTER);
    }
}
