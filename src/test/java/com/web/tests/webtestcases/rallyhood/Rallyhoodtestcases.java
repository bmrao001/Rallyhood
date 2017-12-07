/****/
package com.web.tests.webtestcases.rallyhood;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innominds.team.driverinit.DriverManager;
import com.innominds.team.frameworkengine.Constants;
import com.innominds.team.utils.PropertyFileUtils;
import com.web.tests.rallyhood.RHhome;
import com.web.tests.rallyhood.RHhomeDP;
import com.web.tests.rallyhood.Source;
import com.web.tests.rallyhood.SourceDP;

public class Rallyhoodtestcases extends DriverManager {

	Logger logger = LogManager.getLogger(Rallyhoodtestcases.class.getName());
	
	private WebDriver driver = null;  

	/** 
	 * Inits the
	 *
	 * @throws Exception
	 * @throws FileNotFoundException
	 */
	@Parameters({ "browser", "os" })
	@BeforeClass(alwaysRun = true, groups = { "Smoke", "Sanity" })
	public void init(String browser, String osName) throws Exception {

		
		browserName = browser;
		os = osName;
		
		System.out.println("***Rallyhood script execution Started***: "+browser);
		this.driver = getDriver(
				PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "GridExecution"));
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,
				browserName);
	}

	/*************************************************************************
	 *
	 * TEST SUITE TESTS
	 *
	 *************************************************************************/

	/*
	 * list of Modules Objects Creation ****************************************
	 */
	RHhome rhhome = new RHhome();
	//Source source = new Source();

	/*
	 * * Data Providers list for Modules
	 * ****************************************
	 */


	
	@DataProvider(name = "RHhomeDP")
	public Object[][] RHhomeDP() {
		if ("firefox".equalsIgnoreCase(browserName)) {
			return RHhomeDP.createDP("RH1");
		} else if ("chrome".equalsIgnoreCase(browserName)) {
			return RHhomeDP.createDP("RH1");
		} else if ("edge".equalsIgnoreCase(browserName)) {
			return RHhomeDP.createDP("RH1");
		} else if ("phanomjs".equalsIgnoreCase(browserName)) {
			return RHhomeDP.createDP("RH1");
		}

		return null;
	} 

	//Rallyhood test case 01
	@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 1)
	public void RallyhoodTC_01(RHhomeDP dp, ITestContext context) {
		context.setAttribute("dpName", dp.td.get("DataRow"));
		rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Rallyhood Home screen is displayed and Events/Groups and Classes sections are present");
		rhhome.Rallyhood_Mobileview(dp, driver,browserName);
		rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
		rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
	}
	
	
		//Rallyhood test case 02 
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 2)
		public void RallyhoodTC_02(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
			context.setAttribute("dpName", dp.td.get("DataRow"));
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify error message on browser saying app_uid is invalid. ");
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.VerifyInvalid_app_uid(dp, driver);
			
		}
		
		
		
		//Rallyhood test case 03
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 3)
		public void RallyhoodTC_03(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
			context.setAttribute("dpName", dp.td.get("DataRow"));
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify error message on browser saying app_uid is invalid. ");
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.VerifyInvalid_secret_key(dp, driver);	
		}
	
	
	
	//Rallyhood test case 05
	@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 5)
	public void RallyhoodTC_05(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
		context.setAttribute("dpName", dp.td.get("DataRow"));
		rhhome.TestCaseDescription(dp, driver, "TC Description : Verify single Events/Groups and Classes are present and clickable ");
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
		rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
		rhhome.RallyHood_ClickOnEvent_EventsListed(dp, driver);
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		rhhome.RallyHood_ClickOnGroupClasses_GroupClassesListed(dp, driver);
		rhhome.PageUp(dp, driver);
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
	}


	//Rallyhood Test case 06
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 6)
		public void RallyhoodTC_06(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Event Name, Event Date and respective Event Image for single Event Present");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.SingleEvent_Rallyhood_EventName_Date_image_Present(dp, driver);	
		}
		
		
		//Rallyhood Test case 07
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 7)
		public void RallyhoodTC_07(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Lable 'Attending?', Button 'Yes' and Button 'No' present in an Event ");
			rhhome.Single_Events_Screen_Buttons_Validation(dp, driver);	
			
		}
	
		
		//Rallyhood Test case 08
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 8)
		public void RallyhoodTC_08(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Event Flow when user clicks on Yes button for attending event and ability to change his selection again for single Event");
			rhhome.Single_Event_Screen_AttendingEventFlow(dp, driver);
		}
	
	
		//Rallyhood Test case 09
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 9)
		public void RallyhoodTC_09(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Event Flow when user clicks on 'NO' button for NOT attending the event and ability to change his selection again for single Event");
			rhhome.Single_Event_Screen_NOT_AttendingEventFlow(dp, driver);
		}
		
		
		//Rallyhood Test case 10
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 10)
		public void RallyhoodTC_10(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify ability to post comment without selecting 'Yes'/'No' button in an Event");
			rhhome.Single_Event_Screen_Comments_Post(dp, driver);
		}
		
		
		//Rallyhood Test case 11
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 11)
			public void RallyhoodTC_11(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify all options are working properly for an Event");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.Single_Event_CommentsPostOptions_Validation(dp, driver);
			}	
		
		
		
		//Rallyhood Test case 012
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 12)
		public void RallyhoodTC_12(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : 'Read More' link to view full content of an Event is enabled and Clicked in an Event ");
			rhhome.Single_EventsScreen_ReadMore_Validation(dp, driver);		
		}
	
		
		///Rallyhood Test case 13
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 13)
				public void RallyhoodTC_13(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to land on same page after refreshing the page, after clicking 'Yes' to attend an Events");
					rhhome.Single_Event_Screen_AttendingEvent_PageRefresh_LandingSamePage(dp, driver);
				}
		
		
		
		//Rallyhood Test case 14
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 14)
		public void RallyhoodTC_14(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Group Name, Members count and respective Event Image for single Group Present ");
			rhhome.SingleGroup_Rallyhood_GroupName_MembersCount_image_Present(dp, driver);	
		}
		
		
		
		//Rallyhood Test case 015
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 15)
		public void RallyhoodTC_15(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of Follow button for Class in a Group is working properly ");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.RallyHood_Single_GroupClasses_FollowAGroup_Verify(dp, driver);		
		}
		
		
		
		//Rallyhood Test case 016
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 16)
			public void RallyhoodTC_16(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of 'Read More ..' for Groups and Classes is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_ReadMoreExpand_Verify(dp, driver);		
			}
			
			
			
		//Rallyhood Test case 017
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 17)
		public void RallyhoodTC_17(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of SignUp Process by a user for Classes in a Group for an instructor");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.RallyHood_Single_GroupClasses_InstructorSignUp_Verify(dp, driver);		
		}
		
		
			
		//Rallyhood Test case 018
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 18)
		public void RallyhoodTC_18(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Instructor Name, Date and Time for Classes in a Group");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.RallyHood_Single_GroupClasses_InstructorName_Date_Location_Verify(dp, driver);		
		}
		
		
		
		//Rallyhood Test case 019
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 19)
			public void RallyhoodTC_19(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify past dated classes are not listed in the classes");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(dp, driver);		
			}
		
		
		//Rallyhood Test case 020
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 20)
			public void RallyhoodTC_20(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Remove Enrolled Instructor functionality in Classes of a Group");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_Instructor_RemoveButton_Verify(dp, driver);		
			}
			
			
			//Rallyhood Test case 021
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 21)
			public void RallyhoodTC_21(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of UnFollow Option for Class in a Group is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_FollowAGroup_Verify(dp, driver);		
			}
				
		
		//Rallyhood Test case 22
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority =22)
		public void RallyhoodTC_22(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify All Events are present and clickable ");
			rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
			rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
			rhhome.Multiple_RallyHood_ClickOnEvent_EventsListed_Verified(dp, driver);	
		}
			
		
		
		//Rallyhood Test case 23
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 23)
		public void RallyhoodTC_23(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify All Groups are present and clickable ");
			rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
			rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
			rhhome.Multiple_RallyHood_ClickOnGroups_GroupsListed_Verified(dp, driver);
		}
		
		
		
		//Rallyhood Test case 24
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 24)
			public void RallyhoodTC_24(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Event Name, Event Date and respective Event Image for All Events Present ");
				rhhome.MultipleEvents_Rallyhood_EventName_Date_image_Present(dp, driver);	
			}
	
			
				
		//Rallyhood Test case 25
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 25)
		public void RallyhoodTC_25(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Group Name, Members count and respective Event Image for All Groups Present ");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.MultipleGroups_Rallyhood_GroupName_MembersCount_image_Present(dp, driver);	
		}
			
				
				
	
		//Rallyhood Test case 26
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 26)
		public void RallyhoodTC_26(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Lable 'Attending?', Button 'Yes' and Button 'No' present in All Existing Event ");	
			rhhome.Multiple_Events_Screen_Buttons_Validation(dp, driver);
		}
	
			
	
		//Rallyhood Test case 27
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 27)
		public void RallyhoodTC_27(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Event Flow when user clicks on Yes button for attending event and ability to change his selection again for All Events Available");	
			rhhome.Multiple_Event_Screen_AttendingEventFlow(dp, driver);
		}
	
	
	
	//Rallyhood Test case 28
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 28)
		public void RallyhoodTC_28(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Event Flow when user clicks on 'NO' button for NOT attending the event and ability to change his selection again for ALL Events Available");
			rhhome.Multiple_Event_Screen_NOT_AttendingEventFlow(dp, driver);
		}
	
	
	
		//Rallyhood Test case 29
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 29)
		public void RallyhoodTC_29(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify ability to post comment without selecting 'Yes'/'No' button in ALL available Events");
			rhhome.Multiple_Event_Screen_Comments_Post(dp, driver);
		}
	
		
		//Rallyhood Test case 30
	@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 30)
	public void RallyhoodTC_30(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify all options are working properly for ALL available Events");
		rhhome.Multiple_Event_CommentsPostOptions_Validation(dp, driver);
	}


	//Rallyhood Test case 31
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 31)
		public void RallyhoodTC_31(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Author/Entered Comment/Entered Time of an Events");
			rhhome.Single_Event_AfterCommentPOST_VerifyCommentsValue(dp, driver);
		}
		
		
	//Rallyhood Test case 32
	@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 32)
	public void RallyhoodTC_32(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Author/Entered Comment/Entered Time of ALL available Events");
		rhhome.Multiple_Event_AfterCommentPOST_VerifyCommentsValue(dp, driver);
	}	
	
		
		
		//Rallyhood Test case 33
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 33)
		public void RallyhoodTC_33(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Comment Screen all options when Attending 'Yes' is selected for an Events");
			rhhome.Single_Event_SelectionYES_VerifyComments_CommentedValues(dp, driver);
		}
		
		
		//Rallyhood Test case 34
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 34)
		public void RallyhoodTC_34(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Comment Screen all options when Attending 'Yes' is selected for ALL available Events");
			rhhome.Multiple_Event_SelectionYES_VerifyComments_CommentedValues(dp, driver);
		}
		
		
		//Rallyhood Test case 35
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 35)
				public void RallyhoodTC_35(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Comment Screen all options when Attending 'NO' is selected for an Events");
					rhhome.Single_Event_SelectionNO_VerifyComments_CommentedValues(dp, driver);
				}
				
				
		//Rallyhood Test case 36
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 36)
		public void RallyhoodTC_36(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Comment Screen all options when Attending 'NO' is selected for ALL available Events");
			rhhome.Multiple_Event_SelectionNO_VerifyComments_CommentedValues(dp, driver);
		}
		
		
		
		//Rallyhood Test case 37
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 37)
				public void RallyhoodTC_37(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to land on same page after refreshing the page, after clicking 'Yes' to attend for All available Events");
					rhhome.Multiple_Event_Screen_AttendingEvent_PageRefresh_LandingSamePage(dp, driver);
				}					
			
			
	//Rallyhood Test case 038
	@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 38)
	public void RallyhoodTC_38(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
		loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		rhhome.TestCaseDescription(dp, driver, "TC Description : 'Read More' link to view full content of an Event is enabled and Clicked for all available Events ");
		rhhome.Multiple_EventsScreen_ReadMore_Validation(dp, driver);		
	}
	

	
	//Rallyhood Test case 039
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 39)
			public void RallyhoodTC_39(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of Follow button for ALL Class in a Group is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_FollowAGroup_Verify(dp, driver);		
			}
			

			
			//Rallyhood Test case 040
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 40)
			public void RallyhoodTC_40(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of 'Read More...' for ALL available Groups and Classes is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_ReadMoreExpand_Verify(dp, driver);		
			}		
			
		
		
	//Rallyhood Test case 041
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 41)
			public void RallyhoodTC_41(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of SignUp Process by a user for Classes in a Group for an instructor for all available groups and classes");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_InstructorSignUp_Verify(dp, driver);	
				rhhome.RallyHood_Multiple_GroupClasses_InstructorSignUp_Remove_Verify(dp, driver);
			}	
			
			
			
		//Rallyhood Test case 042
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 42)
				public void RallyhoodTC_42(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Instructor Name, Date and Time for Classes in a Group");
					//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
					rhhome.RallyHood_Multiple_GroupClasses_InstructorName_Date_Location_Verify(dp, driver);	
					rhhome.RallyHood_Multiple_GroupClasses_InstructorSignUp_Remove_Verify(dp, driver);
				}
				
				
				
			//Rallyhood Test case 043
					@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 43)
					public void RallyhoodTC_43(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
						loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
						rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Remove Enrolled Instructor functionality in All Classes  all Groups");
						//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
						rhhome.RallyHood_Multiple_GroupClasses_Instructor_RemoveButton_Verify(dp, driver);	
						rhhome.RallyHood_Multiple_GroupClasses_InstructorSignUp_Remove_Verify(dp, driver);
					}
				
		
		//Rallyhood Test case 044
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 44)
				public void RallyhoodTC_44(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of Unfollow Option for ALL Class in a Group is working properly ");
					//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
					rhhome.RallyHood_Multiple_GroupClasses_FollowAGroup_Verify(dp, driver);		
				}
				
				
				
		//Rallyhood Test case 045
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 45)
			public void RallyhoodTC_45(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify past dated classes are not listed in the Classes for all Groups");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(dp, driver);	
			}
			
		


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Parallel Execution #########################################
	
	/*//Rallyhood test case 01
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 1)
		public void RallyhoodTC_01(RHhomeDP dp, ITestContext context) {
			context.setAttribute("dpName", dp.td.get("DataRow"));
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Rallyhood Home screen is displayed and Events/Groups and Classes sections are present");
			rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
			rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
		}
		
		
			//Rallyhood test case 02
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 2)
			public void RallyhoodTC_02(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
				context.setAttribute("dpName", dp.td.get("DataRow"));
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify error message on browser saying app_uid is invalid. ");
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.VerifyInvalid_app_uid(dp, driver);
				
			}
			
			
			
			//Rallyhood test case 03
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 3)
			public void RallyhoodTC_03(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
				context.setAttribute("dpName", dp.td.get("DataRow"));
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify error message on browser saying app_uid is invalid. ");
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.VerifyInvalid_secret_key(dp, driver);	
			}
		
		
		
		//Rallyhood test case 05
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 5)
		public void RallyhoodTC_05(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {
			context.setAttribute("dpName", dp.td.get("DataRow"));
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify single Events/Groups and Classes are present and clickable ");
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
			rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
			rhhome.RallyHood_ClickOnEvent_EventsListed(dp, driver);
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.RallyHood_ClickOnGroupClasses_GroupClassesListed(dp, driver);
			rhhome.PageUp(dp, driver);
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
		}


		//Rallyhood Test case 06
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 6)
			public void RallyhoodTC_06(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Event Name, Event Date and respective Event Image for single Event Present");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.SingleEvent_Rallyhood_EventName_Date_image_Present(dp, driver);	
			}
			
			
			//Rallyhood Test case 07
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 7)
			public void RallyhoodTC_07(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Lable 'Attending?', Button 'Yes' and Button 'No' present in an Event ");
				rhhome.Single_Events_Screen_Buttons_Validation(dp, driver);	
				
			}
	
	
	//Rallyhood Test case 10
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 8)
			public void RallyhoodTC_10(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify ability to post comment without selecting 'Yes'/'No' button in an Event");
				rhhome.Single_Event_Screen_Comments_Post(dp, driver);
			}
			
			
			//Rallyhood Test case 11
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 9)
				public void RallyhoodTC_11(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify all options are working properly for an Event");
					//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
					rhhome.Single_Event_CommentsPostOptions_Validation(dp, driver);
				}	
			
			
			
			//Rallyhood Test case 012
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 10)
			public void RallyhoodTC_12(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : 'Read More' link to view full content of an Event is enabled and Clicked in an Event ");
				rhhome.Single_EventsScreen_ReadMore_Validation(dp, driver);		
			}
		
	
			//Rallyhood Test case 14
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 11)
			public void RallyhoodTC_14(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Group Name, Members count and respective Event Image for single Group Present ");
				rhhome.SingleGroup_Rallyhood_GroupName_MembersCount_image_Present(dp, driver);	
			}
			
			//Rallyhood Test case 016
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 12)
			public void RallyhoodTC_16(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of 'Read More ..' for Groups and Classes is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_ReadMoreExpand_Verify(dp, driver);		
			}
			
		//Rallyhood Test case 018
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 13)
		public void RallyhoodTC_18(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Instructor Name, Date and Time for Classes in a Group");
			//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
			rhhome.RallyHood_Single_GroupClasses_InstructorName_Date_Location_Verify(dp, driver);		
		}
		
		
		
		//Rallyhood Test case 019
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 14)
			public void RallyhoodTC_19(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify past dated classes are not listed in the classes");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Single_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(dp, driver);		
			}
			
			
	//Rallyhood Test case 22
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority =15)
			public void RallyhoodTC_22(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify All Events are present and clickable ");
				rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
				rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
				rhhome.Multiple_RallyHood_ClickOnEvent_EventsListed_Verified(dp, driver);	
			}
				
			
			
			//Rallyhood Test case 23
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 16)
			public void RallyhoodTC_23(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify All Groups are present and clickable ");
				rhhome.Rallyhood_HomeScreen_Events_HeaderDisplay(dp, driver);
				rhhome.Rallyhood_HomeScreen_ClassesGroups_HeaderDisplay(dp, driver);
				rhhome.Multiple_RallyHood_ClickOnGroups_GroupsListed_Verified(dp, driver);
			}
			
			
			
			//Rallyhood Test case 24
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 17)
				public void RallyhoodTC_24(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Event Name, Event Date and respective Event Image for All Events Present ");
					rhhome.MultipleEvents_Rallyhood_EventName_Date_image_Present(dp, driver);	
				}
		
				
					
			//Rallyhood Test case 25
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 18)
			public void RallyhoodTC_25(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Group Name, Members count and respective Event Image for All Groups Present ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.MultipleGroups_Rallyhood_GroupName_MembersCount_image_Present(dp, driver);	
			}
				
					
					
		
			//Rallyhood Test case 26
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 19)
			public void RallyhoodTC_26(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify presence of Lable 'Attending?', Button 'Yes' and Button 'No' present in All Existing Event ");	
				rhhome.Multiple_Events_Screen_Buttons_Validation(dp, driver);
			}
		
				
		
			
			//Rallyhood Test case 29
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 20)
			public void RallyhoodTC_29(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify ability to post comment without selecting 'Yes'/'No' button in ALL available Events");
				rhhome.Multiple_Event_Screen_Comments_Post(dp, driver);
			}
		
			
			//Rallyhood Test case 30
		@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 21)
		public void RallyhoodTC_30(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
			loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
			rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify all options are working properly for ALL available Events");
			rhhome.Multiple_Event_CommentsPostOptions_Validation(dp, driver);
		}
		
	

			//Rallyhood Test case 31
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 22)
				public void RallyhoodTC_31(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Author/Entered Comment/Entered Time of an Events");
					rhhome.Single_Event_AfterCommentPOST_VerifyCommentsValue(dp, driver);
				}
				
				
			//Rallyhood Test case 32
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 23)
			public void RallyhoodTC_32(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verifying user is able to post comment for an event available and verify Author/Entered Comment/Entered Time of ALL available Events");
				rhhome.Multiple_Event_AfterCommentPOST_VerifyCommentsValue(dp, driver);
			}	
			
			//Rallyhood Test case 038
				@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 24)
				public void RallyhoodTC_38(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
					loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
					rhhome.TestCaseDescription(dp, driver, "TC Description : 'Read More' link to view full content of an Event is enabled and Clicked for all available Events ");
					rhhome.Multiple_EventsScreen_ReadMore_Validation(dp, driver);		
				}
				
	
			//Rallyhood Test case 040
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 25)
			public void RallyhoodTC_40(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify Functionality of 'Read More...' for ALL available Groups and Classes is working properly ");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_ReadMoreExpand_Verify(dp, driver);		
			}	
			
		
			
			//Rallyhood Test case 045
			@Test(dataProvider = "RHhomeDP", enabled = true, groups = "Smoke", priority = 27)
			public void RallyhoodTC_45(RHhomeDP dp, ITestContext context) throws FileNotFoundException, Exception {context.setAttribute("dpName", dp.td.get("DataRow"));
				loadURL(PropertyFileUtils.getPropValuesFromConfig(Constants.WEB_PROPERTIES_FILE, "web.app.url"), driver,browserName);
				rhhome.TestCaseDescription(dp, driver, "TC Description : Verify past dated classes are not listed in the Classes for all Groups");
				//rhhome.Rallyhood_Mobileview(dp, driver,browserName);
				rhhome.RallyHood_Multiple_GroupClasses_ClassesDate_GreaterThanCurrentDate_Verify(dp, driver);	
			}
			
			
	*/
	
	
	
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Parallel Execution #########################################
			
	
				
	/*@Test(dataProvider = "SourceDP", enabled = true, groups = "Smoke", priority = 2)
	public void updateSource(SourceDP dp, ITestContext context) {
		context.setAttribute("dpName", dp.td.get("DataRow"));
	}*/

	
	

	
//	@Test(dataProvider = "LoginDP2", enabled = true, groups = "Smoke", priority = 8)
//	public void loginApplicationFailure(LoginDP dp, ITestContext context) {
//		context.setAttribute("dpName", dp.td.get("DataRow"));
//		login.validateLogin(dp, driver);
//	}

/*	@AfterClass(alwaysRun = true)
	public void tearDown() {

		System.out.println("***RallyHood script execution Completed***");
		driver.quit();
	}*/
		
		
		/*try {

			if (driver != null) {
				driver.quit();

			}
		} catch (Exception e) {
			//throw new RuntimeException("teardown() method failed to execute " + e);
		}*/

}