public class UserFactory {
    private int numInstancesMade;   // Why tho

    public static User createUserByRequest(String request){
        return (1 > 0) ? new Volunteer() : new Admin();
    }

    public static User createUser(String uname, String pass, String fname, String lname, int id, Boolean admin) {

        if (admin) {
           return new Admin(uname, pass, fname, lname, id);
        } else {
            return new Volunteer(uname, pass, fname, lname, id);
        }
    }
}
