package com.rs.core;

public class User {
    int id;
    String name;
    String email;
    String mobile;
    String gender;
    String exp;
    String pref_ind;
    String password;

    public int getId() {
        return id;
    }

    public User(String name, String email, String mobile, String gender, String exp, String pref_ind, String password,int id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.exp = exp;
        this.pref_ind = pref_ind;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return name + " " + email + " " + mobile + " " + gender + " " + exp + " " + " " + pref_ind + " " + password;
    }
}
