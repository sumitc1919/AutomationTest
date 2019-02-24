package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WebTableTest 
{
	WebDriver driver;
	
  @Test
  public void webTableOperation() 
  {
	  driver.get("http://the-internet.herokuapp.com/tables");
	  
	  WebTable table=new WebTable(driver.findElement(By.id("table2")));
	  
	  System.out.println("Row Count:-"+table.getRowCount());
	  
	  System.out.println("Column Count:-"+table.getColCount());
	  
	  System.out.println("Data:-"+table.getCellData(2, 2));
	  
	  table.clickOnDelete("Action", "jdoe@hotmail.com");
	  
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
