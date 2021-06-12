package pageobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
public WebDriver driver;
public HomePage(WebDriver driver)
{
	this.driver=driver;
}

By loginLink=By.xpath("//span[text()='Login']");

public LoginPage getLoginLink()
{
	driver.findElement(loginLink).click(); //Kept click operation and object creation in object repository to avoid 
	//multiple object creation inside the test case. this concept can be used if we have multiple pages in singe test case.
	LoginPage lp=new LoginPage(driver); 
	return lp;
}

By title=By.xpath("//h2[text()='Featured Courses']");
public WebElement getTitle()
{
	return driver.findElement(title);
}

By navBar=By.xpath("//ul[contains(@class, 'navbar-nav')]");

public WebElement getNavBar()
{
	return driver.findElement(navBar);
}

By header=By.cssSelector("div[class*='video-banner'] h3");
public WebElement getHeader()
{
	return driver.findElement(header);
	
}

}
