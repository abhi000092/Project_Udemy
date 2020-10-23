package resources;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	static String CommonOriginalHandle=null;
	
	public static void maximizeWindow (WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public static void waitForPageLoad (WebDriver driver)
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) 
			{
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver,80);
		try 
		{
			wait.until(expectation);
		}
		catch(Throwable error) 
		{
			System.out.println("Timeout waiting for Page Load Request to complete.");
		}
	}
	
	public static boolean VerifyChecked(WebDriver driver, By locator)
	{
		WebElement field = driver.findElement(locator);
		if(field.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void refreshPage (WebDriver driver) throws Exception
	{
		driver.navigate().refresh();
		waitForPageLoad(driver);
	}
	
	public static void SwitchToSecondWindow(WebDriver driver) throws Exception
	{
		String  originalHandle = driver.getWindowHandle();
		String sWindowTitle =driver.getTitle();
		Set<String> availableWindows = driver.getWindowHandles();
		System.out.println("Number of widnows = "+driver.getWindowHandles().size());

		if (!availableWindows.isEmpty()) {

			for (String windowId : availableWindows)
			{
				driver.switchTo().window(windowId);
				waitForPageLoad(driver);
				if(!driver.getWindowHandle().equals(CommonOriginalHandle))
				{
					Thread.sleep(1000);
					System.out.println(driver.getTitle());															
				}	
				else 
				{
					driver.switchTo().window(originalHandle).getTitle().equals(sWindowTitle);
				}
			}			
		}
	}
	
	public static void driver_close(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
	driver.close();
	}
	
	public static void driver_quit(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		}

}
