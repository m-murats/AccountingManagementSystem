/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class AdminUser extends User {
    public AdminUser(String username) {
        super(username, "Admin");
    }

    @Override
    public String getWelcomeMessage() {
        return "👑 Welcome to Admin Panel - " + username + "!";
    }
}