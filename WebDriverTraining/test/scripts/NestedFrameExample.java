package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NestedFrameExample 
{
	WebDriver driver;
	
  @Test
  public void nestedFrame() 
  {
	  driver.get("http://the-internet.herokuapp.com/frames");
	  
	  driver.findElement(By.linkText("Nested Frames")).click();
	  
	  try
	  {
		  driver.switchTo().frame("frame-top");
		  driver.switchTo().frame("frame-left");
		  String frameText=driver.findElement(By.xpath("//html/body[contains(text(),'LEFT')]")).getText();
		  System.out.println(frameText);
		  assertEquals(frameText,"LEFT");
		  driver.switchTo().defaultContent();
	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Such Frame Found");
		  e.printStackTrace();
	  }
	  
	  try
	  {
		  driver.switchTo().frame("frame-top");
		  driver.switchTo().frame("frame-middle");
		  String frameText=driver.findElement(By.id("content")).getText();
		  System.out.println(frameText);
		  assertEquals(frameText,"MIDDLE");
		  driver.switchTo().defaultContent();
	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Such Frame Found");
		  e.printStackTrace();
	  }
	  
	  try
	  {
		  driver.switchTo().frame("frame-top");
		  driver.switchTo().frame("frame-right");
		  String frameText=driver.findElement(By.xpath("//html/body[contains(text(),'RIGHT')]")).getText();
		  System.out.println(frameText);
		  assertEquals(frameText,"RIGHT");
		  driver.switchTo().defaultContent();
	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Such Frame Found");
		  e.printStackTrace();
	  }
	  
	  try
	  {
		  driver.switchTo().frame("frame-bottom");
		  String frameText=driver.findElement(By.xpath("//html/body[contains(text(),'BOTTOM')]")).getText();
		  System.out.println(frameText);
		  assertEquals(frameText,"BOTTOM");
		  driver.switchTo().defaultContent();
	  }
	  catch(NoSuchFrameException e)
	  {
		  fail("No Such Frame Found");
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
