package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInTest {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://selenium-examples.nichethyself.com/");
		
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("12345");  //find element by xpath.
		//driver.findElement(By.id("loginpassword")).sendKeys("12345");
		
		//driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();  //find element by xpath.
		
		driver.quit();
	}

}
