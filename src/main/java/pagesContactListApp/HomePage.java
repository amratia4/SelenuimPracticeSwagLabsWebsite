package pagesContactListApp;

import Utlis.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver= driver;
    }

    private By signUpButton = By.id("signup");
    private By userMail = By.id("email");
    private By password = By.id("password");
    private By submitButton = By.id("submit");
    ExplicitWait waitForElement = new ExplicitWait();

    public AddUserPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new AddUserPage(driver);
    }

    public void enterMail(String mail){
        waitForElement.waitTillElementIsVisible(driver , userMail);
        driver.findElement(userMail).sendKeys(mail);
    }

    public void enterPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }

    public ContactListPage clickSubmit(){
        driver.findElement(submitButton).click();
        return new ContactListPage(driver);
    }

}
