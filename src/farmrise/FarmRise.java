package farmrise;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FarmRise {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities caps = null;
		AndroidDriver<AndroidElement> driver = null;
		Dimension dim = null;
		Dimension size1 = null;
		
		try {		
			caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "ca7001f");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.1");
			
			
			caps.setCapability("appPackage", "com.climate.farmrise");
			caps.setCapability("appActivity", "com.climate.farmrise.SplashScreen");
			caps.setCapability("noReset", "true");
					
			driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//scenario1 :
			driver.findElement(By.id("com.climate.farmrise:id/checkWeatherDetails")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
					
			dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			//Get my device dimensions
			int n=1;
			while(n<=5)
			{
			driver.swipe(660, 1000, 60, 1000, 3000);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			n=n+1;
			}
			
			System.out.println("Scenario1 completed");

			//scenario2 :
			driver.findElement(By.id("com.climate.farmrise:id/action_more")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("com.climate.farmrise:id/more_govtSchemes")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
				
			size1 = driver.manage().window().getSize();
			System.out.println(size1);
			int starty = (int)(size1.height*0.8);
			int endy = (int)(size1.height *0.01);
			int startx = size1.width/2;
			int endx = size1.width/2;
			
			driver.swipe(startx,starty,endx,endy, 3000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//There is no "Load more schemes button" 
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}