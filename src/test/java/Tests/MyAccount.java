package Tests;

import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.OrdersPage;
import TestComponents.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class MyAccount extends BaseTest {


    @Test
    public void LogIntoApplication() throws IOException, InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.LogInto("James_123", "MdsIndustries@123");
        Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();

        // Store cookies in a file
        FileWriter fileWriter = new FileWriter(new File("C:\\Users\\prade\\IdeaProjects\\Mds_Woocommerce\\src\\main\\java\\Resources\\cookies.data"));
        for (Cookie cookie : cookies) {
            fileWriter.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure() + "\n");
        }
        fileWriter.close();
    }
    @Test
    public void CheckAddressTab(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.ClickAddressTab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/edit-address/");
    }
    @Test
    public void CheckPaymentMethodTab(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.ClickPaymentMethod();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/payment-methods/");
    }
    @Test
    public void CheckOrdersTab(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.ClickOrdersTab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/orders/");
    }
    @Test
    public void CheckAccountDetailsTab(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.ClickAccountDetailsTab();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/edit-account/");
    }
    @Test
    public void CheckNoOrderMessage(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        OrdersPage ordersPage=myAccountPage.ClickOrdersTab();
        Assert.assertEquals(ordersPage.NoOrderMsg(),"No order has been made yet.");
    }
}
