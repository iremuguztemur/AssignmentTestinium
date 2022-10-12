package ProjectDocuments.Pages;

import ProjectDocuments.Driver.Driver;
import ProjectDocuments.Base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends Base {
    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static String productPrice;
    public static String productSize;
    public ProductPage(WebDriver driver) {
    }
    public void scrollAndClick() throws InterruptedException {
        scrollElement(By.xpath("(//*[@class=\"product__price -actual\"])[56]"));
        Thread.sleep(2000);
        clickElement(By.cssSelector("button[class='button -secondary -sm relative']"));
        Thread.sleep(10000);
        logger.info("see more products");
    }
    public void hoverProduct(){
        hoverElement(By.xpath("(//*[@class=\"product__price -actual\"])[1]"));
        logger.info("discounted product has been hovered");
    }
    public void getSize(){
        WebElement element=Driver.driver.findElements(By.cssSelector("div[class='header__basketProductVariation--val']")).get(1);
        productSize = element.getText();
        logger.info("product size taken");
    }
    public void getPrice(){
        productPrice = getText(By.cssSelector("span[class='a-product__price -salePrice']"));
        logger.info("product price taken");
    }
    public void compareSize(){
        WebElement element=Driver.driver.findElements(By.cssSelector("span[class='cartItem__attrValue']")).get(0);
        String basketSize=element.getText();
        Assert.assertEquals(basketSize, ProductPage.productSize);
        logger.info("size comparasing");
    }
    public void comparePrice(){
        String basketPrice=getText(By.cssSelector("span[class='cartItem__price -sale']"));
        Assert.assertEquals(basketPrice, ProductPage.productPrice);
        logger.info("price comparasing");
    }
    public void gotoCart(){
        clickElement(By.cssSelector("a[class='button -primary header__basket--checkout header__basketModal -checkout']"));

        logger.info("went to cart");
    }
    public void randomProduct(){
        clickElement(By.xpath("//*[@class='products__item col-6 col-md-4'][1]//*[@class=\"radio-box__label\"]"));
        waitBySeconds(3);
        logger.info("random size selected");
    }
    public Boolean compareSale(){

        String discountPrice = getText(By.cssSelector("span[class='cartItem__price -sale']")).substring(0,4);
        double newPrice = Double.parseDouble(discountPrice);
        String nonDiscountPrice = getText(By.cssSelector("span[class='cartItem__price -old -labelPrice']")).substring(0,4);
        double oldPrice = Double.parseDouble(nonDiscountPrice);
        if (oldPrice > newPrice){
            return true;
        }
        else {
            return false;
        }
    }
    public void clickContinue(){
        clickElement(By.cssSelector("button[class='continueButton n-button large block text-center -primary']"));
        logger.info("continued");
    }
}
