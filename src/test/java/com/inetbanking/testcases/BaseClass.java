package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseurl=readconfig.getApplicationUrl();
	public String username= readconfig.getUserName();
	public String password= readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfirfoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("ie"))
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver=new InternetExplorerDriver();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}	