package com.deere.TestCasesFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.deere.Helpers.BaseClass;
import com.deere.Helpers.ExcelFactory;
import com.deere.Helpers.GenericFactory;
import com.deere.Helpers.LogFactory;
import com.deere.Helpers.ReportFactory;
import com.deere.PageFactory.Announcements_POF;
import com.deere.PageFactory.Favorites_POF;
import com.deere.PageFactory.PortalLeftNavigation_POF;

public class Favourite_TestCase_old {
	private static ArrayList<String> CreatedMarkedFavlinkname= new  ArrayList<String> ();

	@BeforeClass
	public void getReportHeader() throws InterruptedException {
		GenericFactory.createHeaderSection("Portal Favourite");
	}
	
// **************************************************** E - N - D **********************************************************************************************************

	
	// No need test data
	// @Test(priority = -1) 
	
	
@Test(priority = 1) 
	 // Create top five link as Favourite on a Department page
	 //  Favorite should display on Quick Favorite modal window on home, Department
	 public static void verifyToCreateFavourite() throws Throwable 
	 {
		String TCID = "TC01_Favourite";
		String ContentType= "AT-Favourite";
		String strDepartmentNameFromExcel = BaseClass.getExcelDataByTestCaseID(TCID);
		//List<LinkedHashMap> userWCMContent = ExcelFactory.getUserWcmDetailsAfterFilteringCountryAndProduct("AT-Link");
		//LinkedHashMap test = userWCMContent.get(0);
		//System.out.println(test.get("DepartmentName"));		 
	     LogFactory.beginTestCase("Verify creating a favorite in default favorite folder for dealer, employee/authorized contingent. ");	 	  		  
		
	     CreatedMarkedFavlinkname= Favorites_POF.createFavouriteOnDepartment(TCID, ContentType,strDepartmentNameFromExcel);
			
		  LogFactory.info("Created Marked Fav Link is  "+CreatedMarkedFavlinkname);
		  LogFactory.endTestCase(" ");
	 }
	 
// **************************************************** E - N - D **********************************************************************************************************
	
	 // need test data
		@Test(priority = 2)
		public static void VerifyToFavouriteDifferentLanguagesOnHomepage()  throws Throwable
		{	
			String TCID = "TC02_Favourite";
			
			LogFactory.beginTestCase("Verify Favourite for different Language on homepage ");
		  // breaking
			String linkName= "";
			
			//String strDepartmentNameFromExcel = BaseClass.getExcelDataByTestCaseID(TCID);

			
			if(CreatedMarkedFavlinkname.size()>0)
			{
				linkName = CreatedMarkedFavlinkname.get(0).toString().trim();
			}
			
			Favorites_POF.verifyFavouritesDifferentLanguagesOnHomepage(TCID, linkName);
		  
		 }
		
		
// **************************************************** E - N - D **********************************************************************************************************	 
		
		// No need test data
	@Test(priority = 3)
	
	 public static void verifyToCreateFolder() throws Throwable 
	 {		 
		 String TCID = "TC03_Favourite";
		  String ContentType = "AT-Favourite";	  
		 String folderName = "Test16394";
		 
		 LogFactory.beginTestCase("Verify creating folder for favorites from favorite portlet on homepage.");
		  	 
		 Favorites_POF.verifyCreateFolder(TCID, ContentType, folderName);
		  
		  LogFactory.endTestCase(" ");
		 
		  
			
	 }
	 
// **************************************************** E - N - D **********************************************************************************************************
	
	// No need test data
			@Test(priority = 4) 
	 public static void verifyToDeleteFavouriteFolder() throws Throwable 
	  {	     
		String TCID= "TC04_Favourite";
	     String folderName="Test16394";
	   
	     LogFactory.beginTestCase("Verify Deleting Folder in Favorite portlet on homepage.");
	   
	     Favorites_POF.verifyDeleteFavouriteFolder(TCID, folderName);
	     LogFactory.endTestCase("");
	   
	  }
	 
// **************************************************** E - N - D **********************************************************************************************************
 
