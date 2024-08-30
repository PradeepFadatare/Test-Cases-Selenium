package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackPage extends AbstractComponent {
    WebDriver driver;

    public TrackPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ywot-check-email")
    WebElement Email;
    @FindBy(id = "ywot-check-order-id")
    WebElement OrderID;
    @FindBy(css = ".button")
    WebElement TrackOrderButton;
    @FindBy(css = ".yith-ywot-tracking-info-error")
    WebElement errorMessage;
    @FindBy(tagName = "h1")
    WebElement PageHeading;

    public String getHeading(){
        return PageHeading.getText();
    }


    public String getErrorMsg(){
        return errorMessage.getText();
    }

    public void trackOrder(String email, String orderId){
        Email.sendKeys(email);
        OrderID.sendKeys(orderId);
        TrackOrderButton.click();
    }
}
