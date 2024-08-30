package Tests;

import Pages.MyAccountPage;
import Pages.PaymentMethodPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentMethod extends BaseTest {
    @Test
    public void checkEmptyPaymentTab(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        PaymentMethodPage paymentMethodPage=myAccountPage.ClickPaymentMethod();
        Assert.assertEquals(paymentMethodPage.getNoPaymentSavedMsg(),"No saved methods found.");
    }

    @Test
    public void addPaymentMethod(){
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        PaymentMethodPage paymentMethodPage=myAccountPage.ClickPaymentMethod();
        paymentMethodPage.addPayment(1234,11,234);
        Assert.assertTrue(false);
    }
}
