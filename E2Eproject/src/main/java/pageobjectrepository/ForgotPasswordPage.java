package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By emailIdEdtBox=By.id("user_email");
	By sendMeBtn = By.cssSelector("input[name='commit']");



	public WebElement getemailIdEdtBox()
	{
		return driver.findElement(emailIdEdtBox);
	}
	

	public WebElement getsendMeBtn()
	{
		return driver.findElement(sendMeBtn);
	}
}
