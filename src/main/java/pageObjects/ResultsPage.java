package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import resources.CommonFunctions;

public class ResultsPage {

	public WebDriver driver;

	By level = By.xpath("//input[@value='beginner']/parent::label");
	By verifyBegCheckBox= By.xpath("//input[@value='beginner']");
	By languageDropDown= By.xpath("//span[text()='Language']/parent::button");
	By language =By.xpath("//input[@value='en']/parent::label");
	By verifyEngCheckBox= By.xpath("//input[@value='en']");
	By listOfFilteredCourses=By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div");
	By courseName1 =By.xpath("");

	By label =By.xpath("//fieldset[@name='Topic']/label");
	By learningLanguages = By.xpath("//fieldset[@name='Language']/label");
	By expandLanguageList =By.xpath("//span[text()='Language']/ancestor::h3/parent::div/following-sibling::div//span[text()='Show more']");
	By expertiseLevel = By.xpath("//fieldset[@name='Level']/label");

	By navigateHomePage= By.xpath("//a[contains(@class,'logo')]/img");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLevel()
	{

		return driver.findElement(level);

	}

	public void verifyBegCheckbox() throws InterruptedException
	{
		try
		{
			Thread.sleep(5000);
			Boolean b=CommonFunctions.VerifyChecked(driver, verifyBegCheckBox);

			if(b==true)
			{
				System.out.println("Beginner Checkbox is selected succesfully");
			}
			else
			{
				System.out.println("Failed To Select Beginner Level Checkbox");
				Assert.fail("Failed To Select Beginner Level Checkbox");
			}
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	public WebElement clicklanguageDropDown() throws InterruptedException
	{
		
			Thread.sleep(5000);
			CommonFunctions.waitForPageLoad(driver);
			return driver.findElement(languageDropDown);
	}

	public WebElement getlanguage()
	{
		return driver.findElement(language);
	}

	public void verifyEngCheckbox() throws InterruptedException
	{
		try
		{
		Thread.sleep(5000);
		Boolean b=CommonFunctions.VerifyChecked(driver, verifyEngCheckBox);

		if(b==true)
		{
			System.out.println("English Checkbox is selected succesfully");
		}
		else
		{
			System.out.println("Failed To Select English language checkbox");
			Assert.fail("Failed To Select English language Checkbox");
		}
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	public void get2CourseDetails()
	{
		try
		{
		List<WebElement> list=driver.findElements(listOfFilteredCourses);

		for(int i=1;i<list.size();i++)
		{
			if(i==1)
			{
				String courseName1=driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//div[contains(@class,'course-title')]")).getText();
				System.out.println("First Course Name:"+courseName1);

				String rating = driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//span[contains(@class,'rating-number')]")).getText();
				System.out.println("First Course Rating:"+rating);

				String learningHours = driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//div[contains(@class,'course-card--course-meta-info')]/span[1]")).getText();
				System.out.println("First Course Learning Hours:"+learningHours);
			}

			if(i==2) {
				String courseName1=driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//div[contains(@class,'course-title')]")).getText();
				System.out.println("Second Course Name:"+courseName1);

				String rating = driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//span[contains(@class,'rating-number')]")).getText();
				System.out.println("Second Course Rating:"+rating);

				String learningHours = driver.findElement(By.xpath("//div[contains(@class,'filtered-course-list')]//div[2]//div[contains(@class,'course-list')]/div["+i+"]//div[contains(@class,'course-card--course-meta-info')]/span[1]")).getText();
				System.out.println("Second Course Learning Hours:"+learningHours);

				break;
			}
		}
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	public void getAllLanguages()
	{
		try
		{
		driver.findElement(expandLanguageList).click();

		List<WebElement> languagelist=driver.findElements(learningLanguages);

		int count = 0;
		for(int i=0;i<languagelist.size();i++)
		{
			String langlist=languagelist.get(i).getText();
			System.out.println("Learning languages:"+langlist);
			count++;
		}

		System.out.println("Total Languages:"+count);
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	public void getAllLevels()
	{
		try
		{
		List<WebElement> levellist=driver.findElements(expertiseLevel);
		int levelcount = 0;
		for(int i=0;i<levellist.size();i++)
		{
			String llist =levellist.get(i).getText();
			System.out.println("Levels:"+llist);
			levelcount++;
		}

		System.out.println("Total Levels:"+levelcount);
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	public void navigatehomePage()
	{
		driver.findElement(navigateHomePage).click();
	}

}
