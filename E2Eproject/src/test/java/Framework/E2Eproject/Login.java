package Framework.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjectrepository.ForgotPasswordPage;
import pageobjectrepository.HomePage;
import pageobjectrepository.LoginPage;
import resources.Driver;


public class Login extends Driver {
	private static Logger log=LogManager.getLogger(Login.class.getName());
	public WebDriver driver;
@BeforeTest
public void initializeTest() throws IOException
{
	driver=initializeDriver();
	log.info("driver is initiliazed");
	


}
@Test(dataProvider = "getloginData")
public void loginTest(String username, String password, String text) throws IOException
{
	driver.get(prop.getProperty("url"));
	HomePage hm=new HomePage(driver);
	LoginPage lp=hm.getLoginLink();
	
	lp.getUsernameEdtBox().sendKeys(username);
	lp.getPasswordEdtBox().sendKeys(password);
	lp.getloginBtn().click();
	ForgotPasswordPage fp=lp.getforgetPwdLink();
	fp.getemailIdEdtBox().sendKeys(username);
	fp.getsendMeBtn().click();
	log.info(text);

	
}

@AfterTest
public void tearDown()
{
	driver.close();
}

@DataProvider
public Object[][] getloginData()
{
	//Row defines how many combinations (how many times test case executes)
	//Column defines how much data is there in each combination (Data in each execution)
	Object[][] data= new Object[2][3];
	
	//0th Row
	data[0][0]="nonrestricteduser@gmail.com";
    data[0][1]="nonrestrict123";
    data[0][2]= "Non restricted user";
    
	//first Row
	data[1][0]="restricteduser@gmail.com";
    data[1][1]="restrict123";
    data[1][2]= "restricted user";
    
    return data;
	
}

}
