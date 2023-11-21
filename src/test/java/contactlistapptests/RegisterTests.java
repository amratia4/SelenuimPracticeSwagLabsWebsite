package contactlistapptests;

import Utlis.GenerateTestMailsForRegistration;
import baseContactListApp.BaseTestsForContactListApp;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesContactListApp.AddUserPage;

public class RegisterTests extends BaseTestsForContactListApp {




    @DataProvider(name="testdata")
    public static Object[][] testMail(){
        return new Object[][]{{GenerateTestMailsForRegistration.generateRandomMail(),"Testing123"}};
    }

    @Test (dataProvider = "testdata")
    public void registerNewUserTest(String userMail, String password){
        var register = homePage.clickSignUp();
        Assert.assertEquals(register.validateAddUserPageLoadedSuccessfully(),"Add User");
        register.enterFName("testFName");
        register.enterLName("testLName");
        register.enterEmail(userMail);
        register.enterPassword(password);
       var contactList =  register.clickSubmit();
       Assert.assertNotNull(contactList.validateLogoutButtonPresent());
       Assert.assertEquals(contactList.validateContactListPageLoadedSuccessfully(),"Contact List");
        registeredUserMail = userMail;
    }

    @Test (dependsOnMethods = {"registerNewUserTest"})
    public void LoginTests(){
        homePage.enterMail(registeredUserMail);
        homePage.enterPassword("Testing123");
        var contactPage = homePage.clickSubmit();
        Assert.assertEquals(contactPage.validateContactListPageLoadedSuccessfully(),"Contact List");
    }
}
