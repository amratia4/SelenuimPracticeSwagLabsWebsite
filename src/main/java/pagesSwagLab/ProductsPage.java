package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utlis.ExplicitWait;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage (WebDriver driver){
        this.driver= driver;
    }

    private By appLoga = By.cssSelector(".app_logo");
    private By products = By.cssSelector(".inventory_item_name");
    private String firstProductName;
    ExplicitWait waitForElement = new ExplicitWait();
    public String getFirstProductName() {
        return firstProductName;
    }




    public List<WebElement> getProductsList(){
         return driver.findElements(products);
    }

    public SelectedProductPage clickFirstProduct(){
        List<WebElement> productslist = getProductsList();
        if (!productslist.isEmpty()){
            WebElement firstProduct = productslist.getFirst();
            firstProductName = firstProduct.getText();

            System.out.println(firstProductName + " is selected");
            firstProduct.click();
        } else {
            System.out.println("No Products found");
        }
        return new SelectedProductPage(driver);
    }

    public String getAppLogo(){
        waitForElement.waitTillElementIsVisible(driver,appLoga);
        String applicationLogo = driver.findElement(appLoga).getText();
        return applicationLogo;
    }
}
