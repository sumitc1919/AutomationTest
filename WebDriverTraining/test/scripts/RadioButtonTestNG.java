package scripts;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class RadioButtonTestNG 
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void redioButtonTest() throws InterruptedException
	{
		driver.get("http://cookbook.seleniumacademy.com/Config.html");

		WebElement petrolRadio=driver.findElement(By.cssSelector("input[value='Petrol']"));
		petrolRadio.click(); //Click on Petrol radio Button on Page.

		Thread.sleep(5000);

		assertTrue(petrolRadio.isSelected());  //if(petrolRadio.isSelected()),
		//'it will return true if Radio button is selected o.w. return false'

		Thread.sleep(3000);

		List<WebElement> allRadioButton=driver.findElements(By.name("fuel_type")); 
		//List of all radio button which 'name' attribute have fuel_type. 

		for(WebElement oneRadioButton:allRadioButton)
		{
			/*if(!oneRadioButton.isSelected());
				oneRadioButton.click();*/

			//OR

			if(oneRadioButton.getAttribute("value").contains("Diesel"))
				oneRadioButton.click();
		}
	}


	@AfterMethod
	public void afterMethod()
	{
	}

}
