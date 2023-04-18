package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //1 Enter "standard user" username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        //  Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //  Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //  Verify the text “PRODUCTS”
        String expectedText = "Products";
        WebElement actualTextOnWebPage = driver.findElement(By.className("title"));
        String actualText = actualTextOnWebPage.getText();
        Assert.assertEquals("PRODUCT text not displayed", expectedText, actualText);
    }

    @Test

    public void verifyThatSixProductsAredisplayedOnPage() {

        //2 Enter "standard_user" username

        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        //  Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");
        //  Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //  Verify that six products are displayed on page
        int expectedNumberOfProducts = 6;
        List<WebElement> productList = driver.findElements(By.xpath("//img[starts-with(@class,'inventory_item_img')]"));
        int actualNumberOfProducts = productList.size();
        Assert.assertEquals("Number of Products are not same", expectedNumberOfProducts, actualNumberOfProducts);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
