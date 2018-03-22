package com.test.automation.POMFrameWork.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fos;
	
	
	public Excel_Reader(String path){
		this.path = path;
		try{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public String[][] getData(String sheetName){
		String dataSet[][] = null;
		try{
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum();
			System.out.println("totalRows"+totalRows);
			int totalColumns = sheet.getRow(0).getLastCellNum();
			System.out.println("totalColumns"+totalColumns);
			dataSet = new String [totalRows][totalColumns];
			for(int i=1; i<=totalRows; i++){
				row = sheet.getRow(i);
				for(int j=0; j<totalColumns; j++){
					cell = row.getCell(j);
					if(cell.getCellType()==cell.CELL_TYPE_STRING){
						dataSet[i-1][j]=cell.getStringCellValue();
					}else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
						dataSet[i-1][j]= String.valueOf(cell.getStringCellValue());
					}
				}
			}return dataSet;
		}catch(Exception e){
			System.out.println("Exception in reading excel file"+e.getMessage());
			e.printStackTrace();
		}
		return dataSet;
	}
}
















