package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestTwo extends BaseTestClass{
	
	@Test
	public void Menubutton() throws Exception {
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try{
		WebElement Menubutton = driver.findElement(By.id("android.widget.ImageButton"));
		Menubutton.click();}
		catch(ElementNotVisibleException e){
		System.out.println("Menu Button not found" + e);	
		TakesScreenshot image = new TakesScreenshot() {
			
			@Override
			public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
				// TODO Auto-generated method stub
				OutputType<File> file = arg0.FILE;
				
				return null;
			}
		};
		}
	}
	
}
