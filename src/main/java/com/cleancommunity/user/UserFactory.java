package com.cleancommunity.user;

public class UserFactory {
    private int numInstancesMade;
    private UserDAO userDAO;

    public UserFactory() {
        // TODO Query database to get number of postings instead
        this.numInstancesMade = 0;
        this.userDAO = new MysqlUserDAO();
    }

    public User createUserByRequest(String request){
        String username = extractUsernameFromRequest(request);
        User user = userDAO.getUserByUsername(username);

        numInstancesMade++;

        return user;
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
