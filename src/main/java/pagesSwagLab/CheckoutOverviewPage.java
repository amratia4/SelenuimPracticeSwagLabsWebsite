package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;
    public CheckoutOverviewPage (WebDriver driver){
        this.driver= driver;
    }

    private By productNameCheckoutOverview = By.className("inventory_item_name");
    private By productPriceCheckoutOverview = By.className("inventory_item_price");
    private By tax = By.className("summary_tax_label");
    private By totalPrice = By.xpath("//div[contains(@class,'summary_total_label')]");
    private By finishButton = By.id("finish");

    public String getProductNameCheckoutOverviewPage(){
        String productNameCheckoutOverviewPage = driver.findElement(productNameCheckoutOverview).getText();
        return productNameCheckoutOverviewPage;
    }

    public String getProductPriceCheckoutOverview(){
        String productPriceCheckoutOverviewPage = driver.findElement(productPriceCheckoutOverview).getText();
        return productPriceCheckoutOverviewPage;
    }

    public String getTax(){
        String taxCheckoutOverviewPage = driver.findElement(tax).getText();
        return taxCheckoutOverviewPage;
    }

    public String getTotalPrice(){
        String totalPriceCheckoutOverviewPage = driver.findElement(totalPrice).getText();
        return totalPriceCheckoutOverviewPage;
    }

    public CheckoutCompletePage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver);
    }

}
