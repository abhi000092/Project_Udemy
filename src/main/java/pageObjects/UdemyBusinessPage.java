package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.CommonFunctions;

public class UdemyBusinessPage {

	public WebDriver driver;

	By UdemyBussPage=By.xpath("//form[contains(@action,'courses')]/following-sibling::div[1]/a/span[contains(text(),'Business')]");
	By invalidErrMsg=By.xpath("//div[@id='ValidMsgEmail']");
	By emailTextBox =By.id("Email");
	By submit = By.xpath("//button[@type='submit']");

	public UdemyBusinessPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement navigateToUdemyBusiness()
	{
		CommonFunctions.waitForPageLoad(driver);
		return driver.findElement(UdemyBussPage);

	}

	public void captureErrMsg(String email) throws Exception
	{
		try
		{
			CommonFunctions.SwitchToSecondWindow(driver);

			driver.findElement(emailTextBox).sendKeys(email);

			Thread.sleep(3000);

			driver.findElement(submit).sendKeys(Keys.ENTER);

			Thread.sleep(3000);

			String errMsg=driver.findElement(invalidErrMsg).getText();
			System.out.println("Captured Err Msg:"+errMsg);
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
}
