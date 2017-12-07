package com.web.tests.rallyhood;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.innominds.team.frameworkengine.Constants;
import com.innominds.team.frameworkengine.PageActionUtils;
import com.innominds.team.utils.PropertyFileUtils;

import io.appium.java_client.AppiumDriver;

public class RHhome extends PageActionUtils {
	

	Logger logger = LogManager.getLogger(RHhome.class.getName());

	/** Login into Rallyhood Application */	
	
	public void TestCaseDescription(RHhomeDP dp, WebDriver driver, String s) {
		Reporter.log(s, true);
	}


	public void Rallyhood_Mobileview(RHhomeDP dp, WebDriver driver, String BrowserName) {
		try {
				waitForPageLoaded(driver);
				Robot robot = new Robot();
				switch (BrowserName) {
				case "firefox":
					 System.out.println("RallyHood script execution Started");
					 Reporter.log("RallyHood Login URL", true);
					 Reporter.log("........Rallyhood Login Application........", true);
					 waitForPageLoaded(driver);
					 //Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					 robot.keyPress(KeyEvent.VK_SHIFT);
					 robot.keyPress(KeyEvent.VK_M);
					 // CTRL+Shift+M is now pressed (receiving application should see a "key down" event.)
					 robot.keyRelease(KeyEvent.VK_M);
					 robot.keyRelease(KeyEvent.VK_SHIFT);
					 robot.keyRelease(KeyEvent.VK_CONTROL);
					 waitForPageLoaded(driver);
					 break;
				
				case "chrome":
					 System.out.println("RallyHood script execution Started");
					 Reporter.log("RallyHood Login URL", true);
					 Reporter.log("........Rallyhood Login Application........", true);
					 waitForPageLoaded(driver);
					// Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					 robot.keyPress(KeyEvent.VK_SHIFT);
					 robot.keyPress(KeyEvent.VK_I);
					 // CTRL+Shift+I is now pressed (receiving application should see a "key down" event.)
					 robot.keyRelease(KeyEvent.VK_I);
					 robot.keyRelease(KeyEvent.VK_SHIFT);
					 robot.keyRelease(KeyEvent.VK_CONTROL);
					 waitForPageLoaded(driver);
					 
					 robot.keyPress(KeyEvent.VK_CONTROL);
					 robot.keyPress(KeyEvent.VK_SHIFT);
					 robot.keyPress(KeyEvent.VK_M);
					 // CTRL+Shift+M is now pressed (receiving application should see a "key down" event.)
					 robot.keyRelease(KeyEvent.VK_M);
					 robot.keyRelease(KeyEvent.VK_SHIFT);
					 robot.keyRelease(KeyEvent.VK_CONTROL);
					 waitForPageLoaded(driver);
					 
					 
					 break;
					
				case "ie":
					System.out.println("RallyHood script execution Started");
					 Reporter.log("RallyHood Login URL", true);
					 Reporter.log("........Rallyhood Login Application........", true);
					 waitForPageLoaded(driver);
					// Robot robot = new Robot();
					 robot.keyPress(KeyEvent.VK_CONTROL);
					 robot.keyPress(KeyEvent.VK_SHIFT);
					 robot.keyPress(KeyEvent.VK_I);
					 // CTRL+Shift+M is now pressed (receiving application should see a "key down" event.)
					 robot.keyRelease(KeyEvent.VK_I);
					 robot.keyRelease(KeyEvent.VK_SHIFT);
					 robot.keyRelease(KeyEvent.VK_CONTROL);
					 waitForPageLoaded(driver);
					 break;
					
				case "edge":
					
				}	
		}catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}	}
	
	
	
	
	public void Rallyhood_HomeScreen_Events_HeaderDisplay(RHhomeDP dp, WebDriver driver) {
			try { 
				waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "RHEventLable", driver));
				if(getWebElement(dp.or, "RHEventLable", driver).isDisplayed()) {
					String eventlabletext = getWebElement(dp.or, "RHEventLable", driver).getText();
					//Assert.assertEquals(eventlabletext, dp.td.get("LableText"));
					Assert.assertTrue(eventlabletext.equals(dp.td.get("LableText")), "Events are displayed on the screen");
					Reporter.log("Rallyhood home scree have Event header", true);
				}	
				 } catch (Exception e) {
				Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());
			}}
	
	
	
	public void Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHGroupsClassesLable", driver));
			if(getWebElement(dp.or, "RHGroupsClassesLable", driver).isDisplayed()) {
				String GroupClasseslabletext = getWebElement(dp.or, "RHGroupsClassesLable", driver).getText();
				//Assert.assertEquals(eventlabletext, dp.td.get("LableText"));
				Assert.assertTrue(GroupClasseslabletext.equals(dp.td.get("LableText2")), "Events are displayed on the screen");
				Reporter.log("Rallyhood home scree have Groups and Classes header", true);
			}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());
		}}
	
	
	
	
	public void RallyHood_ClickOnEvent_EventsListed(RHhomeDP dp, WebDriver driver) {
	try {	//Thread.sleep(5000);
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home scree have Events Listed and Clickable", true);
			}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	public void RallyHood_ClickOnGroupClasses_GroupClassesListed(RHhomeDP dp, WebDriver driver) {
		try { //Thread.sleep(5000);
				waitForPageLoaded(driver);
				pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
				if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
					click(getWebElement(dp.or, "RHClasses", driver));
					Thread.sleep(2000);
					Reporter.log("Rallyhood home scree have Groups and Classes Listed and Clickable", true);
				}	
				 } catch (Exception e) {
				Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	public void PageUp(RHhomeDP dp, WebDriver driver) throws AWTException {
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_PAGE_UP);
		 robot.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	
	public void PageDown(RHhomeDP dp, WebDriver driver) throws AWTException {
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		 robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
	
	
	public void pointingDownElements(RHhomeDP dp, WebDriver driver, WebElement we) throws Exception {
		WebElement element = we;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	
	public void pointingUpElements(RHhomeDP dp, WebDriver driver, WebElement we) throws Exception {
		WebElement element = we;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		Thread.sleep(500); 
	}
	
	
	public void WaitForElement(RHhomeDP dp, WebDriver driver, WebElement we) throws InterruptedException{
		for(int i=0;i<=5000;i++) {
			boolean Bwe= we.isDisplayed();
			if(Bwe==true) {
				System.out.println("WebElement is present");
				break;}}}
	
	public void WaitForElement_Click(RHhomeDP dp, WebDriver driver, WebElement we) throws InterruptedException{
		for(int i=0;i<=5000;i++) {
			boolean Bwe= we.isDisplayed();
			boolean Bwe1= we.isEnabled();
			if(Bwe==true && Bwe1==true) {
				System.out.println("WebElement is present");
				break;}}}
	
	
	public void VerifyInvalid_app_uid(RHhomeDP dp, WebDriver driver) {
		waitForPageLoaded(driver);
		driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=d2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fb276e4a4d19dd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
		waitForPageLoaded(driver);
		driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=c56135b1ad2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fb276e4a4d19dd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
		waitForPageLoaded(driver);
		
		//validateion code for the error message
	}
	
	
	public void VerifyInvalid_secret_key(RHhomeDP dp, WebDriver driver) {
		waitForPageLoaded(driver);
		driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=c56135b1ad2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
		waitForPageLoaded(driver);
		driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=c56135b1ad2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fb276e4a4d19dd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
		waitForPageLoaded(driver);
		//Validation code for the error message
	}
	
	

	//To Verify total number of Events Present and if all the events are clickable or NOT.
	public void Multiple_RallyHood_ClickOnEvent_EventsListed_Verified(RHhomeDP dp, WebDriver driver) {
		try {	
			//Thread.sleep(5000);
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=c56135b1ad2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fb276e4a4d19dd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
				Thread.sleep(5000);
		}	
		 } catch (Exception e) {
		Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	//To Verify total number of Groups Present and if all the groups are clickable or NOT.
		public void Multiple_RallyHood_ClickOnGroups_GroupsListed_Verified(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				waitForPageLoaded(driver);
				List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
				int MultiEventsSize = MultiEvents.size();
				Reporter.log("Rallyhood Total Groups Present is:: "+MultiEventsSize , true);
				for(int i=1; i<=MultiEventsSize;i++) {
					String xpthaString = "(//a[@class='rally ember-view'])"+"["+i+"]";
					WebElement we = driver.findElement(By.xpath(xpthaString));
					pointingDownElements(dp, driver, we);
					we.click();
					Reporter.log("Rallyhood Groups #"+i+" is present and Clickable", true);
					Thread.sleep(5000);
					driver.get("https://staging.rallyhood.com/partners/authenticate?app_uid=c56135b1ad2572e212e99d373793b1be97930cfac77935a6dbea459893124382&secret_key=7d607b8ab90edc3853519e2fb276e4a4d19dd34714ee0368d4247336128a756f&auth_id=1311&first_name=Kiran&last_name=Kumar&timezone=America/Chicago&redirect_url=https://staging.rallyhood.com/health-and-wellness/home");
					Thread.sleep(5000);
			}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
			
		
		//To Verify presence of Event name, Event Date and respective Event Image
				public void MultipleEvents_Rallyhood_EventName_Date_image_Present(RHhomeDP dp, WebDriver driver) {
					try {	
						//Thread.sleep(5000);
						waitForPageLoaded(driver);
						List<WebElement> MultiEventsDate = driver.findElements(By.xpath("(//a[@class='event ember-view']//div[@class='date'])"));
						int MultiEventsDateSize = MultiEventsDate.size();
						Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsDateSize , true);
						
						for(int i=1; i<=MultiEventsDateSize;i++) {
							String xpathString = "(//a[@class='event ember-view']//div[@class='date'])"+"["+i+"]";
							String xpathString1="(//a[@class='event ember-view']//div[@class='title'])"+"["+i+"]";
							String xpathString2 = "(//a[@class='event ember-view'])"+"["+i+"]";
							
							WebElement we = driver.findElement(By.xpath(xpathString));
							WebElement we1= driver.findElement(By.xpath(xpathString1));	
							WebElement we2= driver.findElement(By.xpath(xpathString2));
							
							pointingDownElements(dp, driver, we);
							String EventDateval = we.getText();
							String EventNameval = we1.getText();
							String EventImageval = we2.getAttribute("href");
							if(EventDateval!=null) {
								Assert.assertTrue(true, "Rallyhood Event date is present");
								Reporter.log("Rallyhood Event Date for Event #"+i+" is : "+EventDateval, true);
							}else {Reporter.log("Rallyhood Event Date for Event #"+i+" is NOT present ", true);}
							
							if(EventNameval!=null) {
								Assert.assertTrue(true, "Rallyhood Event Name is present");
								Reporter.log("Rallyhood Event Name for Event #"+i+" is : "+EventNameval, true);
							}else {Reporter.log("Rallyhood Event Name for Event #"+i+" is NOT present ", true);}
							
							if(EventImageval!=null) {
								Assert.assertTrue(true, "Rallyhood Event Image is present");
								Reporter.log("Rallyhood Event Image for Event #"+i+" is present ", true);
							}else {Reporter.log("Rallyhood Event Image for Event #"+i+" is NOT present ", true);}
							
							Reporter.log("******************************************************" , true);
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
					
	
	
				//To Verify presence of Event name, Event Date and respective Event Image for a single event
				public void SingleEvent_Rallyhood_EventName_Date_image_Present(RHhomeDP dp, WebDriver driver) {
					try {	
						//Thread.sleep(5000);
						waitForPageLoaded(driver);	
							WebElement we = getWebElement(dp.or, "EventDate", driver);
							WebElement we1= getWebElement(dp.or, "EventName", driver);	
							WebElement we2= getWebElement(dp.or, "EventImage", driver);
							
							pointingDownElements(dp, driver, we);
							String EventDateval = we.getText();
							String EventNameval = we1.getText();
							String EventImageval = we2.getAttribute("href");
							
							if(EventDateval!=null) {
								Assert.assertTrue(true, "Rallyhood Event date is present");
								Reporter.log("Rallyhood Event Date for Event is"+EventDateval, true);
							}else {Reporter.log("Rallyhood Event Date for Event is NOT present ", true);}
							
							if(EventNameval!=null) {
								Assert.assertTrue(true, "Rallyhood Event Name is present");
								Reporter.log("Rallyhood Event Name for Event is : "+EventNameval, true);
							}else {Reporter.log("Rallyhood Event Name for Event is NOT present ", true);}
							
							if(EventImageval!=null) {
								Assert.assertTrue(true, "Rallyhood Event Image is present");
								Reporter.log("Rallyhood Event Image for Event is present ", true);
							}else {Reporter.log("Rallyhood Event Image for Event is NOT present ", true);}
							
							Reporter.log("******************************************************" , true);
						
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
				//To Verify presence of Group name, Group Date and respective Group Image
				public void MultipleGroups_Rallyhood_GroupName_MembersCount_image_Present(RHhomeDP dp, WebDriver driver) {
					try {	
						//Thread.sleep(5000);
						waitForPageLoaded(driver);
						List<WebElement> MultiGroupNames = driver.findElements(By.xpath("(//a[@class='rally ember-view']//div[@class='title'])"));
						int MultiGroupNamesSize = MultiGroupNames.size();
						Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupNamesSize , true);
						
						for(int i=1; i<=MultiGroupNamesSize;i++) {
							String xpathString = "(//a[@class='rally ember-view']//div[@class='title'])"+"["+i+"]";
							String xpathString1="(//a[@class='rally ember-view']//div[@class='stats'])"+"["+i+"]";
							String xpathString2 = "(//a[@class='rally ember-view'])"+"["+i+"]";
							
							WebElement we = driver.findElement(By.xpath(xpathString));
							WebElement we1= driver.findElement(By.xpath(xpathString1));	
							WebElement we2= driver.findElement(By.xpath(xpathString2));
							
							pointingDownElements(dp, driver, we);
							String GroupNameval = we.getText();
							String GroupMemCountval = we1.getText();
							String Groupimgval = we2.getAttribute("href");
							if(GroupNameval!=null) {
								Assert.assertTrue(true, "Rallyhood Group name is present");
								Reporter.log("Rallyhood Group name for Group #"+i+" is : "+GroupNameval, true);
							}else {Reporter.log("Rallyhood Group name for Group #"+i+" is NOT present ", true);}
							
							if(GroupMemCountval!=null) {
								Assert.assertTrue(true, "Rallyhood Group Members count is present");
								Reporter.log("Rallyhood Group Members count of Group #"+i+" is : "+GroupMemCountval, true);
							}else {Reporter.log("Rallyhood Group Members count for Group #"+i+" is NOT present ", true);}
							
							if(Groupimgval!=null) {
								Assert.assertTrue(true, "Rallyhood Group Image is present");
								Reporter.log("Rallyhood Group Image for Group #"+i+" is present ", true);
							}else {Reporter.log("Rallyhood Group Image for Group #"+i+" is NOT present ", true);}
							
							Reporter.log("******************************************************" , true);
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
		
				
				
		//To Verify presence of Group name, Group Members count and respective group Image for a single event
		public void SingleGroup_Rallyhood_GroupName_MembersCount_image_Present(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				waitForPageLoaded(driver);	
					WebElement we = getWebElement(dp.or, "GroupName", driver);
					WebElement we1= getWebElement(dp.or, "GroupMembersCount", driver);	
					WebElement we2= getWebElement(dp.or, "GroupImage", driver);
					
					pointingDownElements(dp, driver, we);
					String GroupNameval = we.getText();
					String GroupMemCountval = we1.getText();
					String Groupimgval = we2.getAttribute("href");
					
					if(GroupNameval!=null) {
						Assert.assertTrue(true, "Rallyhood Group name is present");
						Reporter.log("Rallyhood Group name for Group is : "+GroupNameval, true);
					}else {Reporter.log("Rallyhood Group name for Group is NOT present ", true);}
					
					if(GroupMemCountval!=null) {
						Assert.assertTrue(true, "Rallyhood Group Members count is present");
						Reporter.log("Rallyhood Group Members count of Group is : "+GroupMemCountval, true);
					}else {Reporter.log("Rallyhood Group Members count for Group  is NOT present ", true);}
					
					if(Groupimgval!=null) {
						Assert.assertTrue(true, "Rallyhood Group Image is present");
						Reporter.log("Rallyhood Group Image for Group  is present ", true);
					}else {Reporter.log("Rallyhood Group Image for Group is NOT present ", true);}
					
					Reporter.log("******************************************************" , true);
				
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}

	
	
	// #######################################################           #####################################################
		
		public void EventYES_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventYes", driver));
				if(getWebElement(dp.or, "EventYes", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventYes", driver).getText(), "Yes");
					Reporter.log("'Yes' Button of Event is displayed and enabled" , true);}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void EventNO_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventNo", driver));
				if(getWebElement(dp.or, "EventNo", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventNo", driver).getText(), "No");
					Reporter.log("'NO' Button of Event is displayed and enabled" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_ATTENDING_Lable_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventTextAttending", driver));
				if(getWebElement(dp.or, "EventTextAttending", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "EventTextAttending", driver).getText(), "Attending?");
					Reporter.log("Lable Attending? of Event is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_NOTATTENDING_Lable_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventTextNOTattending", driver));
				if(getWebElement(dp.or, "EventTextNOTattending", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "EventTextNOTattending", driver).getText(), "Not Attending");
					Reporter.log("Lable Not Attending of Event is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void EventYES_Calander_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventYesCalander", driver));
				if(getWebElement(dp.or, "EventYesCalander", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventYesCalander", driver).isDisplayed(), "Calender Icon is displayed");
					Reporter.log("Calander icon of Event is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void EventYES_Change_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventYesChange", driver));
				if(getWebElement(dp.or, "EventYesChange", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventYesChange", driver).getText(), "Change");
					Reporter.log("Change Button of Event when yes is clicked - is displayed and enabled" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void EventNo_Change_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventNoChange", driver));
				if(getWebElement(dp.or, "EventNoChange", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventNoChange", driver).getText(), "Change");
					Reporter.log("Change Button of Event when NO is clicked - is displayed and enabled" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_Comments_Textbox_PlaceHolder_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsPlaceHolder", driver));
				if(getWebElement(dp.or, "EventCommentsPlaceHolder", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsPlaceHolder", driver).getAttribute("placeholder"), "Post a comment...");
					Reporter.log("Comments Textbox of Event - is displayed and enabled" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_First_Comment_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventFirstComment", driver));
				if(getWebElement(dp.or, "EventFirstComment", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventFirstComment", driver).isDisplayed(), "Latest comment of Event is present");
					Reporter.log("Latest comment of Event - is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_First_Comment_AuthorVal_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventFirstCommentAuthor", driver));
				if(getWebElement(dp.or, "EventFirstCommentAuthor", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventFirstCommentAuthor", driver).isDisplayed(), "Author Value Of Latest comment of Event is present");
					Reporter.log("Author Value for Latest comment of Event - is displayed : "+getWebElement(dp.or, "EventFirstCommentAuthor", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_First_Comment_EnteredTextVal_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventFirstCommentEnteredText", driver));
				if(getWebElement(dp.or, "EventFirstCommentEnteredText", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventFirstCommentEnteredText", driver).isDisplayed(), "Entered Text Value Of Latest comment of Event is present");
					Reporter.log("Entered Text Value for Latest comment of Event - is displayed  "+getWebElement(dp.or, "EventFirstCommentEnteredText", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_First_Comment_DateVal_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventFirstCommentEnteredWhen", driver));
				if(getWebElement(dp.or, "EventFirstCommentEnteredWhen", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventFirstCommentEnteredWhen", driver).isDisplayed(), "When the latest comment was commented by user for an Event is present");
					Reporter.log("When the latest comment was commented by user for an Event is present - is displayed: "+getWebElement(dp.or, "EventFirstCommentEnteredWhen", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_Comment_ActualEntry_TextArea_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsTextArea", driver));
				if(getWebElement(dp.or, "EventCommentsTextArea", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "EventCommentsTextArea", driver).isEnabled(), "Comments Text area to enter comment for an Event is present");
					Reporter.log("Comments Text area to enter comment for an Event - is Enabled and displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_Comments_SaveButton_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsButtonSave", driver));
				if(getWebElement(dp.or, "EventCommentsButtonSave", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsButtonSave", driver).getText(), "Save");
					Reporter.log("Comments Save Button is Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_Comments_CancelButton_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsButtonCancel", driver));
				if(getWebElement(dp.or, "EventCommentsButtonCancel", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsButtonCancel", driver).getText(), "Cancel");
					Reporter.log("Comments Cancel Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_ReadMore_Expand_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				List<WebElement> rw = driver.findElements(By.xpath("//div[@class='description ember-view truncated']//span[@class='ellipsis']"));
				int isPresent = rw.size();
					if(isPresent>0) {
							Assert.assertEquals(getWebElement(dp.or, "EventReadMore", driver).getText(), "  ... (read more)");
							Reporter.log("'Read More' link to view full content of an Event is displayed" , true);}
					else {Reporter.log("'Read More' link is not available as the existing content text is less than 100 chars" , true);}
				
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
//-----------------------------------------------------------------------------------------------------------------------------------		
		
		public void Group_ReadMore_Expand_Presence(RHhomeDP dp, WebDriver driver) {
			try {
				Thread.sleep(5000);
				waitForPageLoaded(driver);
				List<WebElement> rw = driver.findElements(By.xpath("//div[@class='description ember-view truncated']//span[@class='ellipsis']"));
				int isPresent = rw.size();
					if(isPresent>0) {
							Thread.sleep(5000);
							Assert.assertEquals(getWebElement(dp.or, "GroupReadMore", driver).getText(), "  ... (read more)");
							Reporter.log("'Read More' link to view full content of an Group is displayed" , true);
					}else {Reporter.log("'Read More' link is not available as the existing content text is less than 100 chars" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Follow_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "GroupFollow", driver));
				if(getWebElement(dp.or, "GroupFollow", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "GroupFollow", driver).getText(), "Follow");
					Reporter.log("Group Follow Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_UnFollow_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "GroupUnfollow", driver));
				if(getWebElement(dp.or, "GroupUnfollow", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "GroupUnfollow", driver).getText(), "Unfollow");
					Reporter.log("Group UnFollow Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Follow_CheckMark_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "GroupFollowCheckMark", driver));
				if(getWebElement(dp.or, "GroupFollowCheckMark", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "GroupFollowCheckMark", driver).isDisplayed(), "Group when Followed, Calender Icon is displayed");
					Reporter.log("Calander icon of Group when Followed is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Current_UpcomingClass_BeforeSignUp_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "GroupSingleClass", driver));
				if(getWebElement(dp.or, "GroupSingleClass", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "GroupSingleClass", driver).isDisplayed(), "Groups current upcoming Class is displayed");
					Reporter.log("Groups Current upcoming class is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Date_BeforeSignUpPresence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassDate", driver));
				if(getWebElement(dp.or, "ClassDate", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassDate", driver).isDisplayed(), "In a Groups, for a Class Date is displayed: "+getWebElement(dp.or, "ClassDate", driver).getText());
					Reporter.log("In a Groups, for a Class Date is displayed: "+getWebElement(dp.or, "ClassDate", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Time_BeforeSignUp_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassTime", driver));
				if(getWebElement(dp.or, "ClassTime", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassTime", driver).isDisplayed(), "In a Groups, for a Class Time is displayed: "+getWebElement(dp.or, "ClassTime", driver).getText());
					Reporter.log("In a Groups, for a Class Time is displayed: "+getWebElement(dp.or, "ClassTime", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_InstructorName_BeforeSignUp_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorName", driver));
				if(getWebElement(dp.or, "ClassInstructorName", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorName", driver).isDisplayed(), "In a Groups, for a Class - Instructor Name is displayed: "+getWebElement(dp.or, "ClassInstructorName", driver).getText());
					Reporter.log("In a Groups, for a Class- Instructor Name is displayed: "+getWebElement(dp.or, "ClassInstructorName", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_InstructorName_AfterSignUp_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver));
				if(getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).isDisplayed(), "In a Groups, for a Class - After signUp Instructor Name is displayed: "+getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).getText());
					Reporter.log("In a Groups, for a Class- After SignUp Instructor Name is displayed: "+getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_Locatin_Before_SignUp_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorLocation", driver));
				if(getWebElement(dp.or, "ClassInstructorLocation", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorLocation", driver).isDisplayed(), "In a Groups, for a Class -Instructor Location is displayed: "+getWebElement(dp.or, "ClassInstructorLocation", driver).getText());
					Reporter.log("In a Groups, for a Class- Instructor Location is displayed: "+getWebElement(dp.or, "ClassInstructorLocation", driver).getText() , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_SignUp_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorSignUp", driver));
				if(getWebElement(dp.or, "ClassInstructorSignUp", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "ClassInstructorSignUp", driver).getText(), "Sign Up");
					Reporter.log("In a Group, for a Class, for an Instructor SignUp Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Instructor_SignUpYes_Calander_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorSignUpYESCalander", driver));
				if(getWebElement(dp.or, "ClassInstructorSignUpYESCalander", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorSignUpYESCalander", driver).isDisplayed(), "In a Group, for a class- after signing Up for an instructor:  Calender Icon is displayed");
					Reporter.log("In a Group, for a class- after signing Up for an instructor:  Calender Icon is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_Remove_Button_Presence(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassInstructorSignUpRemove", driver));
				if(getWebElement(dp.or, "ClassInstructorSignUpRemove", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "ClassInstructorSignUpRemove", driver).getText(), "Remove");
					Reporter.log("In a Group, for a Class, for an Instructor Remove Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public String Group_Class_Date_BeforeSignUpReturnValue(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "ClassDate", driver));
				if(getWebElement(dp.or, "ClassDate", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassDate", driver).isDisplayed(), "In a Groups, for a Class Date is displayed: "+getWebElement(dp.or, "ClassDate", driver).getText());
					Reporter.log("In a Groups, for a Class Date is displayed: "+getWebElement(dp.or, "ClassDate", driver).getText() , true);}
				return getWebElement(dp.or, "ClassDate", driver).getText();
			} catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}
			return null;}
	
	/*//  ---------------------------------------------------------- MultiClasses related paramaterized methods on webelement -----------
		
		public void Group_ReadMore_Expand_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertEquals(MultiWE.getText(), "  ... (read more)");
					Reporter.log("'Read More' link to view full content of an Group is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Follow_Button_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isEnabled()) {
					Assert.assertEquals(MultiWE.getText(), "Follow");
					Reporter.log("Group Follow Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_UnFollow_Button_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isEnabled()) {
					Assert.assertEquals(MultiWE.getText(), "Unfollow");
					Reporter.log("Group UnFollow Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Follow_CheckMark_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "Group when Followed, Calender Icon is displayed");
					Reporter.log("Calander icon of Group when Followed is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Current_UpcomingClass_BeforeSignUp_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "Groups current upcoming Class is displayed");
					Reporter.log("Groups Current upcoming class is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Date_BeforeSignUpPresence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Groups, for a Class Date is displayed: "+MultiWE.getText());
					Reporter.log("In a Groups, for a Class Date is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Time_BeforeSignUp_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Groups, for a Class Time is displayed: "+MultiWE.getText());
					Reporter.log("In a Groups, for a Class Time is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_InstructorName_BeforeSignUp_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Groups, for a Class - Instructor Name is displayed: "+MultiWE.getText());
					Reporter.log("In a Groups, for a Class- Instructor Name is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_InstructorName_AfterSignUp_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Groups, for a Class - After signUp Instructor Name is displayed: "+MultiWE.getText());
					Reporter.log("In a Groups, for a Class- After SignUp Instructor Name is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_Locatin_Before_SignUp_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Groups, for a Class -Instructor Location is displayed: "+MultiWE.getText());
					Reporter.log("In a Groups, for a Class- Instructor Location is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_SignUp_Button_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isEnabled()) {
					Assert.assertEquals(MultiWE.getText(), "Sign Up");
					Reporter.log("In a Group, for a Class, for an Instructor SignUp Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Instructor_SignUpYes_Calander_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isDisplayed()) {
					Assert.assertTrue(MultiWE.isDisplayed(), "In a Group, for a class- after signing Up for an instructor:  Calender Icon is displayed");
					Reporter.log("In a Group, for a class- after signing Up for an instructor:  Calender Icon is displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_Instructor_Remove_Button_Presence_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, MultiWE);
				if(MultiWE.isEnabled()) {
					Assert.assertEquals(MultiWE.getText(), "Remove");
					Reporter.log("In a Group, for a Class, for an Instructor Remove Button is Enabled and Displayed" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	//  -------------------------------------------------------------------------------------------------------------------------------
	*/
		
		// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$         $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		
		
		public void EventYES_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventYes", driver));
				if(getWebElement(dp.or, "EventYes", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventYes", driver).getText(), "Yes");
					getWebElement(dp.or, "EventYes", driver).click();
					Reporter.log("'Yes' Button of Event is Clicked" , true);}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void EventNO_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventNo", driver));
				if(getWebElement(dp.or, "EventNo", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventNo", driver).getText(), "No");
					getWebElement(dp.or, "EventNo", driver).click();
					Reporter.log("'NO' Button of Event is Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void EventYES_Change_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventYesChange", driver));
				if(getWebElement(dp.or, "EventYesChange", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventYesChange", driver).getText(), "Change");
					getWebElement(dp.or, "EventYesChange", driver).click();
					Reporter.log("Change Button of Event when yes is clicked - is Enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void EventNo_Change_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventNoChange", driver));
				if(getWebElement(dp.or, "EventNoChange", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventNoChange", driver).getText(), "Change");
					getWebElement(dp.or, "EventNoChange", driver).click();
					Reporter.log("Change Button of Event when NO is clicked - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}	
		
		
		public void Event_Comment_PlaceHolder_Click(RHhomeDP dp, WebDriver driver) {
			try {	//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsPlaceHolder", driver));
				if(getWebElement(dp.or, "EventCommentsPlaceHolder", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsPlaceHolder", driver).getAttribute("placeholder"), "Post a comment...");
					getWebElement(dp.or, "EventCommentsPlaceHolder", driver).click();
					Reporter.log("'Post a comment' textbox of Event is Clicked" , true);}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_Comment_EnterText_TextArea_Click(RHhomeDP dp, WebDriver driver) {
			try {	//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsTextArea", driver));
				if(getWebElement(dp.or, "EventCommentsTextArea", driver).isEnabled()) {
					Assert.assertTrue(getWebElement(dp.or, "EventCommentsTextArea", driver).isEnabled(), "Comments Text area to enter comment for an Event is present");
					getWebElement(dp.or, "EventCommentsTextArea", driver).click();
					Reporter.log("'Post a comment' Actual textarea of Event is Clicked" , true);}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_Comments_SaveButton_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsButtonSave", driver));
				if(getWebElement(dp.or, "EventCommentsButtonSave", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsButtonSave", driver).getText(), "Save");
					getWebElement(dp.or, "EventCommentsButtonSave", driver).click();
					Reporter.log("Save Button of Comments section of an Event - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_Comments_CancelButton_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsButtonCancel", driver));
				if(getWebElement(dp.or, "EventCommentsButtonCancel", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "EventCommentsButtonCancel", driver).getText(), "Cancel");
					getWebElement(dp.or, "EventCommentsButtonCancel", driver).click();
					Reporter.log("Cancel Button of Comments section of an Event - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Event_Comment_EnterText_TextArea_TextEntry(RHhomeDP dp, WebDriver driver) {
			try {	//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventCommentsTextArea", driver));
				if(getWebElement(dp.or, "EventCommentsTextArea", driver).isEnabled()) {
					Assert.assertTrue(getWebElement(dp.or, "EventCommentsTextArea", driver).isEnabled(), "Comments Text area to enter comment for an Event is present");
					getWebElement(dp.or, "EventCommentsTextArea", driver).click();
					enterText(getWebElement(dp.or, "EventCommentsTextArea", driver), dp.td.get("CommentsText"));
					Reporter.log("User Enters a comment in Comments field: "+ (dp.td.get("CommentsText")) , true);}	
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Event_ReadMore_Expand_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				List<WebElement> rw = driver.findElements(By.xpath("//div[@class='description ember-view truncated']//span[@class='ellipsis']"));
				int isPresent = rw.size();
					if(isPresent>0) {
							Assert.assertEquals(getWebElement(dp.or, "EventReadMore", driver).getText(), "  ... (read more)");
							getWebElement(dp.or, "EventReadMore", driver).click();
							Reporter.log("'Read More' link to view full content of an Event is enabled and Clicked" , true);}
					else {Reporter.log("'Read More' link is not available as the existing content text is less than 100 chars" , true);}
				//------------
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		//-----------------------------------------------------------------------------------------------------------------
		
		public void Group_ReadMore_Expand_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				Thread.sleep(5000);
				waitForPageLoaded(driver);
				List<WebElement> rw = driver.findElements(By.xpath("//div[@class='description ember-view truncated']//span[@class='ellipsis']"));
				int isPresent = rw.size();
					if(isPresent>0) {
							Assert.assertEquals(getWebElement(dp.or, "GroupReadMore", driver).getText(), "  ... (read more)");
							getWebElement(dp.or, "GroupReadMore", driver).click();
							Reporter.log("'Read More' link to view full content of a Group is enabled and Clicked" , true);}
						else {Reporter.log("'Read More' link is not available as the existing content text is less than 100 chars" , true);}

			 } catch (Exception e) { 
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}	
		
		
		public void Group_Follow_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupFollow", driver));
				if(getWebElement(dp.or, "GroupFollow", driver).isDisplayed()) {
					Assert.assertEquals(getWebElement(dp.or, "GroupFollow", driver).getText(), "Follow");
					getWebElement(dp.or, "GroupFollow", driver).click();
					Reporter.log("Follow Button in a Group - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_UnFollow_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupUnfollow", driver));
				if(getWebElement(dp.or, "GroupUnfollow", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "GroupUnfollow", driver).getText(), "Unfollow");
					getWebElement(dp.or, "GroupUnfollow", driver).click();
					Reporter.log("Unfollow Button in a Group - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_BeforeSignUp_InstructorName_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "ClassInstructorName", driver));
				if(getWebElement(dp.or, "ClassInstructorName", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorName", driver).isEnabled(), "In a Group, for a class, Before signUp Insturctor name is present and clicked");
					getWebElement(dp.or, "ClassInstructorName", driver).click();
					Reporter.log("In a Group, for a class, before signUp - Instructor name - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		public void Group_Class_AfterSignUp_InstructorName_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver));
				if(getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).isDisplayed()) {
					Assert.assertTrue(getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).isEnabled(), "In a Group, for a class, After signUp Insturctor name is present and clicked");
					getWebElement(dp.or, "ClassInstructorNameAfterInstSignUpYes", driver).click();
					Reporter.log("In a Group, for a class, after signUp - Instructor name - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Instructor_SignUp_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "ClassInstructorSignUp", driver));
				if(getWebElement(dp.or, "ClassInstructorSignUp", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "ClassInstructorSignUp", driver).getText(), "Sign Up");
					getWebElement(dp.or, "ClassInstructorSignUp", driver).click();
					Reporter.log("Sign Up Button in a Group, for an instructor in a class - is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		
		public void Group_Class_Instructor_Remove_Button_Click(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				//waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "ClassInstructorSignUpRemove", driver));
				if(getWebElement(dp.or, "ClassInstructorSignUpRemove", driver).isEnabled()) {
					Assert.assertEquals(getWebElement(dp.or, "ClassInstructorSignUpRemove", driver).getText(), "Remove");
					getWebElement(dp.or, "ClassInstructorSignUpRemove", driver).click();
					Reporter.log("Remove Button in a Group, for an instructor in a class is enabled and Clicked" , true);}
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		
		/*// ------------------------------------------- Group Click reusable for Multi --------------------------------------------------
		
				public void Group_ReadMore_Expand_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isDisplayed()) {
							Assert.assertEquals(MultiWE.getText(), "  ... (read more)");
							MultiWE.click();
							Reporter.log("'Read More' link to view full content of a Group is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}	
				
				
				public void Group_Follow_Button_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isDisplayed()) {
							Assert.assertEquals(MultiWE.getText(), "Follow");
							MultiWE.click();
							Reporter.log("Follow Button in a Group - is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
				
				
				public void Group_UnFollow_Button_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isEnabled()) {
							Assert.assertEquals(MultiWE.getText(), "Unfollow");
							MultiWE.click();
							Reporter.log("Unfollow Button in a Group - is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
				
				public void Group_Class_BeforeSignUp_InstructorName_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isDisplayed()) {
							Assert.assertTrue(MultiWE.isEnabled(), "In a Group, for a class, Before signUp Insturctor name is present and clicked");
							MultiWE.click();
							Reporter.log("In a Group, for a class, before signUp - Instructor name - is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
				
				public void Group_Class_AfterSignUp_InstructorName_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isDisplayed()) {
							Assert.assertTrue(MultiWE.isEnabled(), "In a Group, for a class, After signUp Insturctor name is present and clicked");
							MultiWE.click();
							Reporter.log("In a Group, for a class, after signUp - Instructor name - is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
				
				
				public void Group_Class_Instructor_SignUp_Button_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isEnabled()) {
							Assert.assertEquals(MultiWE.getText(), "Sign Up");
							MultiWE.click();
							Reporter.log("Sign Up Button in a Group, for an instructor in a class - is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
				
				
				public void Group_Class_Instructor_Remove_Button_Click_Multi(RHhomeDP dp, WebDriver driver, WebElement MultiWE) {
					try {	
						//Thread.sleep(5000);
						//waitForPageLoaded(driver);
						WaitForElement_Click(dp, driver, MultiWE);
						if(MultiWE.isEnabled()) {
							Assert.assertEquals(MultiWE.getText(), "Remove");
							MultiWE.click();
							Reporter.log("Remove Button in a Group, for an instructor in a class is enabled and Clicked" , true);}
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
				
			//---------------------------------------------------------------------------------------------------------------------------
		*/
		
	//  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		
	
	public void Single_Events_Screen_Buttons_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	public void Multiple_Events_Screen_Buttons_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying the lable and buttons on Each event screen
				waitForPageLoaded(driver);
				Reporter.log("Rallyhood Events #"+i+" verified for the lable and buttons on the screen", true);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - - - - - - - - -    - - - - - - - - - - - - - - - -", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	//##############################################              ##################################################################
		
		
	public void Single_Event_Screen_AttendingEventFlow(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			EventYES_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			EventYES_Calander_Presence(dp, driver);
			EventYES_Change_Button_Presence(dp, driver);
			EventYES_Change_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	public void Multiple_Event_Screen_AttendingEventFlow(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying the Event flow when Yes is clicked and again changing the selection done on Each event screen
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				EventYES_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				EventYES_Calander_Presence(dp, driver);
				EventYES_Change_Button_Presence(dp, driver);
				EventYES_Change_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - ", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public void Single_Event_Screen_NOT_AttendingEventFlow(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			EventNO_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			Event_NOTATTENDING_Lable_Presence(dp, driver);
			EventNo_Change_Button_Presence(dp, driver);
			EventNo_Change_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	public void Multiple_Event_Screen_NOT_AttendingEventFlow(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying the Event flow when 'NO' is clicked and again changing the selection done on Each event screen
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				EventNO_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				Event_NOTATTENDING_Lable_Presence(dp, driver);
				EventNo_Change_Button_Presence(dp, driver);
				EventNo_Change_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - ", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public void Single_Event_Screen_Comments_Post(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
		
			waitForPageLoaded(driver);	
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
			
			Event_Comments_SaveButton_Presence(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_SaveButton_Click(dp,driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	public void Multiple_Event_Screen_Comments_Post(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying user is able to post comment for each and every event available
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
			
				waitForPageLoaded(driver);	
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
				
				Event_Comments_SaveButton_Presence(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_SaveButton_Click(dp,driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
//################################################            #################################################################
	
	
	public void Single_Event_CommentsPostOptions_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			//waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
		
			//waitForPageLoaded(driver);
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_CancelButton_Click(dp,driver);
			Thread.sleep(2000);
			
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
			
			Event_Comments_SaveButton_Presence(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_SaveButton_Click(dp,driver);
			
			driver.navigate().back();
			//waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	public void Multiple_Event_CommentsPostOptions_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying user is able to post comment for each and every event available and verify all options are working properly
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
			
				waitForPageLoaded(driver);
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_CancelButton_Click(dp,driver);
				Thread.sleep(2000);
				
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
				
				Event_Comments_SaveButton_Presence(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_SaveButton_Click(dp,driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
//#####################################################            ###################################################################	
	
	
	public void Single_Event_AfterCommentPOST_VerifyCommentsValue(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
		
			waitForPageLoaded(driver);	
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
			
			Event_Comments_SaveButton_Presence(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_SaveButton_Click(dp,driver);
			
			Event_First_Comment_AuthorVal_Presence(dp,driver);
			Event_First_Comment_EnteredTextVal_Presence(dp,driver);
			Event_First_Comment_DateVal_Presence(dp,driver);
			
			driver.navigate().back();
			//waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	public void Multiple_Event_AfterCommentPOST_VerifyCommentsValue(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying user is able to post comment for each and every event available and Verify the Author/Entered Text and Time of Entry
				//waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
			
				waitForPageLoaded(driver);	
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
				
				Event_Comments_SaveButton_Presence(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_SaveButton_Click(dp,driver);
				
				Event_First_Comment_AuthorVal_Presence(dp,driver);
				Event_First_Comment_EnteredTextVal_Presence(dp,driver);
				Event_First_Comment_DateVal_Presence(dp,driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	
	public void Single_Event_SelectionYES_VerifyComments_CommentedValues(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			EventYES_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			EventYES_Calander_Presence(dp, driver);
			EventYES_Change_Button_Presence(dp, driver);
		
			waitForPageLoaded(driver);	
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
			
			Event_Comments_SaveButton_Presence(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_SaveButton_Click(dp,driver);
			
			Event_First_Comment_AuthorVal_Presence(dp,driver);
			Event_First_Comment_EnteredTextVal_Presence(dp,driver);
			Event_First_Comment_DateVal_Presence(dp,driver);
			
			EventYES_Change_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	public void Multiple_Event_SelectionYES_VerifyComments_CommentedValues(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying user is able to post comment for each and every event available and Verify the Author/Entered Text and Time of Entry When YES attending the event is opted
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				EventYES_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				EventYES_Calander_Presence(dp, driver);
				EventYES_Change_Button_Presence(dp, driver);
			
				waitForPageLoaded(driver);	
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
				
				Event_Comments_SaveButton_Presence(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_SaveButton_Click(dp,driver);
				
				Event_First_Comment_AuthorVal_Presence(dp,driver);
				Event_First_Comment_EnteredTextVal_Presence(dp,driver);
				Event_First_Comment_DateVal_Presence(dp,driver);
				
				EventYES_Change_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	
	public void Single_Event_SelectionNO_VerifyComments_CommentedValues(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			EventNO_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			Event_NOTATTENDING_Lable_Presence(dp, driver);
			EventNo_Change_Button_Presence(dp, driver);
		
			waitForPageLoaded(driver);	
			Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
			Event_Comment_PlaceHolder_Click(dp, driver);
			Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
			Event_Comment_EnterText_TextArea_Click(dp,driver);
			Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
			
			Event_Comments_SaveButton_Presence(dp,driver);
			Event_Comments_CancelButton_Presence(dp,driver);
			Event_Comments_SaveButton_Click(dp,driver);
			
			Event_First_Comment_AuthorVal_Presence(dp,driver);
			Event_First_Comment_EnteredTextVal_Presence(dp,driver);
			Event_First_Comment_DateVal_Presence(dp,driver);
			
			EventNo_Change_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	public void Multiple_Event_SelectionNO_VerifyComments_CommentedValues(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying user is able to post comment for each and every event available and Verify the Author/Entered Text and Time of Entry When NO attending the event is opted
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				EventNO_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				Event_NOTATTENDING_Lable_Presence(dp, driver);
				EventNo_Change_Button_Presence(dp, driver);
			
				waitForPageLoaded(driver);	
				Event_Comments_Textbox_PlaceHolder_Presence(dp, driver);
				Event_Comment_PlaceHolder_Click(dp, driver);
				Event_Comment_ActualEntry_TextArea_Presence(dp, driver);
				Event_Comment_EnterText_TextArea_Click(dp,driver);
				Event_Comment_EnterText_TextArea_TextEntry(dp,driver);
				
				Event_Comments_SaveButton_Presence(dp,driver);
				Event_Comments_CancelButton_Presence(dp,driver);
				Event_Comments_SaveButton_Click(dp,driver);
				
				Event_First_Comment_AuthorVal_Presence(dp,driver);
				Event_First_Comment_EnteredTextVal_Presence(dp,driver);
				Event_First_Comment_DateVal_Presence(dp,driver);
				
				EventNo_Change_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				waitForPageLoaded(driver);
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	
	public void Single_Event_Screen_AttendingEvent_PageRefresh_LandingSamePage(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			Robot robot = new Robot();
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			waitForPageLoaded(driver);
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			EventYES_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			EventYES_Calander_Presence(dp, driver);
			EventYES_Change_Button_Presence(dp, driver);
			
			robot.keyPress(KeyEvent.VK_F5);
			robot.keyRelease(KeyEvent.VK_F5);
			waitForPageLoaded(driver);
			waitForElementPresent(getWebElement(dp.or, "EventYesChange", driver), 40000);
			Thread.sleep(10000);
			if(getWebElement(dp.or, "EventYesChange", driver).isDisplayed()) {
				Reporter.log("After Refresh of the Page, landed to the same page", true);
			}
			
			EventYES_Change_Button_Click(dp, driver);
			waitForPageLoaded(driver);
			
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			
			driver.navigate().back();
			waitForPageLoaded(driver);
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	
	
	public void Multiple_Event_Screen_AttendingEvent_PageRefresh_LandingSamePage(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				Robot robot = new Robot();
				//Verifying that after clicking yes to attend the event, if page is refreshed, it should land on the same page.
				waitForPageLoaded(driver);
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				EventYES_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				EventYES_Calander_Presence(dp, driver);
				EventYES_Change_Button_Presence(dp, driver);
				
				robot.keyPress(KeyEvent.VK_F5);
				robot.keyRelease(KeyEvent.VK_F5);
				waitForPageLoaded(driver);
				waitForElementPresent(getWebElement(dp.or, "EventYesChange", driver), 40000);
				Thread.sleep(10000);
				if(getWebElement(dp.or, "EventYesChange", driver).isDisplayed()) {
					Reporter.log("After Refresh of the Page, landed to the same page", true);
				}
				
				EventYES_Change_Button_Click(dp, driver);
				waitForPageLoaded(driver);
				
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				
				driver.navigate().back();
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
				Thread.sleep(2000);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	
	public void Single_EventsScreen_ReadMore_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			if(getWebElement(dp.or, "RHEvent", driver).isDisplayed()) {
				pointingDownElements(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				click(getWebElement(dp.or, "RHEvent", driver));
				Thread.sleep(2000);
				Reporter.log("Rallyhood home screen have Events Listed and Clickable", true);}
			
			//waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "EventTextAttending", driver));
			Event_ATTENDING_Lable_Presence(dp, driver);
			EventYES_Button_Presence(dp, driver);
			EventNO_Button_Presence(dp, driver);
			
			Event_ReadMore_Expand_Presence(dp, driver);
			Event_ReadMore_Expand_Click(dp, driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "EventTextAttending", driver));
			
			driver.navigate().back();
			//waitForPageLoaded(driver);
			WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	public void Multiple_EventsScreen_ReadMore_Validation(RHhomeDP dp, WebDriver driver) {
		try {
			waitForPageLoaded(driver);
			List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='event ember-view'])"));
			int MultiEventsSize = MultiEvents.size();
			Reporter.log("Rallyhood Total Events Present is:: "+MultiEventsSize , true);
			for(int i=1; i<=MultiEventsSize;i++) {
				String xpthaString = "(//a[@class='event ember-view'])"+"["+i+"]";
				WebElement we = driver.findElement(By.xpath(xpthaString));
				pointingDownElements(dp, driver, we);
				we.click();
				Reporter.log("Rallyhood Events #"+i+" is present and Clickable", true);
				Thread.sleep(5000);
				
				//Verifying read more extending link is available and clickable.
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventTextAttending", driver));
				Event_ATTENDING_Lable_Presence(dp, driver);
				EventYES_Button_Presence(dp, driver);
				EventNO_Button_Presence(dp, driver);
				
				Event_ReadMore_Expand_Presence(dp, driver);
				Event_ReadMore_Expand_Click(dp, driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "EventTextAttending", driver));
				
				driver.navigate().back();
				//waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "RHEvent", driver));
				Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
			}
			} catch(Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}

//##############################################              ##################################################################
// ############################################# Group and Classes Methods   ###################################################	
	
	public void RallyHood_Single_GroupClasses_FollowAGroup_Verify(RHhomeDP dp, WebDriver driver) {
		try { //Thread.sleep(5000);
				waitForPageLoaded(driver);
				WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
				if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
					click(getWebElement(dp.or, "RHClasses", driver));
					Thread.sleep(2000);
					Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
					
					Group_Follow_Button_Presence(dp, driver);
					Group_Follow_Button_Click(dp, driver);

					Group_UnFollow_Button_Presence(dp, driver);
					Group_Follow_CheckMark_Presence(dp, driver);
					
					Group_UnFollow_Button_Click(dp, driver);
					Group_Follow_Button_Presence(dp, driver);
					
					driver.navigate().back();
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					
				}	
				 } catch (Exception e) {
				Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
	
	
	//To Verify Follow Button Functionality in a class for All available Group, in Groups and Classes
			public void RallyHood_Multiple_GroupClasses_FollowAGroup_Verify(RHhomeDP dp, WebDriver driver) {
				try {	
					//Thread.sleep(5000);
					waitForPageLoaded(driver);
					WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
					int MultiGroupsSize = MultiGroups.size();
					Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
					//Groups and Classes Loop Start
					for(int i=1; i<=MultiGroupsSize;i++) {
						String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
						WebElement we = driver.findElement(By.xpath(xpathString));
						WaitForElement(dp, driver, we);
						pointingDownElements(dp, driver, we);
						click(we);
						
						Group_Follow_Button_Presence(dp, driver);
						Group_Follow_Button_Click(dp, driver);

						Group_UnFollow_Button_Presence(dp, driver);
						Group_Follow_CheckMark_Presence(dp, driver);
						
						Group_UnFollow_Button_Click(dp, driver);
						Group_Follow_Button_Presence(dp, driver);
						
						driver.navigate().back();
						Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
					} //Groups and Classes Loop End	
					
					
				 } catch (Exception e) {
				Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
	
	
			public void RallyHood_Single_GroupClasses_ReadMoreExpand_Verify(RHhomeDP dp, WebDriver driver) {
				try { //Thread.sleep(5000);
						waitForPageLoaded(driver);
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
						pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
						if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
							click(getWebElement(dp.or, "RHClasses", driver));
							Thread.sleep(2000);
							Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
							
							Group_Follow_Button_Presence(dp, driver);
							Group_ReadMore_Expand_Presence(dp, driver);
							Group_ReadMore_Expand_Click(dp, driver);
							Group_Follow_Button_Presence(dp, driver);
							
							driver.navigate().back();
							WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
							
						}	
						 } catch (Exception e) {
						Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
			
			
			
			//To Verify Read More.. expand link Functionality in a class for All available Group, in Groups and Classes
					public void RallyHood_Multiple_GroupClasses_ReadMoreExpand_Verify(RHhomeDP dp, WebDriver driver) {
						try {	
							//Thread.sleep(5000);
							waitForPageLoaded(driver);
							WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
							List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
							int MultiGroupsSize = MultiGroups.size();
							Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
							//Groups and Classes Loop Start
							for(int i=1; i<=MultiGroupsSize;i++) {
								String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
								WebElement we = driver.findElement(By.xpath(xpathString));
								WaitForElement(dp, driver, we);
								pointingDownElements(dp, driver, we);
								click(we);
								
								Group_Follow_Button_Presence(dp, driver);
								Group_ReadMore_Expand_Presence(dp, driver);
								Group_ReadMore_Expand_Click(dp, driver);
								Group_Follow_Button_Presence(dp, driver);
								
								driver.navigate().back();
								Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
								WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
							} //Groups and Classes Loop End	
							
							
						 } catch (Exception e) {
						Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
			
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	
					
		public void RallyHood_Single_GroupClasses_InstructorSignUp_Verify(RHhomeDP dp, WebDriver driver) {
			try { //Thread.sleep(5000); 
					waitForPageLoaded(driver);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
					if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
						click(getWebElement(dp.or, "RHClasses", driver));
						Thread.sleep(2000);
						Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
						
						List<WebElement> a = driver.findElements(By.xpath("//article[@class='time-slot ember-view none']//div[@class='info']"));
						int ElePresence = a.size();
						if(ElePresence>0) {
							Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver); 
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
							Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
							Group_Class_Instructor_SignUp_Button_Click(dp, driver);
							Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
							
							Group_Class_InstructorName_AfterSignUp_Presence(dp, driver);
							Group_Class_AfterSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_Remove_Button_Presence(dp, driver);
							Group_Class_Instructor_Remove_Button_Click(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						}else {Reporter.log("Even a single Class is not present" , true);}
						
						driver.navigate().back();
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
						
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
			
			
							
		//To Verify Read More.. expand link Functionality in a class for All available Group, in Groups and Classes
		public void RallyHood_Multiple_GroupClasses_InstructorSignUp_Verify(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
				int MultiGroupsSize = MultiGroups.size();
				Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
				//Groups and Classes Loop Start
				for(int i=1; i<=MultiGroupsSize;i++) {
					String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
					WebElement we = driver.findElement(By.xpath(xpathString));
					WaitForElement(dp, driver, we);
					pointingDownElements(dp, driver, we);
					click(we);
					
					 
					////////////////////////////////////////////////////////////
					waitForPageLoaded(driver);
					//WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupSingleClass", driver)); 
					List<WebElement> MultiClasses = driver.findElements(By.xpath("(//article[@class='time-slot ember-view none']//div[@class='info'])"));
					int MultiClassesSize = MultiClasses.size();
					if(MultiClassesSize>0) {
						Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
						for(int j=1;j<=MultiClassesSize;j++) { //Classes Loop Starting
							
							String xpathString1 = "(//article[@class='time-slot ember-view none']//div[@class='info'])";
							WebElement we1 = driver.findElement(By.xpath(xpathString1));
							
							WaitForElement(dp, driver, we1);
							pointingDownElements(dp, driver, we1);
							
								
							Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
							Group_Class_Date_BeforeSignUpPresence(dp, driver);
							we1.click();
							//Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
							Group_Class_Instructor_SignUp_Button_Click(dp, driver);
							Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
								
						}//Classes Loop Ending
					}else {Reporter.log("Not Even a single class is present" , true);}
					
					/*Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
					for(int j=1;j<=MultiClassesSize;j++) { //Classes Loop Starting
						
						String xpathString1 = "(//article[@class='time-slot ember-view none']//div[@class='info'])";
						WebElement we1 = driver.findElement(By.xpath(xpathString1));
						
						WaitForElement(dp, driver, we1);
						pointingDownElements(dp, driver, we1);
						
							
						Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						Group_Class_Date_BeforeSignUpPresence(dp, driver);
						we1.click();
						//Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
						
						Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
						Group_Class_Instructor_SignUp_Button_Click(dp, driver);
						Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
							
					}//Classes Loop Ending
*/					/////////////////////////////////////////////////////////////
					driver.navigate().back();
					Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
				} //Groups and Classes Loop End	
				
				
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}						
							



		
		
	
		//To Verify Read More.. expand link Functionality in a class for All available Group, in Groups and Classes
		public void RallyHood_Multiple_GroupClasses_InstructorSignUp_Remove_Verify(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
				int MultiGroupsSize = MultiGroups.size();
				Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
				//Groups and Classes Loop Start
				for(int i=1; i<=MultiGroupsSize;i++) {
					String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
					WebElement we = driver.findElement(By.xpath(xpathString));
					WaitForElement(dp, driver, we);
					pointingDownElements(dp, driver, we);
					click(we);
					
					
				////////////////////////////////////////////////////////////
				waitForPageLoaded(driver);
				//WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupSingleClass", driver));
				List<WebElement> MultiClasses = driver.findElements(By.xpath("(//article[@class='time-slot ember-view yes']//div[@class='info'])"));
				int MultiClassesSize = MultiClasses.size();
				if(MultiClassesSize>0) {
					Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
					for(WebElement we1: MultiClasses) { //Classes Loop Starting
						
						WaitForElement(dp, driver, we1);
						pointingDownElements(dp, driver, we1);
					
						
						Group_Class_InstructorName_AfterSignUp_Presence(dp, driver);
						we1.click();
						Group_Class_Instructor_Remove_Button_Presence(dp, driver);
						Group_Class_Instructor_Remove_Button_Click(dp, driver);
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);	
					}//Classes Loop Ending
					
				}else {Reporter.log("Not even a single class is present" , true);}
				
				/*Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
				for(WebElement we1: MultiClasses) { //Classes Loop Starting
					
					WaitForElement(dp, driver, we1);
					pointingDownElements(dp, driver, we1);
				
					
					Group_Class_InstructorName_AfterSignUp_Presence(dp, driver);
					we1.click();
					Group_Class_Instructor_Remove_Button_Presence(dp, driver);
					Group_Class_Instructor_Remove_Button_Click(dp, driver);
					Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);	
				}//Classes Loop Ending
*/				/////////////////////////////////////////////////////////////
				
					driver.navigate().back();
					Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
				} //Groups and Classes Loop End	
				
				
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}	
				
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@				
				
		
		public void RallyHood_Single_GroupClasses_InstructorName_Date_Location_Verify(RHhomeDP dp, WebDriver driver) {
			try { //Thread.sleep(5000);
					waitForPageLoaded(driver);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
					if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
						click(getWebElement(dp.or, "RHClasses", driver));
						Thread.sleep(2000);
						Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
						
						Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						Group_Class_Date_BeforeSignUpPresence(dp, driver);
						Group_Class_Time_BeforeSignUp_Presence(dp, driver);
						
						driver.navigate().back();
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
						
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
			
							
		//To Verify Read More.. expand link Functionality in a class for All available Group, in Groups and Classes
		public void RallyHood_Multiple_GroupClasses_InstructorName_Date_Location_Verify(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000); 
				waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
				int MultiGroupsSize = MultiGroups.size();
				Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
				//Groups and Classes Loop Start
				for(int i=1; i<=MultiGroupsSize;i++) {
					String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
					WebElement we = driver.findElement(By.xpath(xpathString));
					WaitForElement(dp, driver, we);
					pointingDownElements(dp, driver, we);
					click(we);
					
					
					////////////////////////////////////////////////////////////
					waitForPageLoaded(driver);
					//WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupSingleClass", driver));
					List<WebElement> MultiClasses = driver.findElements(By.xpath("(//article[@class='time-slot ember-view none']//div[@class='info'])"));
					int MultiClassesSize = MultiClasses.size();
					
					if(MultiClassesSize>0) {
						Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
						for(int j=1;j<=MultiClassesSize;j++) { //Classes Loop Starting
							
							String xpathString1 = "(//article[@class='time-slot ember-view none']//div[@class='info'])";
							WebElement we1 = driver.findElement(By.xpath(xpathString1));
							
							WaitForElement(dp, driver, we1);
							pointingDownElements(dp, driver, we1);
							
								
							Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
							Group_Class_Date_BeforeSignUpPresence(dp, driver);
							Group_Class_Time_BeforeSignUp_Presence(dp, driver);
							
							we1.click();
							//Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
							Group_Class_Instructor_SignUp_Button_Click(dp, driver);
							Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
								
						}//Classes Loop Ending
						/////////////////////////////////////////////////////////////
					}else {Reporter.log("Not even a single class is present" , true);}
					
					
					driver.navigate().back();
					Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
				} //Groups and Classes Loop End	
				
			
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}						
							

//#######################################################################################################################################
		
		public void RallyHood_Single_GroupClasses_Instructor_RemoveButton_Verify(RHhomeDP dp, WebDriver driver) {
			try { //Thread.sleep(5000);
					waitForPageLoaded(driver);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
					if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
						click(getWebElement(dp.or, "RHClasses", driver));
						Thread.sleep(2000);
						Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
						
						List<WebElement> a = driver.findElements(By.xpath("//article[@class='time-slot ember-view none']//div[@class='info']"));
						int b=a.size();
						if(b>0) {
							Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
							Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
							Group_Class_Instructor_SignUp_Button_Click(dp, driver);
							Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
							
							Group_Class_InstructorName_AfterSignUp_Presence(dp, driver);
							Group_Class_AfterSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_Remove_Button_Presence(dp, driver);
							Group_Class_Instructor_Remove_Button_Click(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						}else {Reporter.log("Not even a single class is present" , true);}
						
						driver.navigate().back();
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
						
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
	
			
							
		//To Verify Read More.. expand link Functionality in a class for All available Group, in Groups and Classes
		public void RallyHood_Multiple_GroupClasses_Instructor_RemoveButton_Verify(RHhomeDP dp, WebDriver driver) {
			try {	
				//Thread.sleep(5000);
				waitForPageLoaded(driver);
				WaitForElement_Click(dp, driver, getWebElement(dp.or, "RHClasses", driver));
				List<WebElement> MultiGroups = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
				int MultiGroupsSize = MultiGroups.size();
				Reporter.log("Rallyhood Total Groups Present is:: "+MultiGroupsSize , true);
				//Groups and Classes Loop Start
				for(int i=1; i<=MultiGroupsSize;i++) {
					String xpathString = "(//a[@class='rally ember-view'])"+"["+i+"]";
					WebElement we = driver.findElement(By.xpath(xpathString));
					WaitForElement(dp, driver, we);
					pointingDownElements(dp, driver, we);
					click(we);
					
					
					////////////////////////////////////////////////////////////
					waitForPageLoaded(driver);
					//WaitForElement_Click(dp, driver, getWebElement(dp.or, "GroupSingleClass", driver));
					List<WebElement> MultiClasses = driver.findElements(By.xpath("(//article[@class='time-slot ember-view none']//div[@class='info'])"));
					int MultiClassesSize = MultiClasses.size();
					if(MultiClassesSize>0) {
						Reporter.log("Rallyhood Total Classes Present in a Group:: "+MultiClassesSize , true);
						for(int j=1;j<=MultiClassesSize;j++) { //Classes Loop Starting
							
							String xpathString1 = "(//article[@class='time-slot ember-view none']//div[@class='info'])";
							WebElement we1 = driver.findElement(By.xpath(xpathString1));
							
							WaitForElement(dp, driver, we1);
							pointingDownElements(dp, driver, we1);
							
								
							Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
							Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
							we1.click();
							//Group_Class_BeforeSignUp_InstructorName_Click(dp, driver);
							
							Group_Class_Instructor_SignUp_Button_Presence(dp, driver);
							Group_Class_Instructor_SignUp_Button_Click(dp, driver);
							Group_Class_Instructor_SignUpYes_Calander_Presence(dp, driver);
								
						}//Classes Loop Ending
						/////////////////////////////////////////////////////////////
					}else {Reporter.log("Not even a single class is present" , true);}
					
					
					driver.navigate().back();
					Reporter.log("- - - - - - - - - - - - - -     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ", true);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));	
				} //Groups and Classes Loop End	
				
				
			 } catch (Exception e) {
			Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}						
							

					
							

//#######################################################################################################################################
		
		
		public void RallyHood_Single_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(RHhomeDP dp, WebDriver driver) throws ParseException {
			try { //Thread.sleep(5000);
					waitForPageLoaded(driver);
					WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
					pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
					if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
						click(getWebElement(dp.or, "RHClasses", driver));
						Thread.sleep(2000);
						Reporter.log("Rallyhood home scree have Groups and Classes Listed, First Listed Class in a Group is Clickable and performed Click Operation", true);
						
						Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						
						Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
						String UpcomingClassFirst = Group_Class_Date_BeforeSignUpReturnValue(dp, driver);
						
						String[] s = UpcomingClassFirst.split(" ");
						String s1 = s[0];
						String s2 = s[1];
						String s3 = s2.replaceAll("[^0-9]", "");
						String ActualDate = s3+"-"+s1+"-"+"17";

		
						DateFormat formatter =new SimpleDateFormat("dd-MMM-yy");
						Date convertedDate =(Date) formatter.parse(ActualDate); //first upcoming class date in  group and classes
				       
				        Date sysdate =  new Date();
				        String cursysdate = formatter.format(sysdate);
				        Date cursysdate1 = (Date) formatter.parse(cursysdate);	//system date
						
				        if(convertedDate.after(cursysdate1)) {
				        	Reporter.log("The very next upcoming instructors class date : "+ActualDate+" is greater than the current date: "+cursysdate, true);
				        }else {Reporter.log("Past dated instructor class is present, which shouldn't be.", true);}
				        
				        
				        driver.navigate().back();
						WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
						
					}	
					 } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
	 
		//To Verify total each group having classes , where the verynext class is not past due dated class , as it should't be present.
				public void RallyHood_Multiple_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(RHhomeDP dp, WebDriver driver) {
					try {	
					  //Thread.sleep(5000);
						waitForPageLoaded(driver);
						List<WebElement> MultiEvents = driver.findElements(By.xpath("(//a[@class='rally ember-view'])"));
						int MultiEventsSize = MultiEvents.size();
							Reporter.log("Rallyhood Total Groups Present is:: "+MultiEventsSize , true);
							for(int i=1; i<=MultiEventsSize;i++) {
								String xpthaString = "(//a[@class='rally ember-view'])"+"["+i+"]";
								WebElement we = driver.findElement(By.xpath(xpthaString));
								pointingDownElements(dp, driver, we);
								we.click();
								
								List<WebElement> a = driver.findElements(By.xpath("//article[@class='time-slot ember-view none']//div[@class='info']"));
								int b = a.size();
								
								if(b>0) {
									Group_Current_UpcomingClass_BeforeSignUp_Presence(dp, driver);
									Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
									
									Group_Class_InstructorName_BeforeSignUp_Presence(dp, driver);
									String UpcomingClassFirst = Group_Class_Date_BeforeSignUpReturnValue(dp, driver);
									
									String[] s = UpcomingClassFirst.split(" ");
									String s1 = s[0];
									String s2 = s[1];
									String s3 = s2.replaceAll("[^0-9]", "");
									String ActualDate = s3+"-"+s1+"-"+"17";

					 
									DateFormat formatter =new SimpleDateFormat("dd-MMM-yy");
									Date convertedDate =(Date) formatter.parse(ActualDate); //first upcoming class date in  group and classes
							       
							        Date sysdate =  new Date();
							        String cursysdate = formatter.format(sysdate);
							        Date cursysdate1 = (Date) formatter.parse(cursysdate);	//system date
									
							        if(convertedDate.after(cursysdate1) || convertedDate.equals(cursysdate1)) {
							        	Reporter.log("The very next upcoming instructors class date : "+ActualDate+" is greater or equal to that of current date: "+cursysdate, true);
							        	Assert.assertTrue((convertedDate.after(cursysdate1) || convertedDate.equals(cursysdate1)), "Past dated instructor class is present, which is not expected");
							        }else {Reporter.log("Past dated instructor class is present, which shouldn't be.", true);}
								}else {Reporter.log("Not even a single class is present" , true);}
								
						        
								driver.navigate().back();
								WaitForElement(dp, driver, getWebElement(dp.or, "RHClasses", driver));
								Reporter.log("------------------------------------------------------------------------------------------",true);
					}
				    } catch (Exception e) {
					Assert.assertTrue(false, "Test case failed due to exception " + e.getMessage());}}
		
		 
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		
		
		
		
		

		
	
	
	public void testfunction(RHhomeDP dp, WebDriver driver) throws IllegalArgumentException, InterruptedException, Exception {
		waitForPageLoaded(driver);
		pointingDownElements(dp, driver,getWebElement(dp.or, "RHClasses", driver) );
		if(getWebElement(dp.or, "RHClasses", driver).isDisplayed()) {
			click(getWebElement(dp.or, "RHClasses", driver));
			Thread.sleep(2000);
			Reporter.log("Rallyhood home scree have Groups and Classes Listed and Clickable", true);
		}	
			
	
			//List<WebElement> x = driver.findElements(By.xpath("(//section[@class='time-slots']//article[@class='time-slot ember-view none']//div[@class='datetime']//div[@class='date'])[4]"));
			WebElement x = driver.findElement(By.xpath("(//article[@class='time-slot ember-view none']//div[@class='info'])[2]"));
			//int x1 = x.size();
			String x1 = x.getText();
			x.click();
			System.out.println(x1);
			
		
	}
	
	
	
	
	
	
	
}