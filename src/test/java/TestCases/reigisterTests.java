package TestCases;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.loginpage;
import Pages.registerpage;
 
public class reigisterTests {
    public static WebDriver webDriver;
    registerpage pp;
    loginpage l;
   
    @BeforeClass
    public void initialize() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("https://o2.openmrs.org/openmrs/login.htm");
        
        // Perform login before proceeding to registration
        l = new loginpage(webDriver);
        l.ValidCredentials("admin", "Admin123");
        
        Thread.sleep(3000); // Wait for login to complete
        
        // Navigate to the patient registration page
        webDriver.get("https://o2.openmrs.org/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient");
        pp = new registerpage(webDriver);
    }
 
    @Test(priority = 1)
    public void verifyPatientRegistration() throws InterruptedException {
        Thread.sleep(3000);
        pp.inputFirstName("vinod");
        pp.inputLastName("parasa");
        pp.chooseGender("male");
        pp.enterDOB("21", "March", "1998");
        pp.fillAddress("124 Main Street eluru");
        pp.providePhone("7879943210");
        pp.finalizeRegistration();
        
        Thread.sleep(5000);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("patientId"), "Patient registration failed.");
    }
}
 
 