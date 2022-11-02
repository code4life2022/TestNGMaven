package code4life.tests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class DataP {

    public static void main(String[] args) throws Exception {
        File file = new File("Book1.xlsx");

        Workbook book = WorkbookFactory.create(file);
        //get the first sheet
        Sheet sheet = book.getSheet("Sheet1");
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String [][] data = new String[noOfRows-1][noOfColumns   ];
        for (int i = 0; i < noOfRows-1; i++) {
                for (int j = 0; j < noOfColumns; j++) {
                    DataFormatter df = new DataFormatter();
                    data[i] [j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));

            }
            System.out.println();
            book.close();

        }
        for (String [] dataArr:data) {
            System.out.println(Arrays.toString(dataArr));



        }





}
}
