package utilities;

import java.net.ServerSocket;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class util  {
		public static long timeout = 10;
		public static long pageload = 15;
		
		public AndroidDriver<AndroidElement> driver;
		
		public util(AndroidDriver<AndroidElement> driver)
		{
			this.driver = driver;
		}

		//checking appium server
		public static boolean checkifServerRunning(int port)
		{
			boolean isServerRunning = false;
			ServerSocket serversocket;
			
			try
			{
				serversocket = new ServerSocket();
				//closing the already running server socket
				serversocket.close();
			}
			catch(Exception e)
			{
				//if serever is not running then it will true
				isServerRunning = true;
			}
			finally {
				serversocket = null;
			}
			return isServerRunning;
		}
		
		//starting appium server
		public static AppiumDriverLocalService startServer() {
			AppiumDriverLocalService service = null ;
			boolean flag = checkifServerRunning(4723);
			if (!flag)
			{
				service = AppiumDriverLocalService.buildDefaultService();
				service.start();
				
			}
				return service;	
		}
}
