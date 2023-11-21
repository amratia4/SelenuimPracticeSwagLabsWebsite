package pagesSwagLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    private WebDriver driver;
    public CheckoutInformationPage (WebDriver driver){
        this.driver= driver;
    }

    private By FName = By.id("first-name");
    private By LName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");

    public void enterFName(String firstName){
        driver.findElement(FName).sendKeys(firstName);
    }

    public void enterLName(String lastName){
        driver.findElement(LName).sendKeys(lastName);
    }

    public void enterPostalCode(String postCode){
        driver.findElement(postalCode).sendKeys(postCode);
    }

    public CheckoutOverviewPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver);
    }

}
