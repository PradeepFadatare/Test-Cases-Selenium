package Tests;

import Abstract.AbstractComponent;
import Abstract.AbstractElements;
import Pages.ProductsPage;
import Pages.ShopPage;
import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchFunctionality extends BaseTest {

    @Test
    public void GlobalSearchBySKU(){
        AbstractElements abstractElements=new AbstractElements(driver);
        abstractElements.globalSearch("MB2922347H00");
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertTrue(driver.findElement(By.id("product-search")).getText().contains("MB2922347H00"));
        List<WebElement> prodName = driver.findElements(By.cssSelector("ul.columns-4 p"));
        for (WebElement e : prodName) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains("MB2922347H00"));
        }
    }

    @Test
    public void GlobalSearchByProductName(){
        AbstractElements abstractElements=new AbstractElements(driver);
        abstractElements.globalSearch("ARMATURE");
        List<WebElement> prodName = driver.findElements(By.cssSelector("ul.columns-4 h2"));
        for (WebElement e : prodName) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains("ARMATURE"));
        }
    }


    @Test
    public void SearchByProductNameonShopPage() {
        AbstractComponent abstractComponent = new AbstractComponent(driver);
        abstractComponent.goTOShop();
        ShopPage shopPage = new ShopPage(driver);
        ProductsPage productsPage = shopPage.serchProduct("Armature");
        List<WebElement> prodName = driver.findElements(By.cssSelector("ul.columns-4 h2"));
        for (WebElement e : prodName) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains("ARMATURE"));
        }
    }

    @Test
    public void SearchBySKUonShopPage() {
        AbstractComponent abstractComponent = new AbstractComponent(driver);
        abstractComponent.goTOShop();
        ShopPage shopPage = new ShopPage(driver);
        ProductsPage productsPage = shopPage.serchProduct("MB2922347H00");
        Assert.assertTrue(driver.findElement(By.id("product-search")).getText().contains("MB2922347H00"));
        List<WebElement> prodName = driver.findElements(By.cssSelector("ul.columns-4 p"));
        for (WebElement e : prodName) {
            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains("MB2922347H00"));
        }
    }

    @Test
    public void CategorySearchonShopPage(){
        AbstractComponent abstractComponent = new AbstractComponent(driver);
        abstractComponent.goTOShop();
        ShopPage shopPage = new ShopPage(driver);
        List<WebElement> dropList=shopPage.DropdownList();
        for(WebElement e:dropList){
            System.out.println(e.getText());
        }
        ProductsPage productsPage=shopPage.selctCategroty(4);
        Assert.assertTrue(driver.findElement(By.cssSelector("div#primary h1")).getText().contains("AB - AC DELCO FILTERS"));
        Assert.assertEquals(productsPage.selectedValue(),"AB - AC DELCO FILTERS");
    }
}
