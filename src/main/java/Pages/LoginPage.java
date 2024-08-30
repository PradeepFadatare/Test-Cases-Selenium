package Pages;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractComponent {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(css = "button[value='Log in']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id='checkbox']")
    WebElement CheckBox;

    public void LogInto(String Username, String Password) throws InterruptedException {
        username.sendKeys(Username);
        password.sendKeys(Password);
        Thread.sleep(20000);
        loginButton.click();
    }

    public void goToLoginPage() {
        driver.get("https://mdsforkliftparts.com/my-account/");
    }

}
