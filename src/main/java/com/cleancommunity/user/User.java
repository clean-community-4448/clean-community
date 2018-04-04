package com.cleancommunity.user;

import com.cleancommunity.posting.MysqlPostingDAO;
import com.cleancommunity.posting.Posting;
import com.cleancommunity.misc.MysqlDAO;
import com.cleancommunity.posting.PostingDAO;

import java.util.*;
public abstract class User {

    public static PostingDAO postingDAO = new MysqlPostingDAO();

    public int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public List<Posting> getAllPostings(){
        return User.postingDAO.getPostings();
    }
    public boolean flagPosting(Posting posting){
        posting.setFlagged(true);
        return User.postingDAO.updatePosting(posting);
    }

    public Posting getPosting(int postingId) {
        return User.postingDAO.getPostingById(postingId);
    }

    public void setUsername(String user){
        username = user;
    }
    public void setPassword(String pass){
        password = pass;
    }
    public void setFirstName(String fname) {
        firstName = fname;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lname) {
        lastName = lname;
    }
    public String getLastName() {
        return lastName;
    }
    public void setId(int id) {
        userId = id;
    }
    public int getId() {
        return userId;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}
