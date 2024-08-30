package Tests;

import Abstract.AbstractElements;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class MdsIndustriesCorp extends BaseTest {

    @Test
    public void ViewPage() {
        AbstractElements abstractElements = new AbstractElements(driver);
        String firstWindow = driver.getWindowHandle();
        abstractElements.goToMdsCorp();
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
