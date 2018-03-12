import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public Response newUser(@RequestParam(value="payload") String payload) {
        // create new user
        return new Response();
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public Response getAllUsers(@RequestParam(value="payload") String payload) {
        // get all users
        return new Response();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Response getUser(@RequestParam(value="payload") String payload) {
        // get specific user
        return new Response();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Response deleteUser(@RequestParam(value="payload") String payload) {
        // delete specific user
        return new Response();
    }
}
