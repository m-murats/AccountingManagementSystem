/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.Transaction;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class ExcelExporter implements ReportExporter<Transaction> {

    private String user;
    private String category;
    private String month;
    private String year;

    private double incomeTL, incomeUSD, incomeEUR;
    private double expenseTL, expenseUSD, expenseEUR;
    private double netBalance;

    public ExcelExporter(String user, String category, String month, String year,
            double incomeTL, double incomeUSD, double incomeEUR,
            double expenseTL, double expenseUSD, double expenseEUR , double netBalance) {
        this.user = user;
        this.category = category;
        this.month = month;
        this.year = year;
        this.incomeTL = incomeTL;
        this.incomeUSD = incomeUSD;
        this.incomeEUR = incomeEUR;
        this.expenseTL = expenseTL;
        this.expenseUSD = expenseUSD;
        this.expenseEUR = expenseEUR;
        this.netBalance = netBalance;
    }

    @Override
    public void export(List<Transaction> data, File file) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Financial Report");

            int rowIndex = 0;

            rowIndex ++;

            sheet.createRow(rowIndex++).createCell(0).setCellValue("===== Monthly Financial Report =====");
            sheet.createRow(rowIndex++).createCell(0).setCellValue("Month/Year: " + month + "/" + year);
            sheet.createRow(rowIndex++).createCell(0).setCellValue("Category: " + category);
            sheet.createRow(rowIndex++).createCell(0).setCellValue("User: " + user);
            
            
            rowIndex++;

            sheet.createRow(rowIndex++).createCell(0).setCellValue("Total Income:");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + incomeTL + " TL");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + incomeUSD + " USD");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + incomeEUR + " EUR");
            rowIndex++;

            sheet.createRow(rowIndex++).createCell(0).setCellValue("Total Expense:");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + expenseTL + " TL");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + expenseUSD + " USD");
            sheet.createRow(rowIndex++).createCell(0).setCellValue(" - " + expenseEUR + " EUR");
            rowIndex++;
            sheet.createRow(rowIndex++).createCell(0).setCellValue("Net Balance (in TL): " + String.format("%.2f", netBalance));
            sheet.createRow(rowIndex++).createCell(0).setCellValue("====================================");
            

            
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Excel export failed.");
        }
    }
}
