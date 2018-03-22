import java.util.*;
public class Admin extends User{
    private int adminId;
    public Admin(){
        super("", "");
        adminId = -1;
    }
    public Admin(String user, String pass, int id){
        this.username = user;
        this.password = pass;
        adminId = id;
    }
    public boolean removePosting(Posting post){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "DELETE FROM postings WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        return true;
    }
    public boolean allowPosting(Posting post){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "UPDATE postings SET flagged = '0' WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        return true;
    }
    public boolean removeUser(User user){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        // String query = "DELETE FROM users WHERE username = " + post.getUsername() + ";";
        // list = mysql.getQuery(query);
        return true;
    }
    public int getAdminId(){
        return adminId;
    }
    public void setAdminId(int id){
        adminId = id;
    }
}
