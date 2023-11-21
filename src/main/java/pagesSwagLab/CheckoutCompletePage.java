package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;
    public CheckoutCompletePage (WebDriver driver){
        this.driver= driver;
    }

    private By successMessage = By.className("complete-header");
    private By backHomeButton = By.id("back-to-products");

    public String getSuccessMessage(){
        String successMessageCheckoutCompletePage = driver.findElement(successMessage).getText();
        return successMessageCheckoutCompletePage;
    }

    public ProductsPage clickBackHomeButton(){
        driver.findElement(backHomeButton).click();
        return new ProductsPage(driver);
    }
}
