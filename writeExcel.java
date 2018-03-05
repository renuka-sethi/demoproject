package cdsUpload;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.google.common.collect.Table.Cell;


public class writeExcel {
	
	static //define an Excel Work Book
	FileInputStream file;
	   static XSSFWorkbook workbook;
	   //define an Excel Work sheet
	   static  XSSFSheet sheet;
	   
	public  void writeXLSX(String excel, String Sheet, String val, int rowindex, int colindex ) throws Exception 
	{
		file=new FileInputStream(excel);
	 workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheet(Sheet);   // getSheetAt(0);
	XSSFCell cell2Update = sheet.getRow(rowindex).getCell(colindex);
	//System.out.println(val);
	
	cell2Update.setCellValue(val);
	file.close();
	FileOutputStream outputStream = new FileOutputStream(excel);
	workbook.write(outputStream);
	
	workbook.close();
	outputStream.close();
    }
}


