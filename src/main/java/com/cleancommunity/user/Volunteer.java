package com.cleancommunity.user;

import com.cleancommunity.posting.Posting;
import com.cleancommunity.misc.MysqlDAO;

import java.util.*;
public class Volunteer extends User{

    private int volunteerId;
    //Additional attributes here, to keep track of user statistics
    private int projectsCompleted;
    private int projectsInProgress;
    private int projectsPosted;
    protected int id;

    public Volunteer(){
        setUsername("");
        setPassword("");
        volunteerId = -1;
        projectsCompleted = 0;
        projectsInProgress = 0;
        projectsPosted = 0;
    }
    public Volunteer(String user, String pass, String fname, String lname, int id){
        setUsername(user);
        setPassword(pass);
        setFirstName(fname);
        setLastName(lname);
        setId(id);
        projectsCompleted = 0;
        projectsInProgress = 0;
        projectsPosted = 0;
    }
    public boolean addPosting(Posting post){
        if (User.postingDAO.addPosting(post)) {
            projectsPosted++;
            // TODO: update using UserDAO
            return true;
        }
        return false;
    }
    public boolean acceptPosting(Posting post){
        post.setAccepted(true);
        if (User.postingDAO.updatePosting(post)) {
            projectsInProgress++;
            // TODO: update using UserDAO
            return true;
        }
        return false;
    }
    public boolean completePosting(Posting post){
        post.setCompleted(true);
        if (User.postingDAO.updatePosting(post)) {
            projectsInProgress--;
            projectsCompleted++;
            // TODO: update using UserDAO
            return true;
        }

        return false;
    }
    public List<Integer> getVolunteerStatistics(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(projectsInProgress);
        list.add(projectsCompleted);
        list.add(projectsPosted);
        return list;
    }
    public List<Volunteer> getOverallStatistics(){
        List<Volunteer> list = new ArrayList<Volunteer>();
        return list;
    }
}
