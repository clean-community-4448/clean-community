import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class UserFactoryTest {

	private final String username = "johndoe";
	private final String password = "password";
	private final String fname = "john";
	private final String lname = "doe";
	private final int id = 99;
	private final Boolean is_admin = true;


	@Test
	public void createUserByRequest() {
	}

	@Test
	public void createUser() {
		User admin = UserFactory.createUser(username, password, fname, lname, id, true);
		User volunteer = UserFactory.createUser(username, password, fname, lname, id, false);

		System.out.println(admin instanceof Admin);
		assertThat("admin should be instance of Admin", admin, instanceOf(Admin.class));
		assertThat("volunteer should be instance of volunteer", volunteer, instanceOf(Volunteer.class));
	}
}