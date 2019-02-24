package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TripHoBo {
	WebDriver driver;
	Actions builder;
	WebDriverWait wait;
	String str = "Houston";
	WebElement source;
	WebElement target;

	WebElement laterButton;
	WebElement searchBar;

	WebElement searchLocation;
	String strSearchLocation = "//i[text()=', Texas, United States, North America']";

	WebElement searchButton;

	WebElement fromCity;
	String strFromCity = "//input[@placeholder='Starting City']";
	String startingFromCity = "Pune";
	WebElement searchLocation1;

	WebElement saveAndLetMePlanBtn;

	WebElement skipToPlanBtn1;

	WebElement skipToPlanBtn2;

	WebElement addActivityBtn;

	WebElement activitiesPlan;
	String strActivitiesPlan = "//img[@alt='Museum district Image']";

	WebElement scheduleOnDay;
	String strScheduleOnDay =  "//label[text()='Day 2']";

	WebElement scheduleOnDayClose;

	WebElement activitiesPlanClose;


	@Test
	public void planTrip() throws InterruptedException {

		driver.get("https://www.triphobo.com/");
		builder = new Actions (driver);
		wait = new WebDriverWait(driver,40,150);


		String lbutton = "//button[@onclick='remindNotifyLater();']";
		laterButton =  wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(lbutton))));
		laterButton.click();

		searchBar = driver.findElement(By.id("spl-autocomplete-search"));
		searchBar.sendKeys(str);

		searchLocation = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(strSearchLocation))));
		builder.moveToElement(searchLocation)
		.click().build().perform();

		searchButton = driver.findElement(By.id("plan-my-trip"));
		searchButton.click();


		//Thread.sleep(5000);
		//saveAndLetMePlanBtn = driver.findElement(By.xpath("//button[@data-create-mode='manual']"));
		Set <String> allOpenWindowHandle = driver.getWindowHandles();		

		for(String oneWindowHandle:allOpenWindowHandle){

			driver.switchTo().window(oneWindowHandle);


			if ((driver.findElements(By.xpath("//button[@data-create-mode='manual']")).size())!=0) {

				System.out.println( "Second window");
				//driver.findElement(By.xpath("//button[@data-create-mode='manual']")).click();

				/*fromCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Starting City']")));
		  			fromCity.sendKeys("Pune");

		  			  searchLocation1 = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[text()='Maharashtra, India']"))));
		  			  builder.moveToElement(searchLocation1)
		  			         .click().build().perform();*/

				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='step-1-city-container row step-1-from-city']")));
				//Thread.sleep(5000);
				saveAndLetMePlanBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-create-mode='manual']")));
				saveAndLetMePlanBtn.click(); 


				skipToPlanBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_close_hotel_combine")));
				skipToPlanBtn1.click();

				skipToPlanBtn2 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel_step_popup_skip_hotel")));
				skipToPlanBtn2.click();

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-unique-id='hotel_drawer']")));		  			//addActivity.click();


				addActivityBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_add_activity")));
				addActivityBtn.click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='js_city_elements']")));

				activitiesPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strActivitiesPlan)));
				activitiesPlan.click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='add-to-itin-wrapper']"))); 	

				scheduleOnDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strScheduleOnDay)));
				scheduleOnDay.click();

				scheduleOnDayClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-unique-id='add_day_list_drawer']/div/a[@id='close']")));
				scheduleOnDayClose.click();

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-unique-id='add_day_list_drawer']")));	

				activitiesPlanClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-unique-id='activity_drawer']/div/a[@id='close']")));
				activitiesPlanClose.click();
				//builder.moveToElement(activitiesPlanClose)
				// .click().build().perform();


				source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@title='Museum district']")));
				target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_iti_day_3")));

				builder.dragAndDrop(source, target).build().perform();

				break;

			}
		}


	}
	@BeforeClass
	public void beforeClass() 
	{

		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();


	}

	@AfterClass
	public void afterClass()
	{

		//driver.close();

	}

}
