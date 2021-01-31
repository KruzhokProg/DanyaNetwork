package com.example.danyanetwork.Model;

public class RegInfo {
    private String Email;
    private String Password;
    private int RoleId;
    private String PhoneNumber;
    private String CompanyName;

    public RegInfo(String email, String password, int roleId, String phoneNumber, String companyName) {
        Email = email;
        Password = password;
        RoleId = roleId;
        PhoneNumber = phoneNumber;
        CompanyName = companyName;
    }

    public RegInfo() {
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

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
}
