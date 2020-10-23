package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By search  = By.cssSelector("input[name='q']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchBox()
	{
		return driver.findElement(search);
	}
	
	

}
