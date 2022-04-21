package JavaScriptExecutor.JavaScriptExecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {

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
	public void dropdrowntest() throws InterruptedException
	{
		driver.navigate().to("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		js=((JavascriptExecutor)driver);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getSize());
			if(list.get(i).getText().equals("HTML"))
			{
				js.executeScript("arguments[0].style.background='red'",list.get(i));
			break;
			}
		
		}
		
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
