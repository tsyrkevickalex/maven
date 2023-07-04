package org.example.io.xlsx;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Example {

    public static void main(String[] args) {
//        try {
//            InputStream in = new FileInputStream("D:\\cars_table.xlsx");
//            Workbook wb = new XSSFWorkbook(in);
//            Sheet sheet = wb.getSheetAt(0);
//
//            System.out.println("Processing : " + sheet.getSheetName());
//
//            Iterator<Row> rowIterator = sheet.rowIterator();
//            while(rowIterator.hasNext()){
//                Row row = rowIterator.next();
//                System.out.println("Row #" + row.getRowNum());
//                Iterator<Cell> cellIter = row.cellIterator();
//                while(cellIter.hasNext()){
//                    Cell cell = cellIter.next();
//                    switch (cell.getCellType()){
//                        case Cell.CELL_TYPE_NUMERIC:
//                            System.out.println("Number : " + cell.getNumericCellValue());
//                            break;
//
//                        case Cell.CELL_TYPE_STRING:
//                            System.out.println("String : " + cell.getStringCellValue());
//                            break;
//                    }
//
//                }
//
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Car> cars = XlsxCarsUtil.loadCars("D:\\cars_table.xlsx");
        System.out.println(cars.size());

        cars.add(new Car(399, "Porsche", 21414, new Date()));
        cars.add(new Car(1231, "BMW", 435547, new Date()));
        cars.add(new Car(568, "Opel", 4567, new Date()));

        XlsxCarsUtil.writeCars("D:\\cars_table_" + new Date().getTime()+ ".xlsx", cars);

    }
}
