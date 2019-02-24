package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class GmailNewTab 
{
	WebDriver driver;

	@Test
	public void gmailTab() 
	{
		driver.get("https://www.google.co.in/");

		String mainTab=driver.getWindowHandle(); //It Will Point to Main Window of Site.

		WebElement gmailLink=driver.findElement(By.linkText("Gmail"));

		Actions builder=new Actions(driver);

		builder.keyDown(Keys.CONTROL).click(gmailLink).keyUp(Keys.CONTROL).build().perform();


		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(1)); 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement emailid= driver.findElement(By.id("identifierId"));
		emailid.sendKeys("chandelsumit1919");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9665171919");
		driver.findElement(By.id("passwordNext")).click();
		
		driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		
		driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		
		driver.switchTo().window(mainTab);
		
		driver.findElement(By.name("q")).sendKeys("Selenium Jobs In Pune");
		
		driver.findElement(By.name("btnK")).click();

	}


	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver=new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() 
	{
	}

}
