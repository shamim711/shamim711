package com.pms.src;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Execution {
	public static WebDriver driver;
	public static boolean result;
	
	
	public void init(String BrowserName,String TC) throws InterruptedException, IOException{
		InputParser properties = new InputParser();
		properties.getPropValues(System.getProperty("user.dir") + "\\config\\qa.properties");
		properties.getPropValues(System.getProperty("user.dir") + "\\config\\xpath");	
		properties.getPropValues(System.getProperty("user.dir") + "\\config\\userInput");
				
		Date currentDate = new Date(System.currentTimeMillis());
        String epoch = currentDate.getTime() + "";
        
	    
		if(BrowserName == "Chrome"){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + InputParser.ChromePath);
			driver = new ChromeDriver(options);
		}else if(BrowserName == "FireFox"){
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
		if(TC == "TC1"){
			driver.get(InputParser.AmazonRegLink);
			Thread.sleep(1000);		
			type(InputParser.UserNameXpath, InputParser.CreateUserName);
			String emailID = InputParser.CreateUserEmail.replace("@",epoch+"@");
			//System.out.println(emailID);
			
			type(InputParser.UserEmailXpath, emailID);
			type(InputParser.UserPasswordXpath, InputParser.CreateUserPassword);
			type(InputParser.UserRePasswordXpath, InputParser.CreateUserPassword);
			click("id", InputParser.CreateUserSubmitXpath);
			Thread.sleep(Integer.parseInt(InputParser.SleepTime));
			driver.get(InputParser.AmazonProductLink);
			type(InputParser.SearchBoxXpath, InputParser.ProductNameToSearch);
			click("id", InputParser.SearchSubmitXpath);
			Thread.sleep(1000);			
			textLinkClick(InputParser.ProductNameToSearch);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(1000);
			click("id", InputParser.AddtoCartXpath);
			Thread.sleep(Integer.parseInt(InputParser.SleepTime));
		}		
		else if(TC == "TC2"){
			driver.get(InputParser.AmazonRegLink);
			Thread.sleep(Integer.parseInt(InputParser.SleepTime));	
			click("id", InputParser.CreateUserSubmitXpath);
			Thread.sleep(Integer.parseInt(InputParser.SleepTime));
			Assert(InputParser.NegativeScenarioText1);
			Assert(InputParser.NegativeScenarioText2);
			Assert(InputParser.NegativeScenarioText3);
			Assert(InputParser.NegativeScenarioText4);
			Thread.sleep(Integer.parseInt(InputParser.SleepTime));
		}
		driver.close();
		
	}
	public void type(String xpath, String text) {
		try{
			System.out.println("Log success  - " + text);
			driver.findElement(By.id(xpath)).sendKeys(text);		
		}catch(AssertionError  e){
			System.out.println("Log failed type - ");
		}
		
	}
	public void textLinkClick(String text) {
		try{
			System.out.println("Log success  - " + text);
			driver.findElement(By.linkText(text)).click();		
		}catch(AssertionError  e){
			System.out.println("Log failed type - ");
		}
		
	}
	public void click(String isXpath, String text) {
		try{
			System.out.println("Log success click - " + text);
			if(isXpath.equals("xpath")){
				driver.findElement(By.xpath(text)).click();
			}
			else if(isXpath.equals("id")){
				driver.findElement(By.id(text)).click();			
			}
		}catch(AssertionError  e){
			System.out.println("Log failed click - ");
		}
	}
	private boolean verify(String text) {
		result = (driver.getPageSource().contains(text));
		return result;
	}
	
	public void Assert(String text) {
		try{
			Assert.assertTrue(verify(text));
			System.out.println("Log success --- ");
		}catch(AssertionError e){
			System.out.println("Log failed  --- ");
		}
	}
}
