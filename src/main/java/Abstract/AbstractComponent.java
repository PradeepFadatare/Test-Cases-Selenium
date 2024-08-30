package Abstract;

import Pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    public JavascriptExecutor js;
    public Select select;
    WebDriver driver;
    @FindBy(css = "li[id='menu-item-15026762'] a")
    WebElement shopMenu;


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void wailUntillCheckboxIsSelected(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public String getDropdownselectedValue(WebElement element) {
        Select select = new Select(element);
        String dropdownValue = select.getFirstSelectedOption().getText();
        return dropdownValue;
    }

    public ShopPage goTOShop() {
        shopMenu.click();
        ShopPage shopPage=new ShopPage(driver);
        return shopPage;
    }

    public void scrollToViewElement(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void selectFromDropdownByIndex(WebElement element, Integer num) {
        select = new Select(element);
        select.selectByIndex(num);
    }

    public void selectFromDropdownByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void waitForElementToAppear(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
