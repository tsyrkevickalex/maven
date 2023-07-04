package org.example.io.xlsx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.swing.XMLCurrencyParser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency{
    private String numCode;
    private String charCode;
    private int scale;
    private String name;
    private double rate;
    private Date date;


    public static void writeCurrency(String filePath, List<Currency> currencies) {


        Workbook wb = null;
        if (filePath.endsWith(".xls")) {
            wb = new HSSFWorkbook();
        } else if (filePath.endsWith(".xlsx")) {
            wb = new XSSFWorkbook();
        } else {
            throw new IllegalArgumentException("Not acceptable format. " + filePath
                    + ". Expected MS Excel format");
        }

        Sheet sheet = wb.createSheet("Currencies");
        int rownum = 1;
        Row headrsRow2 = sheet.createRow(0);
        Row headersRow = sheet.createRow(rownum);

        headrsRow2.createCell(0).setCellValue("Currencies");
        headersRow.createCell(0).setCellValue("Name");
        headersRow.createCell(1).setCellValue("Char Code");
        headersRow.createCell(2).setCellValue("Rate 1");
        headersRow.createCell(3).setCellValue("Rate 2");



        for (Currency cur: currencies) {
            rownum++;
            Row row = sheet.createRow(rownum);
            row.createCell(0).setCellValue(cur.getName());
            row.createCell(1).setCellValue(cur.getCharCode());
            row.createCell(2).setCellValue(cur.getRate());
            row.createCell(3).setCellValue(cur.getRate()*0.05);

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
