package Udemy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.UdemyBusinessPage ;
import resources.Auto_Base;
import resources.CommonFunctions;

public class TC2 extends Auto_Base {
	
	@BeforeTest
	public void basePageNavigation() throws IOException  {
		driver=intializeDriver();
		CommonFunctions.maximizeWindow(driver);
		String url=prop.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void udemy_TC2() throws Exception {

		try
		{
			UdemyBusinessPage ubp = new UdemyBusinessPage(driver);

			ubp.navigateToUdemyBusiness().click();

			ubp.captureErrMsg("test_gmail.com");

		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
			Assert.fail("Udemy_TC2 Failed");
		}

	}
	
	@AfterTest
	public void quit() throws InterruptedException
	{
	CommonFunctions.driver_quit(driver);
	}
}
