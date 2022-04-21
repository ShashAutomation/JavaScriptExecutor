package JavaScriptExecutor.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TypekeysAndclick {
	WebDriver driver;
	JavascriptExecutor js;
	@BeforeMethod
	public void chromeLaunch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		
	}
	@Test(priority=2)
	public void click() throws InterruptedException
	{
		js=((JavascriptExecutor)driver);
		WebElement element=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		WebElement element1=driver.findElement(By.xpath("//input[@class='gNO89b']"));
		js.executeScript("arguments[0].value='facebook';", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", element1);
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
