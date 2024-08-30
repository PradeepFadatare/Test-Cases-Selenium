package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigInteger;

public class PaymentMethodPage extends AbstractComponent {
    WebDriver driver;
    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "woocommerce-info")
    WebElement NoPaymentSavedMsg;
        @FindBy(css = "a[class='button']")
    WebElement AddPaymentMethodButton;
    @FindBy(xpath = "//input[@id='wc-authorize-net-cim-credit-card-account-number']")
    WebElement CardNumberTextBox;
    @FindBy(xpath = "//input[@id='wc-authorize-net-cim-credit-card-expiry']")
    WebElement ExpiryTextBox;
    @FindBy(xpath = "//input[@id='wc-authorize-net-cim-credit-card-csc']")
    WebElement CardSecurityCodeTextBox;
    @FindBy(xpath = "//button[@id='place_order']")
    WebElement AddPaymentMethodButton1;


    public void addPayment(Integer cardNum, Integer mmdd, Integer securityCode){
        AddPaymentMethodButton.click();
        CardNumberTextBox.sendKeys(cardNum.toString());
        CardNumberTextBox.sendKeys(cardNum.toString());
        CardNumberTextBox.sendKeys(cardNum.toString());
        CardNumberTextBox.sendKeys(cardNum.toString());
        ExpiryTextBox.sendKeys(mmdd.toString());
        ExpiryTextBox.sendKeys(mmdd.toString());
        CardSecurityCodeTextBox.sendKeys(securityCode.toString());
        AddPaymentMethodButton1.click();

    }
    public String getNoPaymentSavedMsg(){
        String msg=NoPaymentSavedMsg.getText();
        return msg;
    }

}
