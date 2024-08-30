package Tests;

import Pages.FooterPage;
import Pages.TrackPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrackYourOrder extends BaseTest {

    @Test
    public void TrackYourOrder() throws InterruptedException {
        FooterPage footerPage=new FooterPage(driver);
        footerPage.goToTrackPage();
        TrackPage trackPage=new TrackPage(driver);
        trackPage.trackOrder("test@gmail.com","CD123456");
        Assert.assertEquals(trackPage.getErrorMsg(),"This order don't have any tracking info.");
    }
}
