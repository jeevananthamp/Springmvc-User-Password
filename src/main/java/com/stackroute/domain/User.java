package com.stackroute.domain;

public class User {
    private String Name;
    private String Password;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public Boolean checkPassword(){
        return Password.equals("Password");
    }
}
