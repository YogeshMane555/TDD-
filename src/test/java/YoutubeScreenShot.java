import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YoutubeScreenShot {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		rm=new ChromeDriver();
		
		rm.manage().window().maximize();
		
		rm.manage().deleteAllCookies();
		
		rm.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		rm.get("https://www.youtube.com/");
	
	}
	
	@Test
	public void tc1() throws IOException
	{
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		

		File Src=tk.getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(Src, new File("C://Users//Admin//eclipse-workspace//TDD//Screenshot.jpg"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		rm.close();
		
	}
	
	
	
	
}
