package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelibrary {

 	/**
	 * this method is a generic method used to read data from property file 
	 * @throws IOException 
	 */
	
	public String readdataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./Testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
	}
	
	/**
	 * this method is a generic method used to read data from Excel file
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Testdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;
		
		
	}
	
	/**
	 * this method is generic method used to update the value in the excel file.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param Updatevalue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void updateExceldata(String sheet,int row,int cell,String Updatevalue) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Testdata/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(Updatevalue);
		FileOutputStream fos = new FileOutputStream("./Testdata/testdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}

	

}


