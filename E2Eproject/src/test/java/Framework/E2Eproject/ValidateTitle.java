package Framework.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjectrepository.HomePage;
import pageobjectrepository.LoginPage;
import resources.Driver;

public class ValidateTitle extends Driver{
	private static Logger log=LogManager.getLogger(Login.class.getName());
	public WebDriver driver;
	
	@BeforeTest

	public void initializeTest() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	
	}
	
	@Test
	public void valTitle() throws IOException
	{
				
		HomePage hm=new HomePage(driver);
	String actualText=hm.getTitle().getText();
	Assert.assertEquals(actualText, "FEATURED COSES");
	log.info("Successfully verified the title");
		
		
	}
	@Test
	public void valNavBar() throws IOException
	{

		
		HomePage hm=new HomePage(driver);
	boolean value=hm.getNavBar().isDisplayed();
	log.info("Navigation bar is displayed");
	Assert.assertTrue(value, "Navigation bar is not displayed");
	
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
