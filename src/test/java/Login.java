import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
	@Test (priority=1)
	public void verifyLoginWithValidCreditials() {

		WebDriverManager.chromedriver().setup();

		// Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver;

		// Add 'options' as argument
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

		driver.quit(); // Close Browser
	}

	@Test (priority=2)
	public void verifyLoginWithInvalidCreditials() {

		WebDriverManager.chromedriver().setup();

		// Code for Chrome Security Issue
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver;

		// Add 'options' as argument
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("FAKE@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("696969696");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissibl')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));

		driver.quit(); // Close Browser
	}
	
	@Test
	public String generateEmailTimeStamp() {

		Date date = new Date();
		System.out.println(date);
		System.out.println(date.toString().replace(" ", "_").replace(":", " ") + "@gmail.com"); 
		return date.toString().replace(" ", "_").replace(":", " ") + "@gmail.com";
	}

}
