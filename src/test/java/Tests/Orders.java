package Tests;

import Pages.MyAccountPage;
import Pages.OrdersPage;
import Pages.ShopPage;
import TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Orders extends BaseTest {

    @Test
    public void checkBrowseProductButton(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        myAccountPage.recentOrderLink();
        OrdersPage ordersPage=new OrdersPage(driver);
        ShopPage shopPage=ordersPage.clickBrowseProduct();
        Assert.assertEquals(shopPage.getHeading(),"Shop");
    }
}
