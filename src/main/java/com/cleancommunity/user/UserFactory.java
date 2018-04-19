package com.cleancommunity.user;

public class UserFactory {
    private UserDAO userDAO;

    public UserFactory() {
        this.userDAO = new MysqlUserDAO();
    }

    public User createUserByUsername(String username){
        return userDAO.getUserByUsername(username);

    }

    public static User createUser(String uname, String pass, String fname, String lname, int id, Boolean admin) {

        if (admin) {
           return new Admin(uname, pass, fname, lname, id);
        } else {
            return new Volunteer(uname, pass, fname, lname, id);
        }
    }

    private String extractUsernameFromRequest(String request) {
        // let's do some nasty string searching here instead of parsing json
        return "";
    }
}