			 // Not need test data  we are taking from created Fav Link and method dept name must be same 
	@Test(priority = 5) 
	 public static void verifyToRemoveFavouriteLinkfromlinkportlet() throws Throwable 
	 {
		String TCID= "TC04_Favourite";
		String ContentType = "AT-Favourite";
		
		String linkName= "";
		
		String strDepartmentNameFromExcel = BaseClass.getExcelDataByTestCaseID(TCID);

		
		if(CreatedMarkedFavlinkname.size()>0)
		{
			linkName = CreatedMarkedFavlinkname.get(0).toString().trim();
		}
		 
	     	LogFactory.beginTestCase("Verify removing a favorite from links portlet Department Page ");		

				  
			Favorites_POF.verifyRemoveFavouriteLink(TCID, ContentType, strDepartmentNameFromExcel, linkName);
	      	        
	        LogFactory.endTestCase("");
	    

	
	 }
	// *****************************************END***************************************
	@Test(priority = 6) 
	 public static void verifyToRemoveFavouriteLinkfromQuickmodalwindow() throws Throwable 
	 {
		String TCID= "TC04_Favourite";
		String ContentType = "AT-Favourite";
	
		String linkName= "";
		
			
		if(CreatedMarkedFavlinkname.size()>0)
		{
			linkName = CreatedMarkedFavlinkname.get(1).toString().trim();
		}
		 
	     	LogFactory.beginTestCase("Verify removing a favorite from ToRemoveFavouriteLinkfromQuickmodalwindow ");		

	  
			Favorites_POF.ToRemoveFavouriteLinkfromQuickmodalwindow(TCID,  linkName);
	      	        
	        LogFactory.endTestCase("");
	    

	
	 }
	// *****************************************END***************************************
	@Test(priority = 7) 
	public static void verifyToRemoveFavLinkfromFavoritesPortlethomepage() throws Throwable 
	 {
		String TCID= "TC04_Favourite";
	
		String linkName= "";
			
		if(CreatedMarkedFavlinkname.size()>0)
		{
			linkName = CreatedMarkedFavlinkname.get(2).toString().trim();
		}
		 
	     	LogFactory.beginTestCase("Verify removing a favorite from 'Favorites Portlet' on homepage,");		

	  
			Favorites_POF.ToRemoveFavLinkfromFavoritesPortlethomepage(TCID,  linkName);
	      	        
	        LogFactory.endTestCase("");
	    

	
	 }
	
	
// **************************************************** E - N - D **********************************************************************************************************
// no need test data
	@Test(priority = 8) 
	 public static void verifyToMovingFavouriteFolderandLink() throws Throwable 
	 {
		 String TCID= "TC06_Favourite";
		LogFactory.beginTestCase("verify Moving Favourite Folder and Link ");
	  
		Favorites_POF.verifyMovingFavouriteFolderandLink(TCID);
	    LogFactory.endTestCase("");
	    
	    
	 }
	 
// **************************************************** E - N - D **********************************************************************************************************

 // no need test data
	 @Test(priority = 9) 
	 public static void verifyToExpandAndCollapseFavroiteFolder() throws Throwable 
	 {	
		 String TCID= "TC07_Favourite";
		  String ContentType = "AT-Favourite";	  
		  	 
		  LogFactory.beginTestCase("verify Expand And Collapse Favroite Folder ");
		  
		  Favorites_POF.verifyExpandAndCollapseFavroiteFolder(TCID, ContentType);
		   LogFactory.endTestCase("");
		  
	 }
	 
// **************************************************** E - N - D **********************************************************************************************************
// no need test data
		 
	 @Test(priority = 10) 
	 
	 //Verify Quick Favourite modal window on Home, Department and all levels of Index pages.
	 public static void VerifyToQuickModalonHomeDepartmentandalllevelsofIndexpages() throws Throwable 
	  {   
		 String TCID= "TC08_Favourite";
		 String ContentType = "AT-Favourite";
	    	      
	    LogFactory.beginTestCase("Verify Quick Favorite modal window on Home, Department pages.");
	    
	    Favorites_POF.verifyQuickModalWindowOnHomepage(TCID);
	    LogFactory.endTestCase(" ");
	    
	   
	  }
//**************************************************** E - N - D **********************************************************************************************************

	 // no need test data
	 @Test(priority = -9)  
	 
	 //Verify filtering of the Favourite portlet.		
	 public static void verifyFilteringOnHomepage() throws Throwable
		{
			String TCID="TC09_Favourite";
			String ContentType = "AT-Favourite";
						
			LogFactory.beginTestCase("verify Filtering on Favourite portlet on Homepage");
			
			Favorites_POF.VerifyFilter1(TCID,"na");	
			
		}
		
		 
//**************************************************** E - N - D **********************************************************************************************************
		
	 
	// need test data
	
