package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class read data from excelsheet
 * @author HP
 *
 */
public class ExcelUtility
{
	/**
	 * this method will read data from excelsheet for sheetname,row and cell
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcelsheet(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantUtility.TestDataExcelSheetFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row rw = sh.getRow(row);
    Cell ce = rw.getCell(cell);
    String val = ce.getStringCellValue();
    return val;
}
/**
 * this method count row from excell sheet
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getRowCount (String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantUtility.TestDataExcelSheetFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	int rowcount = sh.getLastRowNum();
	return rowcount;
}
/**
 * this method to write data in to excelsheet for user specified sheetname,cellnum,rownum,data
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @param cellval
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataInExcelSheet(String sheetname,int rownum,int cellnum,String cellval) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantUtility.TestDataExcelSheetFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetname);
	Row rw = sh.getRow(rownum);
	Cell ce = rw.createCell(cellnum);
	ce.setCellValue(cellval);
	
	FileOutputStream fos =  new FileOutputStream(IConstantUtility.TestDataExcelSheetFilePath);
	wb.write(fos);
	wb.close();
	System.out.println("data written successfully");
}

/**
 * this method will read all data present in execelSheet
 * @param Sheetname
 * @return 
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultiData(String Sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(IConstantUtility.TestDataExcelSheetFilePath);
      Workbook wb = WorkbookFactory.create(fis);
      Sheet sh = wb.getSheet(Sheetname);
      int lastRow = sh.getLastRowNum();
     int lastCell = sh.getRow(0).getLastCellNum();
     
     Object[][] data = new Object[lastRow][lastCell];
     for(int i = 0;i<lastRow;i++)
     {
    	 for(int j =0;j<lastCell;j++)
    	 {
    		 data[i][j]= sh.getRow(i+1).getCell(j).toString();
    	 }
     }
     
     return data;
      
}
}
























