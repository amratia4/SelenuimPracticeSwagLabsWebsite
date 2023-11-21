package baseSwagLab;
import Utlis.Links;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import pagesSwagLab.HomePage;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseTests {
    protected  WebDriver driver;
    protected HomePage homePage;



    @BeforeClass
    public void setUp(){
        setChromeDriverProperty();
        driver = new ChromeDriver();
        driver.get(Links.HOME);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(),"Swag Labs");
        homePage.enterUsername("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.pressLoginButton();

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


    //taking a screen shoot
    public void takeScreenshot(ITestResult result) throws IOException {
        //the if statement in case we want to take the screenshot only in case of test cases failing
        // if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        String directory = "resources/screenshots/";
        File dir = new File(directory);
        //check that the screenshot directory is available if not create new one
        if (!dir.exists()) dir.mkdir();
        Files.move(screenshot, new File("resources/screenshots/"+ result.getName() + ".png"));
        // }
    }

    private static void setChromeDriverProperty(){
        System.setProperty("webdriver.chrome.driver","/Users/aatia@tripactions.com/Documents/DrlrnuimPractice/SeleniumPractice/rescourses/chromedriver");
    }


}