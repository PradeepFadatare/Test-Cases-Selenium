package Tests;

import Pages.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class Footer extends BaseTest {

    @Test
    public void CheckFooterMyAccountLink(){
        FooterPage footerPage=new FooterPage(driver);
        MyAccountPage myAccountPage=footerPage.goToMyAccount();
        Assert.assertEquals(driver.getCurrentUrl(),"https://mdsforkliftparts.com/my-account/");
    }

    @Test
    public void CheckFooterCantactUsLink(){
        FooterPage footerPage=new FooterPage(driver);
        ContactUsPage contactUsPage=footerPage.goToContactUs();
        Assert.assertEquals(contactUsPage.getContactUsHeading(),"Contact Us");
    }
    @Test
    public void CheckFooterTrackYourOrderLink(){
        FooterPage footerPage=new FooterPage(driver);
        TrackPage trackPage=footerPage.clickTrackYourOrderLink();
        Assert.assertEquals(trackPage.getHeading(),"Track Your Order");
    }

    @Test
    public void CheckCallUs() throws AWTException {
        FooterPage footerPage=new FooterPage(driver);
        footerPage.ClickCallUs();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    @Test
    public void CheckFooterShoplink(){
        FooterPage footerPage=new FooterPage(driver);
        ShopPage shopPage=footerPage.goToShop();
        Assert.assertEquals(shopPage.getHeading(),"Search for a Product");
    }

    @Test
    public void CheckFooterMDSIndusCorpLink(){
        FooterPage footerPage=new FooterPage(driver);
        footerPage.ClickMdsCorp();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String first = itr.next();
        String child = itr.next();
        driver.switchTo().window(child);
        String childURL=driver.getCurrentUrl();
        Assert.assertEquals(childURL,"https://www.mdsindustrialcorp.com/");
        driver.close();
        driver.switchTo().window(first);
    }


}
