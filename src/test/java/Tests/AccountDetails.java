package Tests;

import Pages.AccountDetailsPage;
import Pages.MyAccountPage;
import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class AccountDetails extends BaseTest {
    @Test(priority = 2)
    public void addFirstLastDisplayName(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.clearAccountDetails("Kevin","Peterson","Kevin_123","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Email address is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);

        // Output the result
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 2)
    public void addFirstLastName(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.clearAccountDetails("Kevin","Peterson","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Display name is a required field.");
        expectedErrorMessages.add("Email address is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 1)
    public void addFirstNameOnly(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.clearAccountDetails("Kevin","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Last name is a required field.");
        expectedErrorMessages.add("Display name is a required field.");
        expectedErrorMessages.add("Email address is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 0)
    public void checkEmptyErrorMsg(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.clearAccountDetails("","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("First name is a required field.");
        expectedErrorMessages.add("Last name is a required field.");
        expectedErrorMessages.add("Display name is a required field.");
        expectedErrorMessages.add("Email address is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 3)
    public void addAccountDetails() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        String email=accountDetailsPage.addDetails("Kevin","Peterson","","");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(email,email);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div[role='alert']")).getText(),"Account details changed successfully.");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void CheckWithAddinginvalidCurrentPass(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@2024","MdsIndustries@123","MdsIndustries@123");
        String error=driver.findElement(By.cssSelector("ul[role='alert'] li")).getText();
        Assert.assertEquals(error,"Your current password is incorrect.");
    }

    @Test(priority = 5)
    public void AddValidCurrentPasswordAndOnlyUpperCaseNewAndConfirmNewPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@123","QWERTYUIOPLKJHGFDSAZXCVBNMERTR","QWERTYUIOPLKJHGFDSAZXCVBNMERTR");

        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Password must have at least one lowercase letter.");
        expectedErrorMessages.add("Password must have at least one number.");
        expectedErrorMessages.add("Password must have at least one special character.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 6)
    public void AddValidCurrentPasswordAndOnlyLowerCaseNewAndConfirmNewPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@123","abcdefghyfjysishdu","abcdefghyfjysishdu");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Password must have at least one uppercase letter.");
        expectedErrorMessages.add("Password must have at least one number.");
        expectedErrorMessages.add("Password must have at least one special character.");
        List<String> actualErrorMessages = new ArrayList<>();
        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 7)
    public void AddValidCurrentPasswordAndOnlySymbolsInNewAndConfirmPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@123","abcdefghyfjysishdu","abcdefghyfjysishdu");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Password must have at least one uppercase letter.");
        expectedErrorMessages.add("Password must have at least one number.");
        expectedErrorMessages.add("Password must have at least one special character.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);

        // Output the result
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 8)
    public void AddValidCurrentPasswordAndOnlySymbolsInNewAndConfirmNewPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@123","!@#$%^%$#@#%^*()","!@#$%^%$#@#%^*()");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Password must have at least one uppercase letter.");
        expectedErrorMessages.add("Password must have at least one lowercase letter.");
        expectedErrorMessages.add("Password must have at least one number.");
        List<String> actualErrorMessages = new ArrayList<>();
        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 9)
    public void checkEmptyCurrentPasswordAndValidNewAndConfirmNewPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("","Pradeep@321$123","Pradeep@321$123");
                List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Please enter your current password.");
        List<String> actualErrorMessages = new ArrayList<>();
        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void addOnlyValidCurrentPassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass(password,"","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Please fill out all password fields.");
        List<String> actualErrorMessages = new ArrayList<>();
        List<WebElement> error=driver.findElements(By.cssSelector("ul[role='alert'] li"));
        for (WebElement e:error){
            actualErrorMessages.add(e.getText());
        }
        boolean areErrorsMatching = expectedErrorMessages.equals(actualErrorMessages);
        if (areErrorsMatching) {
            System.out.println("The error messages match.");
        } else {
            System.out.println("The error messages do not match.");
            System.out.println("Expected: " + expectedErrorMessages);
            System.out.println("Actual: " + actualErrorMessages);
            Assert.assertTrue(false);
        }
    }

    @Test
    public void CheckchangePassword(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AccountDetailsPage accountDetailsPage=myAccountPage.ClickAccountDetailsTab();
        accountDetailsPage.changePass("MdsIndustries@2024","MdsIndustries@2025","MdsIndustries@2025");
        String msg=driver.findElement(By.cssSelector("ul[role='alert'] li")).getText();
        Assert.assertEquals(msg,"Your current password is incorrect.");
    }
}
