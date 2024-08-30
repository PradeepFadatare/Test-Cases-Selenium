package Tests;

import Abstract.AbstractElements;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.ShopPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class ProductDetails extends BaseTest {

    String product="#8 SAE WASHER";
    @Test
    public void checkCategoryLink() {
        AbstractElements abstractElements = new AbstractElements(driver);
        ShopPage shopPage = abstractElements.goTOShop();
        ProductsPage productsPage=shopPage.selctCategroty(6);
        ProductDetailsPage productDetailsPage=productsPage.goToProductDetailsPage(product);
        productDetailsPage.clickOnProductCategory();
    }


}
