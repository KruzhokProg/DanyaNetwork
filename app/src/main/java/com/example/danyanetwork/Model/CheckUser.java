package com.example.danyanetwork.Model;

public class CheckUser {
    String Email;
    String Password;

    public CheckUser(String email, String password) {
        Email = email;
        Password = password;
    }

    public CheckUser() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
