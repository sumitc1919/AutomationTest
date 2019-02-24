package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class DropDownTestNG 
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testForDropDown() throws InterruptedException
	{
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		
		WebElement makeddl=driver.findElement(By.name("make"));
		List<WebElement> allOptionMake=makeddl.findElements(By.tagName("option"));
		//Here 1st we find DDL by name 'make' and stored it in WebElement makeddl.
		//then we store all 'option' of 'make' into List<WebElement> type allOptionMake.
		
		//OR
	//	List<WebElement> allOptionMakeAlternate=driver.findElements(By.xpath("//select[@name='make']/option"));
		
		int numOfOption=allOptionMake.size(); //It willreturn size of List of allOptionMake.
		System.out.println("Number Of Option In Make:-"+numOfOption);
		
		Select makeCombo=new Select(makeddl);
		
		makeCombo.selectByVisibleText("Mercedes");
		Thread.sleep(3000);
		makeCombo.selectByIndex(3);
		Thread.sleep(3000);
		makeCombo.selectByValue("audi");
		
		System.out.println(makeCombo.getFirstSelectedOption().getText());
	}

	@AfterMethod
	public void afterMethod() 
	{
	}

}
