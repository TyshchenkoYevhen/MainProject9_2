package TestPage;

import com.sun.xml.internal.ws.assembler.jaxws.TerminalTubeFactory;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestPage {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";
    private WebDriver driver;

    private By searchBlouse = By.xpath("//input[@id='search_query_top']");
    private By execSearchGoods = By.cssSelector(".button-search");
    private By list = By.xpath("//li[@id='list']/a/i");
    private By chooseGoods = By.xpath("//span[contains(.,'Add to cart')]");
    private By ProcButton = By.xpath("//span[contains(.,'Proceed to checkout')]");
    private By addButton = By.xpath("//a[@id='cart_quantity_up_2_7_0_0']/span/i");
    private By totalProduct = By.xpath("//td[@id='total_product']");
    private By totalShipping = By.xpath("//td[@id='total_shipping']");
    private By totalGoods = By.xpath("//td[@id='total_price_without_tax']");
    private By totalTax = By.xpath("//td[@id='total_tax']");
    private By price = By.xpath("//span[@id='total_price']");
    private By delete = By.xpath("//a[@id='2_7_0_0']/i");


    public TestPage (WebDriver driver) {
        this.driver = driver;
    }

    public TestPage openMainPage(){
        this.driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public void enterBlouse(){
        this.driver.findElement(searchBlouse).sendKeys("Blouse");
    }

    public TestPage execSearch(){
        this.driver.findElement(execSearchGoods).click();
        return this;
    }

    public TestPage switchList (){
        this.driver.findElement(list).click();
        return this;
    }

    public TestPage addToCart(){
        this.driver.findElement(chooseGoods).click();
        return this;
    }

    public TestPage procesedToCheckout () {
        this.driver.findElement(ProcButton).click();
        return this;
    }

    public TestPage increaseQuantity () throws InterruptedException {
        Assert.assertEquals("$27.00", this.driver.findElement(totalProduct).getText());
        this.driver.findElement(addButton).click();
        Thread.sleep(1500);
//        WebDriver driver = new ChromeDriver();
//        driver.get("webdriver.chrome.driver");
//        WebElement dynamicElement = (new WebDriverWait(driver, 20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@id='total_product']")));
        Assert.assertEquals("$54.00", this.driver.findElement(totalProduct).getText());
        Assert.assertEquals("$2.00", this.driver.findElement(totalShipping).getText());
        Assert.assertEquals("$56.00", this.driver.findElement(totalGoods).getText());
        Assert.assertEquals("$0.00", this.driver.findElement(totalTax).getText());
        Assert.assertEquals("$56.00", this.driver.findElement(price).getText());
        return this;
    }

    public TestPage deleteGood (){
        this.driver.findElement(delete).click();
        return this;
    }

    public boolean cartIsEmpty(){
        return this.driver.findElement(price).isDisplayed();
    }
}
