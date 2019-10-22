package ForPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesHandling {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\yoga\\eclipse-workspace\\inetBankingV1\\Drivers\\geckodriver.exe" );
		WebDriver driver =new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
		
		driver.findElement(By.xpath("//a[contains(text(),'Python Tutorial')]")).click();
	}

}
