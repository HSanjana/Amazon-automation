package com.qa.amazon;


	import java.io.FileInputStream;

	import java.io.IOException;


	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
		static FileInputStream fileLoc;
		static XSSFWorkbook wBook;
		static XSSFSheet wSheet;
		static XSSFRow row;
		static XSSFCell cell;
		
		//row count
		public static int getRowCount(String xfile,String xSheet) throws IOException {
			fileLoc =new FileInputStream(xfile);
			wBook=new XSSFWorkbook(fileLoc);
			wSheet=wBook.getSheet(xSheet);
			
			int rowCount = wSheet.getLastRowNum();
			wBook.close();
			fileLoc.close();
			
			return rowCount;
		}
		//cell counts
		public static int getCellCount(String xfile,String xSheet,int rowNum) throws IOException {
			fileLoc =new FileInputStream(xfile);
			wBook=new XSSFWorkbook(fileLoc);
			wSheet=wBook.getSheet(xSheet);
			
			row = wSheet.getRow(rowNum);
			int cellCount=row.getLastCellNum();
			
			wBook.close();
			fileLoc.close();
			
			return cellCount;
		}
		//Value in each cell
		public static String getcellData(String xfile,String xSheet,int rowNum,int colnum) throws IOException {
			fileLoc =new FileInputStream(xfile);
			wBook=new XSSFWorkbook(fileLoc);
			wSheet=wBook.getSheet(xSheet);
			
			row = wSheet.getRow(rowNum);
			cell=row.getCell(colnum);
			
			DataFormatter formater=new DataFormatter();
			String cellData=formater.formatCellValue(cell);
			
			wBook.close();
			fileLoc.close();
			
			return cellData;
		}
}
