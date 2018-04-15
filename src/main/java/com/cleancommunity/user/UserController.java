package com.cleancommunity.user;

import com.cleancommunity.misc.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserDAO userDAO = new MysqlUserDAO();
    private UserFactory userFactory = new UserFactory();

//    @RequestMapping(value = "/users/", method = RequestMethod.POST)
//    public Response newUser(@RequestParam(value="request") String request) {
//        // create new user
//        User newUser = userFactory.createUserByRequest(request);
//        if (!userDAO.addUser(newUser)) {
//            com.cleancommunity.misc.Response.getServerErrorResponse();
//        }
//
//        return Response.getSuccessResponse();
//    }
//
//    @RequestMapping(value = "/users/", method = RequestMethod.GET)
//    public List<User> getAllUsers(@RequestParam(value="request") String request) {
//        // get all users
//        return userDAO.getUsers();
//    }
//
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
//    public User getUser(@RequestParam(value="request") String request) {
//        // get specific user
//        return userFactory.createUserByRequest(request);
//    }
//
//    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
//    public Response deleteUser(@RequestParam(value="request") String request) {
//        // delete user
//        User user = userFactory.createUserByRequest(request);
//
//        if (!userDAO.deleteUser(user)) {
//            com.cleancommunity.misc.Response.getServerErrorResponse();
//        }
//
//        return Response.getSuccessResponse();
//    }
}
