package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {
	public AndroidDriver driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/app");
		File app = new File(appDir, "flip.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4");
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://10.1.1.182:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
	}
	/*protected  void takeScreenShot(String name,WebDriver d)
	{
		try {
			// get screen shot 
			String screenshot ="c:\\test\\rwdTest"+name+".jpg";
			File screenshotFile = new File(screenshot);

			WebDriver augment = new Augmenter().augment(d);
			TakesScreenshot shot = (TakesScreenshot) augment;
			File file = shot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, screenshotFile);
			_imagesList.add(new ImageDetails(name,_exePlatform,screenshot) );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	@AfterMethod
	public void teardown() {
		// close the app
		driver.quit();
	}
}
