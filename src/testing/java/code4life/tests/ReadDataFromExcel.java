package code4life.tests;


import code4life.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest () throws IOException {

        //load the excel file as a file
        File file = new File("Book2.xlsx");

        Workbook book = WorkbookFactory.create(file);
        //get the first sheet
        Sheet workSheet = book.getSheet("Sheet1");
        //get the first row
        Row firstRow = workSheet.getRow(0);
        //get the first cell
        Cell firstCell = firstRow.getCell(0);
        //using cell method to get the value as string
        String value = firstCell.getStringCellValue();
        System.out.println(" First cell value = " + value);
        
        String secondCellValue = firstRow.getCell(1).getStringCellValue();
        System.out.println("second Cell Value = " + secondCellValue);
        int lastCell = firstRow.getLastCellNum();
        System.out.println("Printing all values from first row :: ");
        System.out.println();
        System.out.println("**********************************");
        for (int i = 0; i < lastCell; i++) {
            System.out.print(firstRow.getCell(i) +  " | ");

        }
        System.out.println();
        System.out.println("**********************************");

        int numOfRows = workSheet.getLastRowNum();
        System.out.println("Total number of rows  = "+ numOfRows+"\n");
        System.out.println("printing all values from all columns:: \n");

        for (int row = 0; row <workSheet.getPhysicalNumberOfRows() ; row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue() ;
                System.out.print(cellValue + "  |  ");

            }
            System.out.println();

        }


//        XLUtility  utility = new XLUtility("Book1.xlsx");
//        utility.getCellData("Sheet1", 1, 2 );
//        System.out.println(utility.getCellData("Sheet1", 1, 2));


    }

    @Test
    public void gettingDataAsListOfMap(){
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");
        //System.out.println(utility.getDataList());
        //utility.getDataList().forEach(System.out::println);
        for (Map<String, String> record : utility.getDataList()  ) {
            System.out.println(record);

        }
    }

    @Test
    public void getColumnNames(){
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");
        System.out.println(utility.getColumnNames());
    }

    @Test
    public void returnTotalNoOfColumns(){
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");
     int count =    utility.columnCount();
        System.out.println(count);
    }

    @Test
    public void returnTotalNoOfRows(){
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");
        int count =    utility.rowCount();
        System.out.println(count);
    }

    @Test
    public void getDataFromCell(){
        ExcelUtil utility = new ExcelUtil("Book2.xlsx", "Sheet1");
        String count =    utility.getCellData(0,1);
        System.out.println(count);
    }
}
