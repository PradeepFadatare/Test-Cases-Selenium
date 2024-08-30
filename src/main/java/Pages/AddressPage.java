package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends AbstractComponent {
    WebDriver driver;
    public AddressPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h3[normalize-space()='Billing address']")
    WebElement BillingAddressText;
    @FindBy(xpath = "//h3[normalize-space()='Shipping address']")
    WebElement ShippingAddressText;
    @FindBy(xpath = "//a[@href='https://mdsforkliftparts.com/my-account/edit-address/billing/']")
    WebElement BillingEdit;
    @FindBy(css = "a[href='https://mdsforkliftparts.com/my-account/edit-address/shipping/']")
    WebElement ShipAddEditButton;
    @FindBy(tagName = "h3")
    WebElement BillingAddheader;
    @FindBy(id = "billing_first_name")
    WebElement FirstNameTextBox;
    @FindBy(id = "shipping_first_name")
    WebElement shipFirstNameTextBox;
    @FindBy(id = "billing_last_name")
    WebElement LastNameTextBox;
    @FindBy(id = "shipping_last_name")
    WebElement shipLastNameTextBox;
    @FindBy(id = "billing_company")
    WebElement CompanyTextBox;
    @FindBy(id = "shipping_company")
    WebElement shipCompanyTextBox;
    @FindBy(id = "billing_address_1")
    WebElement HouseNumberTextBox;
    @FindBy(id = "shipping_address_1")
    WebElement shipHouseNumberTextBox;
    @FindBy(id = "billing_address_2")
    WebElement ApartmentTextBox;
    @FindBy(id = "shipping_address_2")
    WebElement shipApartmentTextBox;
    @FindBy(id = "billing_city")
    WebElement TownTextBox;
    @FindBy(id = "shipping_city")
    WebElement shipTownTextBox;
    @FindBy(id = "select2-billing_state-container")
    WebElement StateDropdown;
    @FindBy(id = "select2-shipping_state-container")
    WebElement shipStateDropdown;
    @FindBy(id = "billing_postcode")
    WebElement ZipCodeTextBox;
    @FindBy(id = "shipping_postcode")
    WebElement shipZipCodeTextBox;
    @FindBy(id="billing_phone")
    WebElement PhoneNumberTextBox;
    @FindBy(id = "billing_email")
    WebElement EmailTextBox;
    @FindBy(css = "button[value='Save address']")
    WebElement SubmitButton;

    public void checkErrorMessages() throws InterruptedException {
        BillingEdit.click();
        FirstNameTextBox.clear();
        LastNameTextBox.clear();
        CompanyTextBox.clear();
        HouseNumberTextBox.clear();
        ApartmentTextBox.clear();
        TownTextBox.clear();
        StateDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        ZipCodeTextBox.clear();
        PhoneNumberTextBox.clear();
        String email=EmailTextBox.getText();
        SubmitButton.click();
    }

    public String chnageBillingAddress(String firstName, String lastName, String company, String house, String apartment,
                                       String town, String zip,String num) throws InterruptedException {
        BillingEdit.click();
        FirstNameTextBox.clear();
        FirstNameTextBox.sendKeys(firstName);
        LastNameTextBox.clear();
        LastNameTextBox.sendKeys(lastName);
        CompanyTextBox.clear();
        CompanyTextBox.sendKeys(company);
        HouseNumberTextBox.clear();
        HouseNumberTextBox.sendKeys(house);
        ApartmentTextBox.clear();
        ApartmentTextBox.sendKeys(apartment);
        TownTextBox.clear();
        TownTextBox.sendKeys(town);
        StateDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        ZipCodeTextBox.clear();
        ZipCodeTextBox.sendKeys(zip);
        PhoneNumberTextBox.clear();
        PhoneNumberTextBox.sendKeys(num);
        String email=EmailTextBox.getText();
        SubmitButton.click();
        return email;


    }

    public void addShippingDetails(String firstName, String lastName, String company, String house, String apartment,
                                   String town, String zip){
        ShipAddEditButton.click();
        shipFirstNameTextBox.sendKeys(firstName);
        shipLastNameTextBox.sendKeys(lastName);
        shipCompanyTextBox.sendKeys(company);
        shipHouseNumberTextBox.sendKeys(house);
        shipApartmentTextBox.sendKeys(apartment);
        shipTownTextBox.sendKeys(town);
        shipStateDropdown.click();
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        shipZipCodeTextBox.sendKeys(zip);
        SubmitButton.click();
    }

    public String addBillingDetails(String firstName, String lastName, String company, String house, String apartment,
                             String town, String zip, String num) throws InterruptedException {
        BillingEdit.click();
        FirstNameTextBox.clear();
        FirstNameTextBox.sendKeys(firstName);
        LastNameTextBox.clear();
        LastNameTextBox.sendKeys(lastName);
        CompanyTextBox.clear();
        CompanyTextBox.sendKeys(company);
        HouseNumberTextBox.clear();
        HouseNumberTextBox.sendKeys(house);
        ApartmentTextBox.clear();
        ApartmentTextBox.sendKeys(apartment);
        TownTextBox.clear();
        TownTextBox.sendKeys(town);
        StateDropdown.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
        ZipCodeTextBox.clear();
        ZipCodeTextBox.sendKeys(zip);
        PhoneNumberTextBox.clear();
        PhoneNumberTextBox.sendKeys(num);
        String email=EmailTextBox.getText();
        SubmitButton.click();
        return email;
    }
    public void VerifyBillingDetails(String firstName, String lastName, String company, String house, String apartment,
                                     String town, String zip, String num){
        BillingEdit.click();
        FirstNameTextBox.getAttribute("value").equals(firstName);
        LastNameTextBox.getAttribute("value").equals(lastName);
        CompanyTextBox.getAttribute("value").equals(company);
        HouseNumberTextBox.getAttribute("value").equals(house);
        ApartmentTextBox.getAttribute("value").equals(apartment);
        TownTextBox.getAttribute("value").equals(town);
        ZipCodeTextBox.getAttribute("value").equals(zip);
        PhoneNumberTextBox.getAttribute("value").equals(num);
    }

    public String getHeader(){
        return BillingAddheader.getText();
    }

}
