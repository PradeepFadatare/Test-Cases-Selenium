package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends AbstractComponent {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='recent orders']")
    WebElement RecentOrder;
    @FindBy(xpath = "//a[normalize-space()='shipping and billing addresses']")
    WebElement ShipandBillAdd;
    @FindBy(xpath = "//a[normalize-space()='edit your password and account details']")
    WebElement PassAandAccDetails;
    @FindBy(xpath = "//a[@href='https://mdsforkliftparts.com/my-account/'][normalize-space()='Dashboard']")
    WebElement Dashboard;
    @FindBy(xpath = "//a[normalize-space()='Orders']")
    WebElement OrdersTab;
    @FindBy(xpath = "//a[normalize-space()='Addresses']")
    WebElement AddresseTab;
    @FindBy(xpath = "//a[normalize-space()='Payment methods']")
    WebElement PaymentMethodTab;
    @FindBy(xpath = "//a[normalize-space()='Account details']")
    WebElement AccountDetailsTab;
    @FindBy(css = "li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout'] a")
    WebElement LogOutTab;


    public AddressPage ClickAddressTab(){
    AddresseTab.click();
    AddressPage addressPage=new AddressPage(driver);
        return addressPage;
    }

    public OrdersPage ClickOrdersTab(){
      OrdersTab.click();
      OrdersPage ordersPage=new OrdersPage(driver);
      return ordersPage;
    }

    public PaymentMethodPage ClickPaymentMethod(){
      PaymentMethodTab.click();
      PaymentMethodPage paymentMethodPage=new PaymentMethodPage(driver);
        return paymentMethodPage;
    }

    public AccountDetailsPage ClickAccountDetailsTab(){
        AccountDetailsTab.click();
        AccountDetailsPage accountDetailsPage=new AccountDetailsPage(driver);
        return accountDetailsPage;
    }

    public void recentOrderLink(){
        RecentOrder.click();
    }

    public void shipAndBillAddLink(){
        Dashboard.click();
        ShipandBillAdd.click();
    }

    public void clickOnEditAccountDetailsLink(){
        Dashboard.click();
        PassAandAccDetails.click();
    }

    public void clickLogOut(){
        LogOutTab.click();
    }




}