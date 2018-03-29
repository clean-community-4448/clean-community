package com.cleancommunity.user;

import com.cleancommunity.posting.Posting;

import java.util.*;
public class Admin extends User {
    protected int id;

    public Admin(){
        // super("", "");
    }
    public Admin(String uname, String pass, String fname, String lname, int id){
        setUsername(uname);
        setPassword(pass);
        setFirstName(fname);
        setLastName(lname);
        setId(id);
    }
    public boolean removePosting(Posting post){
        UserDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "DELETE FROM postings WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        return true;
    }
    public boolean allowPosting(Posting post){
        UserDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "UPDATE postings SET flagged = '0' WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        return true;
    }
    public boolean removeUser(User user){
        UserDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        // String query = "DELETE FROM users WHERE username = " + post.getUsername() + ";";
        // list = mysql.getQuery(query);
        return true;
    }
}
