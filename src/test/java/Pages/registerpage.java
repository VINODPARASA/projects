package Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
 
public class registerpage {
    public WebDriver driver;
 
    public registerpage(WebDriver driver) {
        this.driver = driver;
    }
 
    public void inputFirstName(String givenName) {
        WebElement givenNameField = driver.findElement(By.name("givenName"));
        givenNameField.sendKeys(givenName);
    }
 
    public void inputLastName(String familyName) {
        WebElement familyNameField = driver.findElement(By.name("familyName"));
        familyNameField.sendKeys(familyName);
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();
    }
 
    public void chooseGender(String gender) {
        WebElement genderDropdown = driver.findElement(By.id("gender-field"));
        new Select(genderDropdown).selectByVisibleText(gender);
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();
    }
 
    public void enterDOB(String day, String month, String year) {
        WebElement birthDayField = driver.findElement(By.id("birthdateDay-field"));
        WebElement birthMonthDropdown = driver.findElement(By.id("birthdateMonth-field"));
        WebElement birthYearField = driver.findElement(By.id("birthdateYear-field"));
 
        birthDayField.sendKeys(day);
        new Select(birthMonthDropdown).selectByVisibleText(month);
        birthYearField.sendKeys(year);
 
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();
    }
 
    public void fillAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();
    }
 
    public void providePhone(String phone) throws InterruptedException {
        WebElement phoneField = driver.findElement(By.name("phoneNumber"));
        phoneField.sendKeys(phone);
        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();
        Thread.sleep(1000);
        nextButton.click();
    }
 
    public void finalizeRegistration() {
        WebElement confirmButton = driver.findElement(By.id("submit"));
        confirmButton.click();
    }
}