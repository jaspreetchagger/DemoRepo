package config;

import org.openqa.selenium.By;
import static executionEngine.DriverScript.OR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProviders.ConfigfileReader;

public class ActionKeywords {
	//here we will create static methods for actions
	public static WebDriver driver;
	
	public static void oPenBrowser(String Object) 
	{
		driver=new FirefoxDriver();
	}
	public static void navigate(String Object)
	{
		driver.get(Constants.URL);
	}
	
	public static void click(String Object)
	{
		System.out.println(Object);
		System.out.println(ConfigfileReader.getORProperties(Object));
		driver.findElement(By.xpath(ConfigfileReader.getORProperties(Object))).click();
		
	}
	
	public static void input_Username(String Object) {
		driver.findElement(By.xpath(ConfigfileReader.getORProperties(Object))).sendKeys(Constants.username);
	}
	public static void input_Password(String Object) {
		driver.findElement(By.xpath(ConfigfileReader.getORProperties(Object))).sendKeys(Constants.password);
	}
	public static void quit(String Object) {
		driver.quit();
	}

}
