package executionEngine;



import config.ActionKeywords;
import config.Constants;
import dataProviders.ConfigfileReader;
import utility.ExcelUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class DriverScript {
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method[] method;
	public static Properties OR;
	 public static String sPageObject;
	 public static String Path_OR=Constants.Path_File_OR;
	 public static String sTestCaseID;
	 public static int iTestStep;
	 public static int iTestLastStep;
	 public static String sRunMode;
	
	public DriverScript() throws Exception
	{
		actionKeywords=new ActionKeywords();
		method=actionKeywords.getClass().getMethods();
		ConfigfileReader configfileReader=new ConfigfileReader();
		
	
	//	FileInputStream fs =new FileInputStream(Path_OR);
		//Properties properties=new Properties(System.getProperties());
		//properties.load(fs);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		String ExcelPath=Constants.Path_TestData;
		System.out.println("File Found");
		ExcelUtils.setExcelFile(ExcelPath);
		System.out.println("setting path");
		System.setProperty("webdriver.gecko.driver",Constants.Path_Firefox_driver);
		System.out.println("Starting loop");
		//String Path_OR=Constants.Path_File_OR;
		
		//FileInputStream fs =new FileInputStream(Path_OR);
		//Properties properties=new Properties(System.getProperties());
		//properties.load(fs);
		
		DriverScript  driverScript=new DriverScript();
		driverScript.execute_TestCase();
	}
	 private void execute_TestCase() throws Exception {
		//This will return the total number of test cases mentioned in the Test cases sheet
	     int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
	     for(int iTestcase=1;iTestcase<iTotalTestCases;iTestcase++){
	    	 //This is to get the Test case name from the Test Cases sheet
	    	 System.out.println("This is to get the Test case name from the Test Cases sheet");
	    	 sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases);
	    	 System.out.println("Test case name from Sheet_TestCases"+sTestCaseID);
	    	 //This is to get the value of the Run Mode column for the current test case
	    	 System.out.println("checking run mode");
	    	 sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);
	    	 if (sRunMode.equals("Yes")){
	    		 //Only if the value of Run Mode is 'Yes', this part of code will execute
	    		 iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
	    		 System.out.println("This is first step"+iTestStep);
	    		 iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
	    		 System.out.println("This is last step"+iTestLastStep);
	    		 for (;iTestStep<iTestLastStep;iTestStep++){
	    		      sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);
	    		      sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject, Constants.Sheet_TestSteps);
	    		      execute_Actions();
	    		      }
	    		 } else {
	    			 System.out.println("No more test cases to run");
	    		 }
	    		     }
	    		     }
	 
		
		//for (int iRow=1;iRow<=8;iRow++)
		//{
		 //sActionKeyword= ExcelUtils.getCellData(iRow,Constants.Col_ActionKeyword);
		//sPageObject = ExcelUtils.getCellData(iRow,Constants.Col_PageObject);
		//System.out.println(sActionKeyword);
		//System.out.println(sPageObject);
		//execute_Actions();
	//	}

	
	private static void execute_Actions() throws Exception {
	//	DriverScript  driverScript=new DriverScript();
	for (int i=0;i<method.length;i++)
	{
		if (method[i].getName().equals(sActionKeyword))
		{
			method[i].invoke(actionKeywords,sPageObject);
			break;
		}
	}
	}
}
		
