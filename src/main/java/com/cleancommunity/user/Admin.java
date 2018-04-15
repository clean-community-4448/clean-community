package com.cleancommunity.user;

public class Admin extends User {
    protected int id;

    public Admin(String uname, String pass, String fname, String lname, int id){
        setUsername(uname);
        setPassword(pass);
        setFirstName(fname);
        setLastName(lname);
        setId(id);
    }
}
