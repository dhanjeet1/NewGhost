package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		System.out.println("+++++++++++++++++++++Changed +++++++");
		//*******Initializing Local Variables to Data members*********//
	
		
		driver = ConfigFile.getWebDriver(CONFIGFILE);
		
		driver.get(baseurl);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).getText(), "Log in");
		
		//************Take Screenshot**********//
	//	ConfigFile.takeSelfie(driver);
		
		
	}
		
 }
