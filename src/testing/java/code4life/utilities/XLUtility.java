//package code4life.utilities;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class XLUtility {
//
//    public FileInputStream fi;
//    public FileOutputStream fo;
//    public XSSFWorkbook workbook;
//    public XSSFSheet sheet;
//    public XSSFRow row;
//    public XSSFCell cell;
//    public CellStyle style;
//    String path;
//
//    public XLUtility(String path)
//    {
//        this.path=path;
//    }
//
//    public int getRowCount(String sheetName) throws IOException
//    {
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//        sheet=workbook.getSheet(sheetName);
//        int rowcount=sheet.getLastRowNum();
//        workbook.close();
//        fi.close();
//        return rowcount;
//    }
//
//
//    public int getCellCount(String sheetName,int rownum) throws IOException
//    {
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//        sheet=workbook.getSheet(sheetName);
//        row=sheet.getRow(rownum);
//        int cellcount=row.getLastCellNum();
//        workbook.close();
//        fi.close();
//        return cellcount;
//    }
//
//
//    public String getCellData(String sheetName,int rownum,int colnum) throws IOException
//    {
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//        sheet=workbook.getSheet(sheetName);
//        row=sheet.getRow(rownum);
//        cell=row.getCell(colnum);
//
//        DataFormatter formatter = new DataFormatter();
//        String data;
//        try{
//            data = formatter.formatCellValue(cell); //Returns the formatted value
//            // of a cell as a String regardless of the cell type.
//        }
//        catch(Exception e)
//        {
//            data="";
//        }
//        workbook.close();
//        fi.close();
//        return data;
//    }
//
//    public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
//    {
//        File xlfile=new File(path);
//        if(!xlfile.exists())    // If file not exists then create new file
//        {
//            workbook=new XSSFWorkbook();
//            fo=new FileOutputStream(path);
//            workbook.write(fo);
//        }
//
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//
//        if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
//            workbook.createSheet(sheetName);
//
//        sheet=workbook.getSheet(sheetName);
//
//        if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
//            sheet.createRow(rownum);
//        row=sheet.getRow(rownum);
//
//        cell=row.createCell(colnum);
//        cell.setCellValue(data);
//        fo=new FileOutputStream(path);
//        workbook.write(fo);
//        workbook.close();
//        fi.close();
//        fo.close();
//    }
//
//
//    public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
//    {
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//        sheet=workbook.getSheet(sheetName);
//
//        row=sheet.getRow(rownum);
//        cell=row.getCell(colnum);
//
//        style=workbook.createCellStyle();
//
//        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//        cell.setCellStyle(style);
//        workbook.write(fo);
//        workbook.close();
//        fi.close();
//        fo.close();
//    }
//
//
//    public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
//    {
//        fi=new FileInputStream(path);
//        workbook=new XSSFWorkbook(fi);
//        sheet=workbook.getSheet(sheetName);
//        row=sheet.getRow(rownum);
//        cell=row.getCell(colnum);
//
//        style=workbook.createCellStyle();
//
//        style.setFillForegroundColor(IndexedColors.RED.getIndex());
//        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//
//        cell.setCellStyle(style);
//        workbook.write(fo);
//        workbook.close();
//        fi.close();
//        fo.close();
//    }
//
//    public String [][] getDataArray() throws IOException {
//
//
//        String [][] data1 = new String[rowCount()][columnCount()];
//
//        for (int i = 0; i < rowCount(); i++) {
//            for (int j = 0; j < columnCount(); j++) {
//
//                String value = getCellData("Sheet1", i, j);
//                data1[i][j] = value;
//            }
//
//        }
//        return  data1;
//    }
//
//    public int rowCount(){
//
//        return sheet.getPhysicalNumberOfRows();
//    }
//
//    public int columnCount(){
//        return sheet.getRow(0).getLastCellNum();
//    }
//
//    public List<String > getColumnNames(){
//        List<String> columns = new ArrayList<>();
//        for (Cell cell: sheet.getRow(0)) {
//            columns.add(cell.toString());
//
//        }
//        return columns;
//    }
//
//    public List<Map<String, String>> getDataList(){
//        //get all columns
//        List<String > columns = getColumnNames();
//        //this will be returned
//        List<Map<String , String >> data = new ArrayList<>();
//
//        for (int i = 0; i < rowCount(); i++) {
//            //get each row
//            Row row = sheet.getRow(i);
//            //create map of the row using the column and value
//            //column map key, cell value --> map value
//            Map<String, String> rowMap = new HashMap<String, String>();
//            for (Cell cell: row) {
//                int columnIndex = cell.getColumnIndex();
//                rowMap.put(columns.get(columnIndex), cell.toString());
//
//            }
//            data.add(rowMap);
//        }
//        return data;
//    }
//}
