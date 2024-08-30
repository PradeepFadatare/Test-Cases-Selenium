package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends AbstractComponent {
    public FooterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;
    @FindBy(css = "#menu-item-15724560 > a")
    WebElement Shop;
    @FindBy(id = "menu-item-15724561")
    WebElement MyAccount;
    @FindBy(css = "#menu-item-15724558 > a")
    WebElement ContactUs;
    @FindBy(css = "#menu-item-15724557 > a")
    WebElement Track;
    @FindBy(css = "#menu-item-15724562 > a")
    WebElement MdsIndustrial;
    @FindBy(css = "#text-2 > div > p:nth-child(1) > a")
    WebElement CallUs;

    public TrackPage clickTrackYourOrderLink(){
        Track.click();
        TrackPage trackPage=new TrackPage(driver);
        return trackPage;
    }

    public void ClickMdsCorp(){
        MdsIndustrial.click();
    }

    public void ClickCallUs(){
        CallUs.click();
    }

    public ShopPage goToShop() {
        Shop.click();
        ShopPage shopPage = new ShopPage(driver);
        return shopPage;
    }

    public MyAccountPage goToMyAccount() {
        MyAccount.click();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return myAccountPage;
    }

    public ContactUsPage goToContactUs() {
        ContactUs.click();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        return contactUsPage;
    }

    public MDSIndustrialCorpPage goToMdsCorp() {
        MdsIndustrial.click();
        MDSIndustrialCorpPage corpPage = new MDSIndustrialCorpPage();
        return corpPage;
    }

    public TrackPage goToTrackPage() throws InterruptedException {
        scrollToViewElement(Track);
//        Thread.sleep(2000);
        Track.click();
        TrackPage trackPage = new TrackPage(driver);
        return trackPage;
    }
}
