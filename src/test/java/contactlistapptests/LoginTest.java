package contactlistapptests;

import baseContactListApp.BaseTestsForContactListApp;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestsForContactListApp {


    public void LoginTests(){
        homePage.enterMail("");
        homePage.enterPassword("Testing123");
        var contactPage = homePage.clickSubmit();
    }
}
