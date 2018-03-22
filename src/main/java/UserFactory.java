public class UserFactory {
    private int numInstancesMade;
    public User createUserByRequest(String request){
        return (1 > 0) ? new Volunteer() : new Admin();
    }
    public User createUserByUsername(String name){
        return new Volunteer();
    }
    public User getUserFromDatabase(String userName){
        return new Volunteer();
    }
}
