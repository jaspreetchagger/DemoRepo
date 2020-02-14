package config;

public class Constants {

	public static final String URL="http://www.store.demoqa.com";
	 public static final String Path_TestData = "src\\dataEngine\\DataEngine.xlsx";
	 public static final String File_TestData = "DataEngine.xlsx";
	 public static final String Path_File_OR="src\\config\\OR.properties";
	
	//List of Data Sheet Column Numbers
	 public static final int Col_TestCaseID = 0; 
	 public static final int Col_TestScenarioID =1 ;
	 public static final int Col_PageObject=3;
	 public static final int Col_ActionKeyword =4 ;
	 public static final int Col_Description=1;
	 public static final int Col_RunMode=2;
	 	 
	 //List of Data Engine Excel sheets
	 public static final String Sheet_TestSteps = "Test Steps";
	 public static final String Sheet_TestCases="Test Cases";
	
	//Test data
	public static final String username="testuser_3";
	public static final String  password="Test@123";
	
	//WebDriver Properties
	public static final String Path_Firefox_driver="src\\\\Driver\\\\geckodriver.exe";
}
