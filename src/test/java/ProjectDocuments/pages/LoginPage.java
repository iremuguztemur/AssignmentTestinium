package ProjectDocuments.pages;

import ProjectDocuments.driver.Driver;
import ProjectDocuments.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.Scanner;

public class LoginPage extends Methods {
    private static final Logger logger = LogManager.getLogger(Driver.class);
    public LoginPage(WebDriver driver) {
    }
    public void loginInformation() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src\\ids.csv"));
        sc.useDelimiter(",");
        String[] array=new String[2];
        array[0]=sc.nextLine();
        array[1]=sc.nextLine();
        WebElement mail = Driver.driver.findElement(new By.ByCssSelector("input#n-input-email.input.js-trim"));
        mail.click();
        mail.sendKeys(array[0]);
        WebElement password = Driver.driver.findElement(new By.ByCssSelector("input#n-input-password.input"));
        waitBySeconds(2);
        password.click();
        password.sendKeys(array[1]);
        WebElement loginButton = Driver.driver.findElement(new By.ByCssSelector("button.n-button.large.block.text-center.-primary"));
        loginButton.click();
        logger.info("user information received");
    }
    public void checkLoginButton(){
        isDisplayed(By.cssSelector("button[class='n-button large block text-center -primary']"));
        logger.info("login button checked");
    }
}






