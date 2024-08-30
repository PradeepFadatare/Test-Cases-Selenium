package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends AbstractComponent {
    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[placeholder='Full Name']")
    WebElement FirstName;
    @FindBy(css = "input[placeholder='E-mail']")
    WebElement Email;
    @FindBy(css = "input[placeholder='Phone Numner']")
    WebElement PhoneNumber;
    @FindBy(css = "textarea[placeholder='Your Message']")
    WebElement Message;
    @FindBy(css = "input[type='submit']")
    WebElement SubmitButton;
    @FindBy(css = "a.button.button-secondary")
    WebElement Shop;
    @FindBy(css = ".flexible-hero-block h1")
    WebElement contactUS;
    @FindBy(xpath = "//div[contains(@class,'text-gray-900 mt-1')]//div//a[contains(text(),'(678) 398-9068')]")
    WebElement MainOfficeContact;
    @FindBy(linkText = "(678) 202-4930")
    WebElement PartDepCOntact;
    @FindBy(linkText = "7641 Hardrock Rd., Douglasville, GA 30134")
    WebElement AddressLink;
    @FindBy(css = "span[data-name='your-name'] span[class='wpcf7-not-valid-tip']")
    WebElement FullNameError;
    @FindBy(css = "span[data-name='your-email'] span[class='wpcf7-not-valid-tip']")
    WebElement EmailError;
    @FindBy(css = "span[data-name='your-phone'] span[class='wpcf7-not-valid-tip']")
    WebElement PhoneError;
    @FindBy(xpath = "//span[contains(text(),'Please complete the hCaptcha.')]")
    WebElement CaptchaError;

    public void clickOnAddressLink(){
        AddressLink.click();
    }

    public void ClickPartDepContact(){
        PartDepCOntact.click();
    }

    public void ClickOnMAinOfficeContact(){
        MainOfficeContact.click();
    }

    public String getContactUsHeading(){
        return contactUS.getText();
    }

    public ProductsPage GotoShopPage(){
        Shop.click();
        ProductsPage productsPage=new ProductsPage(driver);
        return productsPage;
    }

    public void submitForm(String fn,String email,String num,String msg){
        FirstName.sendKeys(fn);
        Email.sendKeys(email);
        PhoneNumber.sendKeys(num);
        Message.sendKeys(msg);
        SubmitButton.click();
    }
}
