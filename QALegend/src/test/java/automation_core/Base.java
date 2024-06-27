package automation_core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	public void initialiseBrowser(String browser)
	{
		if(browser.equals("Chrome"))
				{
			        driver=new ChromeDriver();
				}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{	
			throw new RuntimeException("Invalid Browser");
		}
		 driver.get("https://qalegend.com/billing/public/login");
		 driver.manage().window().maximize();
	}
    @BeforeMethod
	@Parameters("browser")
	public void setUp(String browser_name)
	{
		initialiseBrowser(browser_name);
	} 
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenshot(result);
		}
		driver.close();
	}
	public void takeScreenshot(ITestResult result) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot)driver;
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+result.getName()+".png"));
	}

}
