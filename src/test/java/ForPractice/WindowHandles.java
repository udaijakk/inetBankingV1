package ForPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\yoga\\eclipse-workspace\\inetBankingV1\\Drivers\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Go Test')]")).click();
		
		Set<String> handler=driver.getWindowHandles();
		
		Iterator<String> it=handler.iterator();
		
		String parentWindowID=it.next();
		System.out.println("parentWindowID: " +parentWindowID );
		
		String childWindowID=it.next();
		System.out.println("childWindowID: " + childWindowID );
		
		driver.switchTo().window(childWindowID);
		Thread.sleep(2000);
		
		System.out.println("childWindowID name: " + driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parentwindowID name: " + driver.getTitle());
		
		driver.close();
		
		

	}

}
