package baseContactListApp;

import Utlis.Links;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pagesContactListApp.HomePage;

public class BaseTestsForContactListApp {
    protected WebDriver driver;
    protected HomePage homePage;

    protected static String registeredUserMail;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aatia@tripactions.com/Documents/DrlrnuimPractice/SeleniumPractice/rescourses/chromedriver");
        driver = new ChromeDriver();
        driver.get(Links.NEWHOME);
        driver.manage().window().maximize();
        homePage = new pagesContactListApp.HomePage(driver);
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
