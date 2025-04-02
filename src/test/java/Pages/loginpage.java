package Pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class loginpage {
    WebDriver d;
    
    public loginpage(WebDriver d) {
        this.d = d;
    }
    
    public void InvalidCredentials(String uname, String p) {
        WebElement usernameField = d.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordField = d.findElement(By.id("password"));
        WebElement inpatientWard = d.findElement(By.id("Inpatient Ward"));
        WebElement loginButton = d.findElement(By.id("loginButton"));
        
        usernameField.sendKeys(uname);
        passwordField.sendKeys(p);
        inpatientWard.click();
        loginButton.click();
    }
    
    public String getErrorMessageElement() {
        WebElement errorMessage = d.findElement(By.id("error-message"));
        return errorMessage.getText();
    }
    
    public void NullCredentials(String uname, String p) {
        WebElement usernameField = d.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordField = d.findElement(By.id("password"));
        WebElement inpatientWard = d.findElement(By.id("Inpatient Ward"));
        WebElement loginButton = d.findElement(By.id("loginButton"));
        
        usernameField.sendKeys(uname);
        passwordField.sendKeys(p);
        inpatientWard.click();
        loginButton.click();
    }
    
    public void ValidCredentials(String uname, String p) {
        WebElement usernameField = d.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordField = d.findElement(By.id("password"));
        WebElement inpatientWard = d.findElement(By.id("Inpatient Ward"));
        WebElement loginButton = d.findElement(By.id("loginButton"));
        
        usernameField.sendKeys(uname);
        passwordField.sendKeys(p);
        inpatientWard.click();
        loginButton.click();
    }
}