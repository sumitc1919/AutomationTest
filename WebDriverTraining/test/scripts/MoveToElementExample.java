package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MoveToElementExample 
{
	WebDriver driver;

	@Test
	public void moveElemntMouse() 
	{
		driver.get("https://www.annauniv.edu/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Departments')]")).click();
		
		Actions builder=new Actions(driver);
		
		WebElement moveOnLink=driver.findElement(By.xpath("//a[@id='link3']/strong[contains(text(),' Faculty of Civil Engineering ')]"));
		
		builder.moveToElement(moveOnLink).perform();
		
		WebElement onClick=driver.findElement(By.xpath("//div[@id='menuItemHilite33']"));
		
		builder.click(onClick).build().perform();
		
		String title=driver.getTitle();
		System.out.println("Title:-"+title);
		
		assertEquals(title,"Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts");
	
		WebElement moveResearchLink=driver.findElement(By.xpath("//div[@class='toplink']/a[@id='link3']"));
		
		builder.moveToElement(moveResearchLink).build().perform();
		
		WebElement goOn=driver.findElement(By.xpath("//div[@id='menuItemHilite12']"));
		
		builder.click(goOn).build().perform();
		
		String title2=driver.getTitle();
		System.out.println("Title2:-"+title2);
		
		assertEquals(title2,"404 Not Found");
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
