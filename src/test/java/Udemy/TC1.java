package Udemy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ResultsPage;
import resources.Auto_Base;
import resources.CommonFunctions;

public class TC1 extends Auto_Base {

	public WebDriver driver;
	
	@BeforeTest
	public void basePageNavigation() throws IOException  {
		driver=intializeDriver();
		CommonFunctions.maximizeWindow(driver);
		String url=prop.getProperty("url");
		driver.get(url);
	}

	@Test
	public void udemy_TC1() throws IOException, InterruptedException
	{
		try
		{
			HomePage lp = new HomePage(driver);

			ResultsPage rp = new ResultsPage(driver);


			//Search For Web development Course
			lp.getSearchBox().sendKeys("Web Develpoment",Keys.ENTER);


			//Select Beginner level
			rp.getLevel().click();

			rp.verifyBegCheckbox();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			//expand language dropdown
			rp.clicklanguageDropDown().click();

			//Select  english language level
			rp.getlanguage().click();

			rp.verifyEngCheckbox();

			//Get First2CourseDetails
			rp.get2CourseDetails();

			//get all languages count
			rp.getAllLanguages();

			//get all levels count
			rp.getAllLevels();

			rp.navigatehomePage();

		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
			Assert.fail("Udemy_TC1 Failed");
		}
	}
	
	@AfterTest
	public void close() throws InterruptedException
	{
	CommonFunctions.driver_close(driver);
	}
}
