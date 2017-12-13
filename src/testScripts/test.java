package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.ConfigFile;


public class test
{
	private WebDriver driver;
	


	
	@Test
	@Parameters({"CONFIGFILE", "baseurl"})
    public void login(String CONFIGFILE, String baseurl) throws InterruptedException
	{
		//*******Initializing Local Variables to Data members*********//
	
		driver = ConfigFile.getWebDriver(CONFIGFILE);
		
		driver.get(baseurl);
		Thread.sleep(2000);
		WebElement gmailLink = driver.findElement(By.xpath("//*[contains(text(),'Gmail')]"));
		System.out.println(gmailLink.getText());
		Assert.assertEquals(gmailLink.getText(), "Gmail");
		
		//************Take Screenshot**********//
	//	ConfigFile.takeSelfie(driver);
		
		
	}
		
 }
