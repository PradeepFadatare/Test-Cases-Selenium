package Tests;

import Abstract.AbstractComponent;
import Pages.ProductsPage;
import Pages.ShopPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MostPopularBrand extends BaseTest {

    @Test
    public void CheckMostPopularBrandSection(){
        AbstractComponent component=new AbstractComponent(driver);
        component.goTOShop();
        ShopPage shopPage=new ShopPage(driver);
        ProductsPage productsPage = shopPage.getReqCard("RAYMOND");
        String val=productsPage.selectedValue();
        System.out.println(val);
        Assert.assertEquals(productsPage.getTitleOfPage(),"RA - RAYMOND");
    }
}
