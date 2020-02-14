package utility;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Constants;

public class ExcelUtils {

	//create static methods
	//To read XLS files, an HSSF implementation is provided by POI library.
	//To read XLSX, XSSF implementation of POI library
	//method to set file and workbook
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFWorkbook ExcelWBook;
	
	
	public static void setExcelFile(String Path) throws Exception
	{
		FileInputStream ExcelFile=new FileInputStream(Path);
		ExcelWBook=new XSSFWorkbook(ExcelFile);
		//ExcelWSheet=ExcelWBook.getSheet(SheetName);
		
	}
	
	
	public static String getCellData(int RowNum,int RowCol,String SheetName) {
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		Cell=ExcelWSheet.getRow(RowNum).getCell(RowCol);
		String CellData=Cell.getStringCellValue();
		System.out.println("Sheetname:"+SheetName);
		System.out.println(CellData);
		return CellData;
		
	}
	
	//to get Row count
	
	public static int getRowCount(String SheetName)
	{
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		int totalrows=ExcelWSheet.getLastRowNum()+1;
		System.out.println("Total rows:"+totalrows);
		return totalrows;
		
	}
	
	//to get row number of test case from sheet
	public static int getRowContains(String sTestCasename,int colNum,String SheetName )
	{
		int i;
		ExcelWSheet=ExcelWBook.getSheet(SheetName);
		int rowCount=ExcelUtils.getRowCount(SheetName);
		for (i=1;i<=rowCount;i++)
		{
			if (ExcelUtils.getCellData(i, colNum, SheetName).equalsIgnoreCase(sTestCasename))
			{
				break;
			}
		}
		return i;
	}
	
	
	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception{
        for(int i=iTestCaseStart;i<ExcelUtils.getRowCount(SheetName);i++){
        	System.out.println(i);
        if(!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))){
        int number = i;
        return number;
        }
        }
        ExcelWSheet = ExcelWBook.getSheet(SheetName);
        int number=ExcelWSheet.getLastRowNum()+1;
        return number;
        }
}



