package pagesSwagLab;

import Utlis.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectedProductPage {
    private WebDriver driver;
    public SelectedProductPage (WebDriver driver){
        this.driver= driver;
    }

    private By productName = By.cssSelector(".inventory_details_name");
    private By productPrice = By.cssSelector(".inventory_details_price");
    private By addToCartButton = By.xpath("//button[contains(@id,'add-to-cart')]");
    private By removeButton = By.xpath("//button[contains(@id,'remove')]");
    private By shoppingCartBagde = By.cssSelector(".shopping_cart_badge");

    ExplicitWait waitForElement = new ExplicitWait();

    public String  getSelectedProductName (){
        waitForElement.waitTillElementIsVisible(driver,productName);
        String  selectedProductName = driver.findElement(productName).getText();
        return selectedProductName;
    }

    public String getSelectedProductPrice(){
        waitForElement.waitTillElementIsVisible(driver,productPrice);
        String selectedProductPrice= driver.findElement(productPrice).getText();
        System.out.println("Item Price: " + selectedProductPrice);
        return selectedProductPrice;
    }

    public void clickAddToCartButton(){
        waitForElement.waitTillElementIsVisible(driver,addToCartButton);
        driver.findElement(addToCartButton).click();
    }

    public String getRemoveButton(){
        waitForElement.waitTillElementIsVisible(driver,removeButton);
        String remove = driver.findElement(removeButton).getText();
        return remove;
    }

    public String getShoppingCartBadgeNumber (){
        waitForElement.waitTillElementIsVisible(driver,shoppingCartBagde);
        String shoppingBadgeNumber = driver.findElement(shoppingCartBagde).getText();
        return shoppingBadgeNumber;
    }

    public YourCartPage clickShoppingCartBadge(){
        waitForElement.waitTillElementIsVisible(driver,shoppingCartBagde);
        driver.findElement(shoppingCartBagde).click();
        return new YourCartPage(driver);
    }


}
