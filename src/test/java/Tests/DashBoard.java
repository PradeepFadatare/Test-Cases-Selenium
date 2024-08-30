package Tests;

import Abstract.AbstractElements;
import Pages.MyAccountPage;
import Pages.ShopPage;
import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.AbstractDocument;

public class DashBoard extends BaseTest{

    @Test
    public void checkRecentOrderLink(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.recentOrderLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/orders/");
    }

    @Test
    public void checkShippingAndBillingAddressLink(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.shipAndBillAddLink();
        String text=driver.findElement(By.xpath("//*[@id='post-8']/div[1]/div/div/p")).getText();
        Assert.assertEquals(text,"The following addresses will be used on the checkout page by default.");
    }
    @Test
    public void checkEditYourPasswordAndAccountDetailsLink(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.clickOnEditAccountDetailsLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/edit-account/");
    }
    @Test
    public void CheckLogOutButton(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.clickLogOut();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/");
    }

    @Test
    public void CheckEmptyCartMessage(){
        AbstractElements abstractElements=new AbstractElements(driver);
        abstractElements.hoverOnCartIcon();
    }
}
