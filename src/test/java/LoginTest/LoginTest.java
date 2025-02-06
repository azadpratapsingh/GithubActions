package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	
	
	@Test(priority=0)
	public void initiateDriver() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver sd = new ChromeDriver();
	sd.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);
	String pageTitle= sd.getTitle();
	Assert.assertEquals("OrangeHRM", pageTitle);
	
	boolean isBrandingLogoAvailable = sd.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	System.out.println("Is branding logo available?: "+isBrandingLogoAvailable);
	Assert.assertTrue(isBrandingLogoAvailable, "Branding logo is available");
	
	boolean isLoginLogoAvailable = sd.findElement(By.xpath("//img[@alt='orangehrm-logo']/parent::div[@class='orangehrm-login-logo']")).isDisplayed();
	System.out.println("Is branding logo available?: "+isLoginLogoAvailable);
	Assert.assertTrue(isLoginLogoAvailable, "Login logo is available");
	
	Thread.sleep(5000);
	sd.quit();
	}
	
	
}
