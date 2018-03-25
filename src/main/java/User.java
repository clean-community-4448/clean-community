import java.sql.SQLException;
import java.util.*;
public abstract class User {

    public int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public List<Posting> getAllPostings(){
        MysqlDAO mysql = new MysqlUserDAO();
        List<Posting> posts = new ArrayList<Posting>();
        List<HashMap<String, Object>> list;
        list = mysql.getQuery("SELECT * FROM postings;");
        for (HashMap<String, Object> row: list){
            Posting posting = new Posting();
            // Admin u1= new Admin();

            //Currently creating it based on posting in class diagram
            posting.setId((int)row.get("id"));
            posting.setTitle(row.get("title").toString());
            posting.setDescription(row.get("description").toString());
            // posting.setAssociated(row.get("associated").toString());
            posting.setAccepted((Boolean)row.get("accepted"));
            posting.setCompleted((Boolean)row.get("completed"));
            posting.setLocation(row.get("location").toString());
            posts.add(posting);

        }
        return posts;
    }
    public boolean flagPosting(Posting posting){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        list = mysql.getQuery("UPDATE postings SET flagged = '1' WHERE id = " + posting.getId() + ";");
        return true;
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
