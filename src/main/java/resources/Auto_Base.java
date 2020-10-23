package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Auto_Base {

	public WebDriver driver;
	public Properties prop = new Properties();

	public WebDriver intializeDriver() throws IOException
	{
		String currentDir= getDir("\\src\\main\\java\\resources\\GlobalData.properties");
		FileInputStream fis = new FileInputStream(currentDir);
		prop.load(fis);
		String browserName= prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			String chromePath=getDir("\\driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromePath);

			 driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String firefoxPath=getDir("\\driver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", firefoxPath);
			 driver = new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("IE"))
		{
			String IEPath =getDir("\\driver\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", IEPath);
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}

	public static String getDir(String path)
	{
		String currentDir=System.getProperty("user.dir")+path;
		return currentDir;

	}

}
