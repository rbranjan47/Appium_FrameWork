package Page_Data;


import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Swipe_Data 
{
	AndroidDriver<AndroidElement> driver;
	//intializing the driver
	public Swipe_Data(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}
	
	//android elements page factory
	private static By draggable_button = MobileBy.AndroidUIAutomator("text(\"DRAGGABLE (MINIMAL)\")");
	private static By items_name = MobileBy.AndroidUIAutomator("text(\"Item 1\")");
	
	public AndroidElement draggable() {
		return driver.findElement(draggable_button);
	}
	
	public AndroidElement items() {
		return driver.findElement(items_name);
	}
}
