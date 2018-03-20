import java.util.*;
public class Volunteer extends User{
    private int volunteerId;
    //Additional attributes here, to keep track of user statistics
    private int projectsCompleted;
    private int projectsInProgress;
    private int projectsPosted;
    public Volunteer(){
        this.username = "";
        this.password = "";
        volunteerId = -1;
        projectsCompleted = 0;
        projectsInProgress = 0;
        projectsPosted = 0;
    }
    public Volunteer(String user, String pass, int id){
        this.username = user;
        this.password = pass;
        volunteerId = id;
        projectsCompleted = 0;
        projectsInProgress = 0;
        projectsPosted = 0;
    }
    public boolean addPosting(Posting post){
        List<String> postingInfo = new ArrayList<String>();
        postingInfo.add(post.getId().toString());
        postingInfo.add(post.getTitle().toString());
        postingInfo.add(post.getDescription().toString());
        postingInfo.add(post.getAssociatedUsername().toString());
        postingInfo.add(post.getAccepted().toString());
        postingInfo.add(post.getCompleted().toString());
        postingInfo.add(post.getLocation().toString());

        String query = "INSERT INTO postings (id, title, description, associatedUsername, accepted, completed, location) VALUES (";
        for (String info : postingInfo){
            query = query + info + ",";
        }
        query = query.substring(0, query.length()-1) + ");";

        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        list = mysql.getQuery(query);
        projectsPosted++;
        return true;
    }
    public boolean acceptPosting(Posting post){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "UPDATE postings SET accepted = '1' WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        projectsInProgress++;
        return true;
    }
    public boolean completePosting(Posting post){
        MysqlDAO mysql = new MysqlUserDAO();
        List<HashMap<String, Object>> list;
        String query = "UPDATE postings SET completed = '1' WHERE id = " + post.getId() + ";";
        list = mysql.getQuery(query);
        projectsInProgress--;
        projectsCompleted++;
        return true;
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
    public int getVolunteerId(){
        return volunteerId;
    }
    public void setVolunteerId (int id){
        volunteerId = id;
    }
}
