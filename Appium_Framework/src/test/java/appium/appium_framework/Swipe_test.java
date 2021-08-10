package appium.appium_framework;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Swipe_test extends base_class{
	//closing all the ports before starting 
	@BeforeTest
	public void killAll_ports() throws IOException {
		Runtime.getRuntime().exec("task /f /IM node.exe");
	}
	
	@Test
	public void swipe_right_left()
	{
		
	}
}
