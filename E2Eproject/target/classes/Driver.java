package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {

//loading properties file
	prop = new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser"); //This step will take browser from data.properties file
	//String browserName=System.getProperty("browser"); //Use this for taking browser parameter from maven command
	System.out.println(browserName);
	if (browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browser\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		driver = new ChromeDriver(options);
		

	}
	else if (browserName.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browser\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if (browserName.equalsIgnoreCase("ie"))
	{
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browser\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	return driver;
	
	}
	
}
	