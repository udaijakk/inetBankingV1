package ForPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\yoga\\eclipse-workspace\\inetBankingV1\\Drivers\\geckodriver.exe");
		
		WebDriver driver =new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.xpath("//a[@id='cn-accept-cookie']")).click();
		
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\yoga\\Desktop\\Uday kiran.pdf");

	}

}
