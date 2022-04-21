package JavaScriptExecutor.JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowscroll {
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
	public void windowScroll() throws InterruptedException
	{
		js=((JavascriptExecutor)driver);
		driver.navigate().to("https://www.figma.com/");
		Thread.sleep(2000);
		WebElement element4=driver.findElement(By.xpath("//a[contains(text(),'Meet FigJam →')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",element4);
		System.out.println(element4.getText());
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element4)).click();
	    Thread.sleep(5000);
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