  @Test(priority = 10)
	public static void VerifyToFavouriteDifferentLanguagesOnDepartment()  throws Throwable
	{
	   String TCID = "TC10_Favourite";
	   String linkName = "";
		
	   String strDepartmentNameFromExcel = BaseClass.getExcelDataByTestCaseID(TCID);
	   if(CreatedMarkedFavlinkname.size()>0)
		{
		   linkName = CreatedMarkedFavlinkname.get(0).toString().trim();
		}
	   
	  
	   
		LogFactory.beginTestCase("Verify Favourite for Different Language on Deaprtmnet");
	  
		Favorites_POF.VerifyFavouriteForPreffredDept(TCID, strDepartmentNameFromExcel, linkName);
		LogFactory.endTestCase("");
		
		
	  
	 }
	
	// need test data
	@Test(priority = 11)
	
	public static void VerifyToFavouriteOnNonPrefferedDepartment()  throws Throwable
	{
		String TCID = "TC11_Favourite";
		String linkName = "";
		
		String strDepartmentNameFromExcel = BaseClass.getExcelDataByTestCaseID(TCID);
		
		if(CreatedMarkedFavlinkname.size()>0)
		{
			linkName = CreatedMarkedFavlinkname.get(1).toString().trim();
		}
		
		
		LogFactory.beginTestCase("Verify Favourite for non-preferred deaprtmnet ");
	  
		
		Favorites_POF.VerifyFavouriteForNonPreffredDept(TCID, strDepartmentNameFromExcel, linkName);
		LogFactory.endTestCase("");
	  
	 }
	/*
	
// **************************************************** E - N - D **********************************************************************************************************
	// need test data
	//@Test(priority = 12)
	//public static void verifyToFavouriteOnChanginProductType()  throws Throwable
	//{
		String TCID = "TC12_Favourite";
		String ContentType = "AT-Favourite";
			 
		LogFactory.beginTestCase("Verify Favourite on changing the Product Type ");
	  
		Favorites_POF.VerifyFavouritesOnchangingProductTypeOnHomePage(TCID, "CWP", "Agriculture Equipment & Forage Harvester - Commercial");
	  
		
		
	
         
        List<LinkedHashMap> userWCMContent =ExcelFactory.getWCMContentDetails("AT-Alert");
       
       
                      for (int i =0; i <userWCMContent.size(); i++) 
                      { 
                                     String wcmTestCaseID = (String) userWCMContent.get(i).get("Test Case ID").toString().trim();
                                    String userCountry=(String)userWCMContent.get(i).get("Dealer_Country"); 
                                     String wcmCountry=(String)userWCMContent.get(i).get("Country");
                                    String Title = (String) userWCMContent.get(i).get("Title");
                                    String userProductType=(String) userWCMContent.get(i).get("Dealer_ProductType"); 
                                     String wcmProductType=(String) userWCMContent.get(i).get("ProductType");
       
                                     LogFactory.beginTestCase("verify alerts content filtered based on product types");
                     alertPageFactory.checkAlertContentFilterOnProductTypes(userCountry,wcmCountry,userProductType, wcmProductType, Title, wcmTestCaseID);
                     } 
        }

	 
	

// **************************************************** E - N - D **********************************************************************************************************
	
	// need test data
	//@Test(priority = 13)
	public static void verifyCopyFavouriteDealerUser()  throws Throwable
	{
		String TCID = "TC13_Favourite";
		String Dealeruserid = BaseClass.strUserRACFID;
			 
		LogFactory.beginTestCase("Verify copy Favourite for dealer user ");
	  
		Favorites_POF.verifyCopyFavouriteForDealer(TCID,Dealeruserid);
		LogFactory.endTestCase("");
		
	 }
	

// **************************************************** E - N - D **********************************************************************************************************
	// need test data
	//@Test(priority = 14)
	public static void verifyCopyFavouriteEmployeeUser()  throws Throwable
	{
		String TCID = "TC14_Favourite";
		String EMPID = "ss99532";
			 
		LogFactory.beginTestCase("Verify copy Favourite for Employee/Authorized contingent user ");
	  
		Favorites_POF.verifyCopyFavouriteForEmployee(TCID, EMPID);
	  
	 }
	
*/
// **************************************************** E - N - D **********************************************************************************************************
	
	
	@AfterClass
		public void getReportFooter() throws InterruptedException {
			LogFactory.endTestCase("Favourite Testcases");
			ReportFactory.tableEnd();
			
		}	

}
