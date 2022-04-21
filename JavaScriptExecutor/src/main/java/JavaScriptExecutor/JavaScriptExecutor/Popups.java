package JavaScriptExecutor.JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Popups {
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
	public void websitePopups() throws InterruptedException
	{
		
		driver.navigate().to("https://www.adobe.com/acrobat/pdf-reader.html");
		WebElement header= driver.findElement(By.tagName("div"));
		String headerValue= header.getText();
		System.out.println("Header of pop up is :"+headerValue);
		WebElement element3=driver.findElement(By.linkText("Continue to India"));
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element3);
		Thread.sleep(5000);
		
		
		
	}@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
