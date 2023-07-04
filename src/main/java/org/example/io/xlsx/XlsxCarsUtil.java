package org.example.io.xlsx;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class XlsxCarsUtil {
    public static List<Car> loadCars(String filePath) {
        List<Car> cars = new ArrayList<>();
        try ( InputStream in = new FileInputStream(filePath)){
            Workbook wb = null;
            if (filePath.endsWith(".xls")) {
                wb = new HSSFWorkbook(in);
            } else if (filePath.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(in);
            } else {
                throw new IllegalArgumentException("Not acceptable format. " + filePath
                        + ". Expected MS Excel format");
            }

            for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
                Sheet sheet = wb.getSheetAt(sheetNum);
                System.out.println("Processing :" + sheet.getSheetName());

                Iterator<Row> rowsIter = sheet.rowIterator();
                while (rowsIter.hasNext()) {
                    Row row = rowsIter.next();
                    int rowNum = row.getRowNum();
                    System.out.println("Row #" + rowNum);
                    if(rowNum == 0)//skip first headers row
                        continue;
                    //data
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String model = row.getCell(1).getStringCellValue();
                    double price = row.getCell(2).getNumericCellValue();
                    Date date = row.getCell(3).getDateCellValue();

                    Car car = new Car(id, model, price, date);
                    System.out.println(car);
                    cars.add(car);
                }
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return cars;
    }


    public static void writeCars(String filePath, List<Car> cars){

        Workbook wb = null;
        if (filePath.endsWith(".xls")) {
            wb = new HSSFWorkbook();
        } else if (filePath.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Not acceptable format. " + filePath
                    + ". Expected MS Excel format");
        }

        Sheet sheet = wb.createSheet("Cars");
        int rownum = 0;
        Row headersRow = sheet.createRow(rownum);
        headersRow.createCell(0).setCellValue("ID");
        headersRow.createCell(1).setCellValue("MODEL");
        headersRow.createCell(2).setCellValue("PRICE");
        headersRow.createCell(3).setCellValue("DATE");

        for (Car car: cars) {
            rownum++;
            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(car.getId());
            row.createCell(1).setCellValue(car.getModel());
            row.createCell(2).setCellValue(car.getPrice());
            row.createCell(3).setCellValue(car.getDate());

        }

        try (OutputStream out = new FileOutputStream(filePath)){
            wb.write(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
