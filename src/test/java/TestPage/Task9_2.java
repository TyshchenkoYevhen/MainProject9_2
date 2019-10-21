package TestPage;

import org.junit.After;
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
    public void addToCart() {
        testPage.openMainPage();
        testPage.enterBlouse();
        testPage.execSearch();
        testPage.switchList();
        testPage.addToCart();
        testPage.procesedToCheckout();
        testPage.increaseQuantity();
        testPage.checkTotalProduct();
        testPage.checkTotalShipping();
        testPage.checkTotalGoods();
        testPage.checkTotalTax();
        testPage.checkPrice();
        testPage.deleteGood();
        testPage.cartIsEmpty();
    }

    @After
    public void cleanup() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

