package appium.appium_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.util;

public class base_class 
{
	public static AndroidDriver<AndroidElement> driver = null;
	public static Properties properties;
	public static WebDriverWait wait;
	public static AndroidElement element;
	
	//starting server 
	public void startServer()
	{
		util.startServer();
	}
	// constructor
	public  base_class() 
	{
		try
		{
			properties= new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\global.properties");
			properties.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		 catch(IOException e)
		{
			 e.printStackTrace();
		}	
	}
	
	public static void initialization() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities capabilties = new DesiredCapabilities();
		capabilties.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//device platform name
		String device_platoform = System.getProperty("device_platform");
		capabilties.setCapability(MobileCapabilityType.PLATFORM_NAME, device_platoform);
		//android type
		String android_version = System.getProperty("android_version");
		capabilties.setCapability(MobileCapabilityType.PLATFORM_VERSION, android_version);
		//device name
		String device_name = properties.getProperty("device_name");
		capabilties.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		
		//locating app path
		File app_directory = new File("src");
		//casting into string as we are getting value into string format
		File app_path = new File(app_directory,(String) properties.getProperty("app_name"));
		capabilties.setCapability(MobileCapabilityType.APP, app_path.getAbsolutePath());
		//each time no need to install
		capabilties.setCapability(MobileCapabilityType.NO_RESET, true);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilties);
		
		driver.manage().timeouts().implicitlyWait(util.timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(util.pageload, TimeUnit.SECONDS);

	}
}
