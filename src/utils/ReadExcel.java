package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 
import model.User;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class ReadExcel {
     
    public static User readData() throws IOException {
        String excelFilePath = "Transport.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        User user = new User();        
        
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                
                              
                switch (count) {
                    case 1:                       
                        user.setFristName(cell.getStringCellValue());
                        break;
                    case 2:                       
                        user.setLastName(cell.getStringCellValue());
                        break;
                    case 3:                        
                        user.setFromLocation(cell.getStringCellValue());
                    case 4:                    	
                        user.setToLocation(cell.getStringCellValue());
                        break;
                }
                
                count++;
                
            }            
        }         
        
        inputStream.close();
        return user;
    }
 
}