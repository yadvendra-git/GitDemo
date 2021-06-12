package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	By usernameEdtBox=By.cssSelector("input[id='user_email']");
	By passwordEdtBox=By.id("user_password");
	By loginBtn=By.cssSelector("input[class*='login-button']");
	By forgetPwdLink= By.linkText("Forgot Password?");
	
	
	public WebElement getUsernameEdtBox() {
		return driver.findElement(usernameEdtBox);
	}
	public WebElement getPasswordEdtBox() {
		return driver.findElement(passwordEdtBox);
	}
	
	public WebElement getloginBtn() {
		return driver.findElement(loginBtn);
	}
	public ForgotPasswordPage getforgetPwdLink()
	{
		driver.findElement(forgetPwdLink).click();
		ForgotPasswordPage fp=new ForgotPasswordPage(driver);
		return fp;
	}
	
}
