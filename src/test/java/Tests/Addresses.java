package Tests;

import Pages.AddressPage;
import Pages.MyAccountPage;
import TestComponents.BaseTest;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Addresses extends BaseTest {

    @Test
    public void CheckMandatoryFieldsErrorMessage() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.checkErrorMessages();
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("First name is a required field.");
        expectedErrorMessages.add("Last name is a required field.");
        expectedErrorMessages.add("Street address is a required field.");
        expectedErrorMessages.add("Town / City is a required field.");
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
        }
    }
    @Test
    public void addOnlyFirstNameEroorMsgCheck() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","","","","","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Last name is a required field.");
        expectedErrorMessages.add("Street address is a required field.");
        expectedErrorMessages.add("Town / City is a required field.");
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
        }
    }
    @Test
    public void addFirstLastCompanyHouseTownZip() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","test","Mds","Tent","","Red","38008","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
    @Test
    public void addFirstLastCompanyHouseTownCheckErrorMsg() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","test","Mds","Tent","","Red","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
    @Test
    public void addFirstLastCompanyhouseCheckErrorMsg() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","test","Mds","Tent","","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Town / City is a required field.");
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
    @Test
    public void addFirstNameLastNameCompanyCheckErrorMsg() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","test","Mds","","","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
        expectedErrorMessages.add("Street address is a required field.");
        expectedErrorMessages.add("Town / City is a required field.");
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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
    @Test
    public void addFirstNameLastNameErrorCheck() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addBillingDetails("pradeep","test","","","","","","");
        List<String> expectedErrorMessages = new ArrayList<>();
//        expectedErrorMessages.add("Last name is a required field.");
        expectedErrorMessages.add("Street address is a required field.");
        expectedErrorMessages.add("Town / City is a required field.");
        expectedErrorMessages.add("ZIP Code is a required field.");
        expectedErrorMessages.add("Phone is a required field.");

        List<String> actualErrorMessages = new ArrayList<>();

        List<WebElement> error=driver.findElements(By.cssSelector("#content > div > div.woocommerce > ul > li"));
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

    @Test(dataProvider = "BillingDetails",priority = 0)
    public void AddBillingAddress(String firstName, String lastName, String company, String house, String apartment,
                                  String town, String zip, String num) throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        String email=addressPage.addBillingDetails(firstName,lastName,company,house,apartment,town,zip,num);
        String msg=driver.findElement(By.cssSelector("#content > div > div.woocommerce > div")).getText();
        Assert.assertEquals(msg,"Address changed successfully.");
//        driver.close();
    }

    @Test(dataProvider = "BillingDetails",priority = 1)
    public void verifyBillingDetails(String firstName, String lastName, String company, String house, String apartment,
                                     String town, String zip, String num){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.VerifyBillingDetails(firstName,lastName,company,house,apartment,town,zip,num);
    }
    @Test(dataProvider = "changeBillAddress",priority = 2)
    public void EditBillingAddress(String firstName, String lastName, String company, String house, String apartment,
                                   String town, String zip, String num) throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        String email=addressPage.addBillingDetails(firstName,lastName,company,house,apartment,town,zip,num);
        String msg=driver.findElement(By.cssSelector("#content > div > div.woocommerce > div")).getText();
        Assert.assertEquals(msg,"Address changed successfully.");
    }
    @Test(dataProvider = "changeBillAddress",priority = 3,dependsOnMethods = "EditBillingAddress")
    public void VerifyChangedBillingAddress(String firstName, String lastName, String company, String house, String apartment,
                                            String town, String zip, String num){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.VerifyBillingDetails(firstName,lastName,company,house,apartment,town,zip,num);
    }
    @Test
    public void AddShippingAddress(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        AddressPage addressPage=myAccountPage.ClickAddressTab();
        addressPage.addShippingDetails("John","Peterson", "Rev","house 12/23",
                "Apartment 2nd","Town","35242");
         String msg=driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div")).getText();
        Assert.assertEquals(msg,"Address changed successfully.");
    }

    @Test
    public void checkBillingAddress(){

    }

    DataFormatter formatter=new DataFormatter();
    @DataProvider(name ="BillingDetails")
    public Object[][] getBillingAddressDetails() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C://Users//prade//Downloads//data (1)//Book1.xlsx");
        XSSFWorkbook workbook;
        workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheet("Billing");
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object Data[][]=new Object[rowCount-1][colCount];
        for (int i=0;i<rowCount-1;i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j <colCount; j++) {
                XSSFCell cell=row.getCell(j);
                Data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return Data;
    }

    @DataProvider(name ="changeBillAddress")
    public Object[][] changeBillingAddressDetails() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C://Users//prade//Downloads//data (1)//Book1.xlsx");
        XSSFWorkbook workbook;
        workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet=workbook.getSheet("ChangeBillAdd");
        int rowCount=sheet.getPhysicalNumberOfRows();
        XSSFRow row=sheet.getRow(0);
        int colCount=row.getLastCellNum();
        Object Data[][]=new Object[rowCount-1][colCount];
        for (int i=0;i<rowCount-1;i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j <colCount; j++) {
                XSSFCell cell=row.getCell(j);
                Data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return Data;
    }
}
