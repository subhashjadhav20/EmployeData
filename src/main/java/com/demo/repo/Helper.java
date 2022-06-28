package com.demo.repo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Employe;

public class Helper {
  // Check file is Excel type
	public static boolean checkExcelFormat (MultipartFile file) {
		
	String contentType=	file.getContentType();
	if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
		return true;
	}else {
		return false;
	}
	}
	
	// convert excel to list of employee
	public static List<Employe> convertExcelToListofemploye(InputStream is){
		List<Employe> list=new ArrayList<>();
		try {
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet= workbook.getSheet("Sheet1");
			int rowNumber=0;
		Iterator<Row> iterator=	sheet.iterator();
			
		while(iterator.hasNext()) {
			Row row=iterator.next();
			if(rowNumber==0) {
				rowNumber++;
				continue;
			}
		Iterator<Cell> cells=row.iterator();
		int eid=0;
		Employe emp=new Employe();
		while(cells.hasNext()) {
			Cell cell=cells.next();
			switch(eid) {
			case 0:
			emp.setEmployeId((int)cell.getNumericCellValue());
			break;
			case 1:
			emp.setName(cell.getStringCellValue());
			break;
			case 2:
			emp.setAddress(cell.getStringCellValue());
			break;
			case 3:
			emp.setMonileNumber((int)cell.getNumericCellValue());
			break;
			default :
			break;
			
			}
			eid++;
		}
		list.add(emp);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
