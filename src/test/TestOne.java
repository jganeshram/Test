package test;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestOne extends BaseTestClass {

	@Test
	public void closebutton() throws Exception {
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try{
		WebElement closebutton = driver.findElement(By.id("com.flipkart.fkreader:id/close_btn"));
		closebutton.click();}
		catch(ElementNotVisibleException e){
		System.out.println("Close Button not found" + e);	
		}
	}
	
}