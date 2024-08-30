package Tests;

import Abstract.AbstractElements;
import Pages.ContactUsPage;
import Pages.FooterPage;
import Pages.ProductsPage;
import TestComponents.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ContactUs extends BaseTest {

    @Test
    public void checkContactFormOnlyFirstName(){
        AbstractElements abstractElements=new AbstractElements(driver);
        ContactUsPage contactUsPage=abstractElements.goToContactUs();
        contactUsPage.submitForm("Pradeep","","","");
         try {
             driver.findElement(By.cssSelector("span[data-name='your-name'] span[class='wpcf7-not-valid-tip']"));
         }catch (Exception e){
             System.out.println("No error found");
         }
    }

    @Test
    public void CheckAddressLinkIsWorkingFine(){
        FooterPage footerPage = new FooterPage(driver);
        ContactUsPage contactUsPage = footerPage.goToContactUs();
        contactUsPage.clickOnAddressLink();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        Assert.assertTrue(driver.getTitle().contains("Google Maps"));
        driver.close();
    }

    @Test
    public void CheckPartDepartmentContactLinkIsWorking() throws InterruptedException {
        FooterPage footerPage = new FooterPage(driver);
        ContactUsPage contactUsPage = footerPage.goToContactUs();
        contactUsPage.ClickPartDepContact();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        driver.close();
//        Thread.sleep(2000);
//        System.out.println(driver.getCurrentUrl());
//        driver.switchTo().alert().dismiss();
    }

    @Test
    public void VerifyMainContactLinkIsWorking() {
        FooterPage footerPage = new FooterPage(driver);
        ContactUsPage contactUsPage = footerPage.goToContactUs();
        contactUsPage.ClickOnMAinOfficeContact();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next(); // Parent window
        String childWindow = itr.next(); // Child window (newly opened window)
        driver.switchTo().window(childWindow);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
        driver.switchTo().window(parentWindow);
    }

    @Test
    public void CheckSubmitForm(){
        AbstractElements abstractElements=new AbstractElements(driver);
        ContactUsPage contactUs=abstractElements.goToContactUs();
        contactUs.submitForm("Pradeep","test@mail.com","9987098789","ContactFormTest");
        String captchaError=driver.findElement(By.xpath("//span[contains(text(),'Please complete the hCaptcha.')]")).getText();
        Assert.assertEquals(captchaError,"Please complete the hCaptcha.");
    }

    @Test
    public void goToShop(){
        AbstractElements abstractElements=new AbstractElements(driver);
        ContactUsPage contactUsPage=abstractElements.goToContactUs();
        contactUsPage=new ContactUsPage(driver);
        ProductsPage productsPage=contactUsPage.GotoShopPage();
        Assert.assertEquals(productsPage.getTitleOfPage(),"Shop");
    }

}
