package JavaScriptExecutor.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementHighlight {
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
	@Test()
	public void elementHighlight() throws InterruptedException
	{
		js=((JavascriptExecutor)driver);
		WebElement ele=driver.findElement(By.linkText("Sign in"));
		WebElement ele1=driver.findElement(By.linkText("Gmail"));
		js.executeScript("arguments[0].style.border='5px solid black'", ele);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.background='red'", ele1);
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
