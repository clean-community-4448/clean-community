package com.cleancommunity.user;

import com.cleancommunity.misc.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    private com.cleancommunity.com.cleancommunity.user.UserDAO userDAO = new com.cleancommunity.com.cleancommunity.user.UserDAO();
//    private com.cleancommunity.com.cleancommunity.user.UserFactory userFactory = new com.cleancommunity.com.cleancommunity.user.UserFactory();

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public Response newUser(@RequestParam(value="request") String request) {
        // create new com.cleancommunity.user
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user newUser = userFactory.getNewUserByRequest(request);
//        if (!userDAO.addUser(newUser)) {
//            com.cleancommunity.misc.Response.getServerErrorResponse();
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
        // get specific com.cleancommunity.user
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.getUserByRequest(request);
//        return userDAO.getUser(com.cleancommunity.user.getUsername());
        return new Volunteer();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Response deleteUser(@RequestParam(value="request") String request) {
        // delete specific com.cleancommunity.user
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.getUserByRequest(request);
//
//        if (!userDAO.deleteUser(com.cleancommunity.user.getUsername())) {
//            com.cleancommunity.misc.Response.getServerErrorResponse();
//        }

        return Response.getSuccessResponse();
    }
}
