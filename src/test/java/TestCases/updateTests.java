package TestCases;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.loginpage;
import Pages.updatepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
public class updateTests {
    WebDriver browser;
    loginpage loginScreen;
    updatepage editDetailsScreen;
 
    @BeforeClass
    public void setup() throws InterruptedException {
        browser = new ChromeDriver();
        browser.get("https://o2.openmrs.org/openmrs/login.htm");
 
        loginScreen = new loginpage(browser);
        loginScreen.ValidCredentials("admin", "Admin123");
 
        Thread.sleep(3000);
        browser.get("https://o2.openmrs.org/openmrs/coreapps/findpatient/findPatient.page?app=coreapps.findPatient");
 
        WebElement searchBox = browser.findElement(By.id("patient-search"));
        searchBox.sendKeys("100KUL");
 
        Thread.sleep(3000);
        WebElement firstResult = browser.findElement(By.xpath("//table[@id='patient-search-results-table']//tr[1]/td[1]/a"));
        firstResult.click();
 
        Thread.sleep(3000);
        editDetailsScreen = new updatepage(browser);
    }
 
    @Test(priority = 1)
    public void testUpdateLastNameToReddy() throws InterruptedException {
        editDetailsScreen.openEditSection();
        editDetailsScreen.changeLastName("parasa vinod");
        editDetailsScreen.pressNextButton(2);
        editDetailsScreen.submitChanges();
 
        Thread.sleep(3000);
    }
}
 
 
