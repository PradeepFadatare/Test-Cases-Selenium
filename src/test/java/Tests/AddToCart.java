package Tests;

import Abstract.AbstractComponent;
import Pages.*;
import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class AddToCart extends BaseTest {

    String productName="ALTERNATOR – NEW";
    @org.testng.annotations.Test
    public void addProductToCart() throws IOException {

        AbstractComponent abstractComponent = new AbstractComponent(driver);
        abstractComponent.goTOShop();
        ShopPage shopPage = new ShopPage(driver);
        shopPage.serchProduct("Text");
        ProductsPage productsPage = new ProductsPage(driver);
        String SKU = productsPage.getSKU(productName);
        ProductDetailsPage productDetailsPage = productsPage.goToProductDetailsPage(productName);
        String prodName = productDetailsPage.getProductName();
        Assert.assertEquals(prodName, productName);
        String price = productDetailsPage.getPrice();
        System.out.println(price);
        productDetailsPage.AddQuantity("4");
        productDetailsPage.AddProductToCArt();
        CartPage cartPage = productDetailsPage.goTOcart();
        String prodName1 = cartPage.getProdName();
        String Sku = cartPage.getSKU();
        Assert.assertEquals(Sku, SKU);
        Assert.assertEquals(prodName1, productName);
        CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
        System.out.println(checkoutPage.getProductName());
        System.out.println(checkoutPage.getAmount());
    }

    @Test
    public void CheckEmptyCart(){
        AbstractComponent abstractComponent = new AbstractComponent(driver);
        abstractComponent.goTOShop();
        ShopPage shopPage = new ShopPage(driver);
        shopPage.serchProduct("ALTERNATOR – NEW");
        ProductsPage productsPage = new ProductsPage(driver);
        String SKU = productsPage.getSKU(productName);
        ProductDetailsPage productDetailsPage = productsPage.goToProductDetailsPage(productName);
        String prodName = productDetailsPage.getProductName();
        Assert.assertEquals(prodName, productName);
        String price = productDetailsPage.getPrice();
        System.out.println(price);
        productDetailsPage.AddQuantity("4");
        productDetailsPage.AddProductToCArt();
        CartPage cartPage = productDetailsPage.goTOcart();
        String prodName1 = cartPage.getProdName();
        String Sku = cartPage.getSKU();
        Assert.assertEquals(Sku, SKU);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(prodName1, productName);
        cartPage.EmptyCard();
        String EmptyCartMessage=driver.findElement(By.xpath("Your cart is currently empty.")).getText();
        Assert.assertEquals(EmptyCartMessage,"Your cart is currently empty.");
        softAssert.assertAll();
    }

    @Test
    public void checkReturnToShop(){
        {
            AbstractComponent abstractComponent = new AbstractComponent(driver);
            abstractComponent.goTOShop();
            ShopPage shopPage = new ShopPage(driver);
            shopPage.serchProduct("ALTERNATOR – NEW");
            ProductsPage productsPage = new ProductsPage(driver);
            String SKU = productsPage.getSKU(productName);
            ProductDetailsPage productDetailsPage = productsPage.goToProductDetailsPage(productName);
            String prodName = productDetailsPage.getProductName();
            Assert.assertEquals(prodName, productName);
            String price = productDetailsPage.getPrice();
            System.out.println(price);
            productDetailsPage.AddQuantity("4");
            productDetailsPage.AddProductToCArt();
            CartPage cartPage = productDetailsPage.goTOcart();
            String prodName1 = cartPage.getProdName();
            String Sku = cartPage.getSKU();
            Assert.assertEquals(Sku, SKU);
            SoftAssert softAssert=new SoftAssert();
            softAssert.assertEquals(prodName1, productName);
            cartPage.EmptyCard();
            String EmptyCartMessage=driver.findElement(By.className("cart-empty")).getText();
            Assert.assertEquals(EmptyCartMessage,"Your cart is currently empty.");
            productsPage=cartPage.ClickReturnToShop();
            String title=productsPage.getTitleOfPage();
            softAssert.assertEquals(title,"Shop");
            softAssert.assertAll();
        }
    }
}
