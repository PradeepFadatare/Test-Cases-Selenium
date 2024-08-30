package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountDetailsPage extends AbstractComponent {
    WebDriver driver;
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "account_first_name")
    WebElement FirstNameTextBox;
    @FindBy(id = "account_last_name")
    WebElement LastNameTextBox;
    @FindBy(id = "account_display_name")
    WebElement DisplayNameTextBox;
    @FindBy(id = "account_email")
    WebElement EmailTextBox;
    @FindBy(id = "password_current")
    WebElement CurrentPassTextBox;
    @FindBy(id = "password_1")
    WebElement NewPassTextBox;
    @FindBy(id = "password_2")
    WebElement ConfNewPassTextBox;
    @FindBy(css = "button[value$='Save changes']")
    WebElement SaveChangeButton;

    public void clearAccountDetails(String firstName,String lastName,String userName,String email){
        FirstNameTextBox.clear();
        FirstNameTextBox.sendKeys(firstName);
        LastNameTextBox.clear();
        LastNameTextBox.sendKeys(lastName);
        DisplayNameTextBox.clear();
        DisplayNameTextBox.sendKeys(userName);
        EmailTextBox.clear();
        EmailTextBox.sendKeys(email);
        SaveChangeButton.click();
    }

    public String addDetails(String name,String lastName,String email,String userName){
        FirstNameTextBox.clear();
        FirstNameTextBox.sendKeys(name);
        LastNameTextBox.clear();
        LastNameTextBox.sendKeys(lastName);
        DisplayNameTextBox.sendKeys(userName);
        EmailTextBox.sendKeys(email);
        String mail= EmailTextBox.getAttribute("value");
        SaveChangeButton.click();
        return mail;
    }

    public void changePass(String currPass,String newPass,String newPass1){
        CurrentPassTextBox.sendKeys(currPass);
        NewPassTextBox.sendKeys(newPass);
        ConfNewPassTextBox.sendKeys(newPass1);
        SaveChangeButton.click();
    }
}
