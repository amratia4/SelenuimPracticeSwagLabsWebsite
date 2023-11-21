package pagesContactListApp;

import Utlis.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactListPage {

    private WebDriver driver;
    public ContactListPage (WebDriver driver){
        this.driver= driver;
    }

    private By contactListHeader = By.tagName("h1");
    private By logOut = By.id("logout");

    ExplicitWait waitForElement = new ExplicitWait();


    public String validateContactListPageLoadedSuccessfully(){
        waitForElement.waitTillElementIsVisible(driver , contactListHeader);
        String contactListPageHeader = driver.findElement(contactListHeader).getText();
        return contactListPageHeader;
    }

    public WebElement validateLogoutButtonPresent(){
        waitForElement.waitTillElementIsVisible(driver,logOut);
        WebElement logOutButton = driver.findElement(logOut);
        return logOutButton;
    }

}
