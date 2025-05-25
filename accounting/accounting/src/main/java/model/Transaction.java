/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Transaction {

    private String date;
    private String category;
    private double amount;
    private String currency;
    private String description;

    public Transaction(String date, String category, double amount, String currency, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " " + currency + " | " + description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }
}
