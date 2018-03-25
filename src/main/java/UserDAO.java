import java.util.*;

public interface UserDAO {
	List<User> getUsers();
	User getUserByUsername(String username);
	Boolean addUser(User user);
	Boolean deleteUser(User user);
	Boolean updateUser(User user);
}
