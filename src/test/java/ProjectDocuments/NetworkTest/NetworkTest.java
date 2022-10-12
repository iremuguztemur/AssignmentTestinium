package ProjectDocuments.NetworkTest;

import ProjectDocuments.Driver.Driver;
import ProjectDocuments.Pages.LoginPage;
import ProjectDocuments.Pages.MainPage;
import ProjectDocuments.Pages.ProductPage;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class NetworkTest extends Driver {
    ProductPage product;
    LoginPage login;
    MainPage home;
    @Test
    public void loginTest() throws InterruptedException, FileNotFoundException{

        home = new MainPage(driver);
        product = new ProductPage(driver);
        login = new LoginPage(driver);

        home.CheckUrl();
        home.acceptCookie();
        home.sendkeysObject();
        product.scrollAndClick();
        home.CheckPage();
        product.hoverProduct();
        product.randomProduct();
        product.getPrice();
        product.getSize();
        product.gotoCart();
        product.comparePrice();
        product.compareSize();
        product.compareSale();
        product.clickContinue();
        login.loginInformation();
        login.checkLoginButton();
        home.clickLogo();
        home.clickBasketLogo();
        home.deleteProduct();
        home.confirmRemove();
        home.clickBasketLogo();
        home.checkBasketEmpty();
    }
}
