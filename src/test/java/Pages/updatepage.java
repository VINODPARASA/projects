package Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
 
public class updatepage {
    WebDriver browser; // WebDriver to interact with the browser
 
    // Constructor to initialize WebDriver
    public updatepage(WebDriver browser) {
        this.browser = browser;
    }
 
    // Method to open the edit section for modifying details
    public void openEditSection() throws InterruptedException {
        WebElement editSection = browser.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[9]/div[2]/div[1]/ul[1]/li[7]/a[1]/div[1]/div[2]"));
        editSection.click(); // Click on the edit section
        Thread.sleep(3000); // Wait for the page to load properly
 
        WebElement changeDetailsButton = browser.findElement(By.id("demographics-edit-link"));
        changeDetailsButton.click(); // Click on the button to start editing details
    }
 
    // Method to change the last name of the user
    public void changeLastName(String newLastName) {
        WebElement lastNameField = browser.findElement(By.name("familyName"));
        lastNameField.clear(); // Clear the existing last name
        lastNameField.sendKeys(newLastName); // Enter the new last name
    }
 
    // Method to click the 'Next' button multiple times if needed
    public void pressNextButton(int times) {
        for (int i = 0; i < times; i++) {
            WebElement nextStep = browser.findElement(By.id("next-button"));
            nextStep.click(); // Click on the next button
        }
    }
 
    // Method to confirm and submit the changes
    public void submitChanges() {
        WebElement saveButton = browser.findElement(By.id("registration-submit"));
        saveButton.click(); // Click on the submit button to save changes
    }
}