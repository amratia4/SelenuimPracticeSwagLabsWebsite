package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {
    private WebDriver driver;
    public YourCartPage (WebDriver driver){
        this.driver= driver;
    }

    private By productNameCart = By.className("inventory_item_name");
    private By productPriceCart = By.className("inventory_item_price");
    private By checkoutButton = By.id("checkout");


    public String getProductNameCart (){
       String  productNameInCartPage = driver.findElement(productNameCart).getText();
       return productNameInCartPage;
    }

    public String getProductPriceCart(){
        String productPriceInCartPage = driver.findElement(productPriceCart).getText();
        return productPriceInCartPage;
    }

    public CheckoutInformationPage clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
        return new CheckoutInformationPage(driver);
    }
}
