package ProjectDocuments.pages;

import ProjectDocuments.driver.Driver;
import ProjectDocuments.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends Methods {
    private static final Logger logger = LogManager.getLogger(Driver.class);
    public MainPage(WebDriver driver) {
    }
    public void acceptCookie(){
        WebElement cerezlerikabulet = Driver.driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
        cerezlerikabulet.click();
        waitBySeconds(2);
        logger.info("cookies accepted");
    }
    public void sendkeysObject() {
        WebElement search = Driver.driver.findElement(By.xpath("//*[@class=\"o-header__searchInput--input form-control header__searchInput header__searchAreaInput\"]"));
        search.click();
        search.sendKeys("ceket");
        search.sendKeys(Keys.ENTER);
        logger.info("key(ceket) sent");
    }
    public void CheckUrl() {
        String URL = Driver.driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.network.com.tr/");
        logger.info("url checked");
    }
    public void CheckPage() {
        String URL = Driver.driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.network.com.tr/search?searchKey=ceket&page=2");
        logger.info("url changed and verified");
    }
    public  void clickLogo(){
        clickElement(By.cssSelector("a[class='headerCheckout__logo']"));
        logger.info("clicked network icon");
    }
    public void clickBasketLogo(){
        clickElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));
        logger.info("clicked basket icon");
    }
    public void deleteProduct(){
        clickElement(By.cssSelector("div[class='header__basketProductBtn header__basketModal -remove']"));
        logger.info("delete product from the cart");
    }
    public void confirmRemove(){
        clickElement(By.cssSelector("button[class='btn -black o-removeCartModal__button']"));
        logger.info("verify deleted product");
    }
    public void checkBasketEmpty(){
        String emptyBasket=getText(By.cssSelector("span[class='header__emptyBasketText']"));
        Assert.assertEquals(emptyBasket, "Sepetiniz Henüz Boş");
        logger.info("checked empty cart");
    }
}
