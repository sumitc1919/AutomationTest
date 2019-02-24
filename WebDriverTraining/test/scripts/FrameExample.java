package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
public class FrameExample 
{
	WebDriver driver;
  @Test
  public void frameSwitchExample()
  {
	  driver.get("http://toolsqa.com/iframe-practice-page/iframe-practice");
	  
	  try
	  {
		  driver.switchTo().frame("IF1");
		  
		  driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sumit");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Chandel");

			System.out.println("First Name:-"+driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value"));
			System.out.println("Last Name:-"+driver.findElement(By.xpath("//input[@name='lastname']")).getAttribute("value"));

			List<WebElement> genderRadio=driver.findElements(By.xpath("//input[@name='sex']"));

			for(WebElement oneGender:genderRadio)
			{
				if(oneGender.getAttribute("value").contains("Male"))
					oneGender.click();
			}

			List<WebElement> expRadio=driver.findElements(By.name("exp"));

			for(WebElement oneExp:expRadio)
			{
				if(oneExp.getAttribute("value").contains("1"))
					oneExp.click();
			}

			driver.findElement(By.id("datepicker")).sendKeys("20/12/1992");

			WebElement manual=driver.findElement(By.id("profession-0"));
			if(!manual.isSelected())
				manual.click();

			WebElement automation=driver.findElement(By.id("profession-1"));
			if(!automation.isSelected())
				automation.click();

			WebElement seleniumIDE=driver.findElement(By.id("tool-1"));
			if(!seleniumIDE.isSelected())
				seleniumIDE.click();

			WebElement SeleniumWD=driver.findElement(By.id("tool-2"));
			if(!SeleniumWD.isSelected())
				SeleniumWD.click();

			WebElement contdll=driver.findElement(By.name("continents"));
			List<WebElement> contin=contdll.findElements(By.xpath("//select[@id='continents']/option"));
			Select selCont=new Select(contdll);
			selCont.selectByVisibleText("Asia");
			System.out.println("Continents:-"+selCont.getFirstSelectedOption().getText());
			
			driver.switchTo().parentFrame(); //Go to Main Frame which contain another frames.
			//OR
			//driver.switchTo().defaultContent();

	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Frame Available");
		  e.printStackTrace();
	  }
	  
	  try
	  {
		  WebElement iframee=driver.findElement(By.id("IF2"));
		  driver.switchTo().frame(iframee);
		  driver.findElement(By.xpath("//*[@id='post-1']/footer/p[1]/a")).click();
		  
	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Frame Available");
		  e.printStackTrace();
	  }
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
