package pagesContactListApp;

import Utlis.GenerateTestMailsForRegistration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUserPage {
    private WebDriver driver;
    public AddUserPage (WebDriver driver){
        this.driver= driver;
    }

    private By pageHeaderAddUser = By.tagName("h1");
    private By fName = By.id("firstName");
    private By lName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By submitButton = By.id("submit");




    public String validateAddUserPageLoadedSuccessfully(){
        String AddUserPageHeader = driver.findElement(pageHeaderAddUser).getText();
        return AddUserPageHeader;
    }


    public void enterFName(String firstName){
        driver.findElement(fName).sendKeys(firstName);
    }

    public void enterLName (String lastName){
        driver.findElement(lName).sendKeys(lastName);
    }

    public void enterPassword (String formPassword){
        driver.findElement(password).sendKeys(formPassword);
    }

    public void  enterEmail (String mail){
        driver.findElement(email).sendKeys(mail);

    }

    public ContactListPage clickSubmit(){
        driver.findElement(submitButton).click();
        return new ContactListPage(driver);
    }
}
