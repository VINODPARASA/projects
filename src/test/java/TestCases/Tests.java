package TestCases;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.loginpage;
 
public class Tests {
    WebDriver driver;
    
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
    }
    
    @Test
    public void invalidlogin() {
        loginpage login = new loginpage(driver);
        login.InvalidCredentials("adminn", "Admin123");
        
        String actualErrMsg = login.getErrorMessageElement();
        String expErrMsg= "Invalid username/password. Please try again.";
        
        Assert.assertEquals(actualErrMsg, expErrMsg, "Mismatch in error message.");
    }
    
    @Test
    public void nullLogin() {
        loginpage login = new loginpage(driver);
        login.NullCredentials("", "");
        
        String actualErrMsg = login.getErrorMessageElement();
        String expErrMsg = "Invalid username/password. Please try again.";
        
        Assert.assertEquals(actualErrMsg, expErrMsg, "Mismatch in error message.");
    }
    
    @Test
    public void ValidLogin() {
        loginpage login = new loginpage(driver);
        login.ValidCredentials("admin", "Admin123");
        
        String expectedTitle = "Home";
        String actualTitle = driver.getTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match.");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
 