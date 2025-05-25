/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class AccountantUser extends User {
    public AccountantUser(String username) {
        super(username, "Accountant");
    }

    @Override
    public String getWelcomeMessage() {
        return "📊 Welcome dear Accountant -  " + username + "!";
    }
}