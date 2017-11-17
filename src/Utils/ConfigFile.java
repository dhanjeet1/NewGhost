package Utils;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfigFile {

	private static HashMap<String, String> globalVars = new HashMap<String, String>();
	private static HashMap<String, WebDriver> driverList = new HashMap<String, WebDriver>();
	private static int SScount=0;
	
	public static WebDriver getWebDriver(String user_access) {
		if (driverList.containsKey(user_access)) {
			return driverList.get(user_access);
		}
		else {
			//System.setProperty("webdriver.ie.driver","H:\\Testing Softwares\\Selenium\\Driver_Servers\\IE\\IEDriverServer.exe");
			//WebDriver ldriver = new InternetExplorerDriver();
			
       // 	System.setProperty("webdriver.chrome.driver", "src/Utils/chromedriver");
        //	ChromeOptions options = new ChromeOptions();
    	//	options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
    	//	WebDriver ldriver = new ChromeDriver(options);
        //	WebDriver ldriver = new ChromeDriver();
        	
			System.setProperty("phantomjs.binary.path", "src/Utils/phantomjs.exe");
        	WebDriver ldriver = new PhantomJSDriver();	
			
		//	HtmlUnitDriver ldriver = new HtmlUnitDriver();
			
//			File pathToBinary = new File("/usr/bin/firefox");
//			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//			FirefoxProfile firefoxProfile = new FirefoxProfile();       
//			WebDriver ldriver= new FirefoxDriver(ffBinary,firefoxProfile);
			
		//	WebDriver ldriver = new FirefoxDriver();
			ldriver.manage().window().maximize();
			ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driverList.put(user_access, ldriver);
			return ldriver;
			
		}
	}

	public static void closeWebDriver(String user_access) {
		if (driverList.containsKey(user_access)) {
			driverList.get(user_access).quit();
			driverList.remove(user_access);
		}
	}

	public static void setVar(String key, String value) {
		globalVars.put(key,value);
	}

	public static String getVar(String key) {
		if (globalVars.containsKey(key)){
			return globalVars.get(key);
		}
		return key;
	}

	public static String getUniqueStr8() {
		Calendar cal = Calendar.getInstance();
		String exp;
		exp = "" + cal.get(Calendar.DATE) + cal.get(Calendar.MONTH) + cal.get(Calendar.HOUR) + cal.get(Calendar.MINUTE);
		return (exp);
	}
	
	public static void takeSelfie(WebDriver driver) 
	{
        String fname = "Screen Captured\\Sample\\Selfie_" + SScount++ + ".png";
        try
		{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(fname));
		}
		catch(Exception e)
		{
			System.out.println("error in selfie!");
			System.out.println(e.getMessage());
		}
        
     
      
	}
}