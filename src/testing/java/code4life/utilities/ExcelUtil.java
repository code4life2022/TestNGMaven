package code4life.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {

    private Sheet workSheet;
    private Workbook workBook;
    private  String path;

    public ExcelUtil(String path, String sheetName) {
        this.path = path;

        try {
            //open the Excel File
            FileInputStream excelFile = new FileInputStream(path);
            //Access the required test data sheet
            workBook = WorkbookFactory.create(excelFile);
            workSheet = workBook.getSheet(sheetName );
            //check if the sheet is null or not. Null means sheet name was wrong.
            Assert.assertNotNull(workSheet, "Sheet: \"" +sheetName+"\" does not exist\n" );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int rowNum, int colNum){
        Cell cell;
        cell = workSheet.getRow(rowNum).getCell(colNum);
        String cellData = cell.toString();

        return  cellData;

    }
    public int rowCount(){

        return workSheet.getPhysicalNumberOfRows();
    }

    public int columnCount(){

        return workSheet.getRow(0).getLastCellNum();
    }

    public List<String > getColumnNames(){
        List<String> columns = new ArrayList<>();
        for (Cell cell: workSheet.getRow(0)) {
            columns.add(cell.toString());

        }
        return columns;
    }

    public List<Map<String, String>> getDataList(){
        //get all columns
        List<String > columns = getColumnNames();
        //this will be returned
        List<Map<String , String >> data = new ArrayList<>();

        for (int i = 1; i < rowCount(); i++) {
            //get each row
            Row eachRow = workSheet.getRow(i);
            //create map of the row using the column and value
            //column map key, cell value --> map value
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell: eachRow) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());

            }
            data.add(rowMap);
        }
        return data;
    }




    public String [][] getDataArray() throws IOException {


//        String [][] data = new String[rowCount()][columnCount()];
//
//        for (int i = 0; i < rowCount(); i++) {
//            for (int j = 0; j < columnCount(); j++) {
//
//                String value = getCellData( i, j);
//                data[i][j] = value;
//            }
//
//        }


        int noOfRows = workSheet.getPhysicalNumberOfRows();
        int noOfColumns = workSheet.getRow(0).getLastCellNum();

        String [][] data = new String[noOfRows-1][noOfColumns   ];
        for (int i = 0; i < noOfRows-1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i] [j] = df.formatCellValue(workSheet.getRow(i+1).getCell(j));

            }
            System.out.println();



        }

        return  data;
    }

    public void setCellData(String value, int rowNum, int colNum){
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell==null){
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOutput = new FileOutputStream(path);
            workBook.write(fileOutput);
            fileOutput.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setCellData(String value, String columnName, int row){
        int column = getColumnNames().indexOf(columnName);
        setCellData(value, row, column);
    }





    public String [][] return2DArray() throws IOException {
        int noOfRows = workSheet.getPhysicalNumberOfRows();
        int noOfColumns = workSheet.getRow(0).getLastCellNum();

        String [][] data = new String[noOfRows-1][noOfColumns   ];
        for (int i = 0; i < noOfRows-1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i] [j] = df.formatCellValue(workSheet.getRow(i+1).getCell(j));

            }
            System.out.println();
            workBook.close();

        }
        for (String [] dataArr:data) {
            System.out.println(Arrays.toString(dataArr));



        }
        return  data;


    }

}
