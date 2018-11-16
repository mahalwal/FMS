package me.manishmahalwal.android.fms2;

public class User {

    public String email, password, phoneNumber, rollNo, gender, name;
    public User(String name, String email, String pass, String number, String rollNo, String gender) {
        this.name = name;
        this.email = email;
        this.password = pass;
        this.phoneNumber = number;
        this.rollNo = rollNo;
        this.gender = gender;
    }
}