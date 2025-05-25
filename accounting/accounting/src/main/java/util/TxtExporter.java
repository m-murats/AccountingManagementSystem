/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Transaction;

public class TxtExporter implements ReportExporter<Transaction> {

    private String user;
    private String category;
    private String month;
    private String year;

    private double incomeTL, incomeUSD, incomeEUR;
    private double expenseTL, expenseUSD, expenseEUR;
    private double netBalance;

    public TxtExporter(String user, String category, String month, String year,
            double incomeTL, double incomeUSD, double incomeEUR,
            double expenseTL, double expenseUSD, double expenseEUR ,double netBalance) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("===== Monthly Financial Report =====\n");

            if (!user.equals("All")) {
                writer.write("User: " + user + "\n");
            } else {
                writer.write("User Filter: All users\n");
            }

            if (!category.isEmpty()) {
                writer.write("Category Filter: " + category + "\n");
            }

            writer.write("Month: " + month + "\n");
            writer.write("Year: " + year + "\n\n");

            writer.write("Total Income:\n");
            writer.write(incomeTL + " TL\n");
            writer.write(incomeUSD + " USD\n");
            writer.write(incomeEUR + " EUR\n\n");

            writer.write("Total Expense:\n");
            writer.write(expenseTL + " TL\n");
            writer.write(expenseUSD + " USD\n");
            writer.write(expenseEUR + " EUR\n\n");

            double netTL = incomeTL - expenseTL;
            double netUSD = incomeUSD - expenseUSD;
            double netEUR = incomeEUR - expenseEUR;

            writer.write("Net Balance:\n");
            writer.write(" - " + netTL + " TL\n");
            writer.write(" - " + netUSD + " USD\n");
            writer.write(" - " + netEUR + " EUR\n\n");
            
            writer.write("Net Balance (in TL): " + String.format("%.2f", netBalance) + "\n");

            writer.write("====================================\n");

        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "TXT export failed.");
        }
    }
}
