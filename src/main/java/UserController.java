import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    private UserDAO userDAO = new UserDAO();
//    private UserFactory userFactory = new UserFactory();

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public Response newUser(@RequestParam(value="request") String request) {
        // create new user
//        User newUser = userFactory.getNewUserByRequest(request);
//        if (!userDAO.addUser(newUser)) {
//            Response.getServerErrorResponse();
//        }

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public List<User> getAllUsers(@RequestParam(value="request") String request) {
        // get all users
//        return userDAO.getUsers();
        return new ArrayList<>();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@RequestParam(value="request") String request) {
        // get specific user
//        User user = userFactory.getUserByRequest(request);
//        return userDAO.getUser(user.getUsername());
        return new Volunteer();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Response deleteUser(@RequestParam(value="request") String request) {
        // delete specific user
//        User user = userFactory.getUserByRequest(request);
//
//        if (!userDAO.deleteUser(user.getUsername())) {
//            Response.getServerErrorResponse();
//        }

        return Response.getSuccessResponse();
    }
}
