package PracticeProgramVTiger;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtility.ExcelUtility;
import genericUtility.IConstantUtility;

public class PracticeReadDataFromExcelUtility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
	ExcelUtility eu = new ExcelUtility();
	// read data from excelSheet
	String ans = eu.readDataFromExcelsheet("Contacts", 1, 2);
    System.out.println(ans);
    
    // count last row data
     int count = eu.getRowCount("Organisation");
     System.out.println(count);
     
     // write data in excel sheet
       eu.writeDataInExcelSheet("Contacts", 3, 4, "Tc_ID");
     
     
     
	}

}
