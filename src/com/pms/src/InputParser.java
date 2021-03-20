package com.pms.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class InputParser {
	public static String CreateUserName;
	public static String CreateUserEmail;
	public static String CreateUserPassword;	
	public static String LOGINPASSWORD;
	public static String SleepTime;
	public static String AmazonRegLink;
	public static String AmazonSignInLink;
	public static String BrowserName;
	public static String SearchBoxXpath;
	public static String SearchSubmitXpath;
	public static String UserNameXpath;
	public static String UserEmailXpath;
	public static String UserPasswordXpath;
	public static String UserRePasswordXpath;
	public static String CreateUserSubmitXpath;
	public static String ChromePath;
	public static String SignInUserPhone;
	public static String SignInUserPass;
	public static String SignInPasswordXpath;
	public static String SignInPasswordSubmitXpath;
	public static String AddtoCartXpath;
	public static String AmazonProductLink;
	public static String ProductNameToSearch;
	public static String NegativeScenarioText1;
	public static String NegativeScenarioText2;
	public static String NegativeScenarioText3;
	public static String NegativeScenarioText4;
 
	public void getPropValues(String propFileName) throws IOException { 
		try {
			File file = new File(propFileName);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				switch(key){
					case "Chrome_Path":		
						ChromePath = properties.getProperty(key);
						break;
					case "Create_User_Name":		
						CreateUserName = properties.getProperty(key);
						break;
						
					case "Create_User_Email":		
						CreateUserEmail = properties.getProperty(key);
						break;			
						
					case "Create_User_Password":		
						CreateUserPassword = properties.getProperty(key);	
						break;
					
					case "Amazon_Registration_Link":			
						AmazonRegLink = properties.getProperty(key);	
						break;
						 	
					case "User_Name_Xpath":		
						UserNameXpath = properties.getProperty(key);
						break;
						
					case "User_Email_Xpath":		
						UserEmailXpath = properties.getProperty(key);
						break;			
						
					case "User_Password_Xpath":		
						UserPasswordXpath = properties.getProperty(key);	
						break;
					
					case "User_RePassword_Xpath":			
						UserRePasswordXpath = properties.getProperty(key);	
						break;
						
					case "Create_User_Submit_Xpath":			
						CreateUserSubmitXpath = properties.getProperty(key);	
						break;
						
					case "Browser_Name":			
						BrowserName = properties.getProperty(key);	
						break;	
						
					case "Amazon_SignIn_Link":			
						AmazonSignInLink = properties.getProperty(key);	
						break;
						
					case "Sleep_Time_After_TC_Execution":			
						SleepTime = properties.getProperty(key);	
						break;
						
					case "Search_Box_Xpath":			
						SearchBoxXpath = properties.getProperty(key);	
						break;
						
					case "Search_Submit_Xpath":			
						SearchSubmitXpath = properties.getProperty(key);	
						break;	
						
					case "SignIn_User_Phone":			
						SignInUserPhone = properties.getProperty(key);	
						break;	
						
					case "SignIn_User_Pass":			
						SignInUserPass = properties.getProperty(key);	
						break;	
						
					case "SignIn_Password_Xpath":			
						SignInPasswordXpath = properties.getProperty(key);	
						break;
						
					case "SignIn_Password_Submit_Xpath":			
						SignInPasswordSubmitXpath = properties.getProperty(key);	
						break;
					
					case "AddtoCart_Xpath":			
						AddtoCartXpath = properties.getProperty(key);	
						break;
						
					case "Amazon_Product_Link":			
						AmazonProductLink = properties.getProperty(key);	
						break;
						
					case "Product_To_Search":			
						ProductNameToSearch = properties.getProperty(key);	
						break;
						
					case "Negative_Scenario_Text1":			
						NegativeScenarioText1 = properties.getProperty(key);	
						break;
					
					case "Negative_Scenario_Text2":			
						NegativeScenarioText2 = properties.getProperty(key);	
						break;
						
					case "Negative_Scenario_Text3":			
						NegativeScenarioText3 = properties.getProperty(key);	
						break;
						
					case "Negative_Scenario_Text4":			
						NegativeScenarioText4 = properties.getProperty(key);	
						break;
								
				}				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
