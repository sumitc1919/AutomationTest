package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class AssignmentDDL 
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void testAllElement() throws InterruptedException
	{
		driver.get("http://toolsqa.com/automation-practice-form");

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
		
		WebElement multiSelect=driver.findElement(By.id("selenium_commands"));
		Select command=new Select(multiSelect);
		assertTrue(command.isMultiple());
		command.selectByIndex(0);
		command.selectByVisibleText("Switch Commands");
		command.selectByVisibleText("WebElement Commands");
		command.selectByVisibleText("Wait Commands");
		Thread.sleep(3000);
		command.deselectByVisibleText("Wait Commands");
		
		assertEquals(command.getAllSelectedOptions().size(),3);
		
		driver.findElement(By.id("submit")).click();
		
		

	/*	List<String> expContDll=new ArrayList();
		expContDll.add("Europe");
		expContDll.add("Africa");
		expContDll.add("Asia");
		expContDll.add("Australia");
		expContDll.add("South America");
		expContDll.add("North America");
		expContDll.add("Antartica");
		
		 <option>Europe</option>
		 * <option>Africa</option>
		 * <option>Asia</option>
		 * <option>Australia</option>
		 * <option>South America</option>
		 * <option>North America</option>
		 * <option>Antartica</option>
		
		String[] expList={"Europe","Africa","Asia","Australia","South America","North America","Antartica"};
		List<WebElement> actContin=contdll.findElements(By.xpath("//select[@id='continents']/option"));
		//List<WebElement> option=selCont.getOptions();
		
		for(WebElement optlist:option)
		{
			for(int i=0;i<expList.length;i++)
			{
				assertEquals(optlist.getAttribute("value").equals(expList[i].valueOf(i)),"Order Match");
			}
		}
		
		System.out.println(actContin.equals(expList));*/

	}


	@AfterMethod
	public void afterMethod()
	{
	}

}
