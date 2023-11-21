package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver= driver;
    }

    private By userNameField = By.id("user-name");
    private By passWordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By pageTitle = By.cssSelector(".login_logo");

    public String getPageTitle(){
        String title = driver.findElement(pageTitle).getText();
        return title;
    }

    public void enterUsername(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void enterPassword(String password){
        driver.findElement(passWordField).sendKeys(password);
    }

    public ProductsPage pressLoginButton(){
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }
}
