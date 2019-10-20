package TestPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

class TestPage {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";
    private WebDriver driver;

    private By searchBlouse = xpath("//input[@id='search_query_top']");
    private By execSearchGoods = By.cssSelector(".button-search");
    private By list = xpath("//li[@id='list']/a/i");
    private By chooseGoods = xpath("//span[contains(.,'Add to cart')]");
    private By ProcButton = xpath("//span[contains(.,'Proceed to checkout')]");
    private By addButton = xpath("//a[@id='cart_quantity_up_2_7_0_0']/span/i");
    private By total = xpath("//td[@id='total_product']");
    private By totalProduct = xpath("//span[@id='total_product_price_2_7_0']");
    private By totalShipping = xpath("//td[@id='total_shipping']");
    private By totalGoods = xpath("//td[@id='total_price_without_tax']");
    private By totalTax = xpath("//td[@id='total_tax']");
    private By price = xpath("//span[@id='total_price']");
    private By delete = xpath("//a[@id='2_7_0_0']/i");
    private By cartEmpty = xpath("//p[contains(.,'Your shopping cart is empty.')]");


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

    public TestPage increaseQuantity(){
        Assert.assertEquals("$27.00", this.driver.findElement(total).getText());
        this.driver.findElement(addButton).click();
        Boolean explicitWait = new WebDriverWait(driver, 20).until(ExpectedConditions.textToBePresentInElementLocated(xpath("//td[@id='total_product']"), "$54.00"));
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

    public TestPage cartIsEmpty(){
        this.driver.findElement(cartEmpty).isDisplayed();
        return this;
    }

}
