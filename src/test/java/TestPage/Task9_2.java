package TestPage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task9_2 {


    private WebDriver driver;
    private TestPage testPage;
    private static final String PATH_TO_CHROMEDRIVER = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

    @Before
    public void setting() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        // win mac linux
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        testPage = new TestPage(this.driver);
    }

    @Test
    public void Test1 () {
        testPage.openMainPage();
        testPage.enterBlouse();
        testPage.execSearch();
        testPage.switchList();
        testPage.addToCart();
        testPage.procesedToCheckout();
        testPage.increaseQuantity();
    }

    @Test
    public void checkTotalProd () {
        String expRes = "$54.00"; //54
        String actRes = testPage.checkTotalProduct();
        Assert.assertEquals(expRes,actRes);
    }

    @Test
    public void checkShipping() {
        String expRes = "$2.00";
        String actRes = testPage.checkTotalShipping();
        Assert.assertEquals(expRes,actRes);
    }

    @Test
    public void checkTotalGoods() {
        String expRes = "$56.00";
        String actRes = testPage.checkTotalGoods();
        Assert.assertEquals(expRes,actRes);
    }

    @Test
    public void checkTotalTax() {
        String expRes = "$0.00";
        String actRes = testPage.checkTotalTax();
        Assert.assertEquals(expRes,actRes);
    }
    @Test
    public void checkPrice() {
        String expRes = "$56.00";
        String actRes = testPage.checkPrice();
        Assert.assertEquals(expRes,actRes);
    }

    @Test
   public void  Test2 () {
        testPage.deleteGood();
        testPage.cartIsEmpty();
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

