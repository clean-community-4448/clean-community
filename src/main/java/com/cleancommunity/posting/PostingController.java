package com.cleancommunity.posting;

import com.cleancommunity.misc.Response;
import com.cleancommunity.user.Admin;
import com.cleancommunity.user.User;
import com.cleancommunity.user.UserFactory;
import com.cleancommunity.user.Volunteer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostingController {
    private PostingFactory postingFactory = new PostingFactory();
    private UserFactory userFactory = new UserFactory();

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting(@RequestParam(value="request") String request) {
        // create new posting
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Volunteer)) {
            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
        }

        Posting posting = postingFactory.createPostingByRequest(request);

        Volunteer volunteer = (Volunteer) user;

        if (!volunteer.addPosting(posting)) {
            return com.cleancommunity.misc.Response.getServerErrorResponse();
        }

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings(@RequestParam(value="request") String request) {
        // get all users
        User user = userFactory.createUserByRequest(request);
        return user.getAllPostings();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // get specific posting
        User user = userFactory.createUserByRequest(request);
        return user.getPosting(id);
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.DELETE)
    public Response deletePosting(@RequestParam(value="request") String request) {
        // delete specific posting
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Admin)) {
            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
        }

        Admin admin = (Admin) user;

        Posting posting = postingFactory.createPostingByRequest(request);

        if (!(admin.removePosting(posting))) {
            com.cleancommunity.misc.Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/flag/{id}", method = RequestMethod.PUT)
    public Response flagPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // report a specific posting
        User user = userFactory.createUserByRequest(request);
        Posting posting = user.getPosting(id);

        if (user.flagPosting(posting)) {
            return com.cleancommunity.misc.Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // unreport a specific posting
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Admin)) {
            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
        }

        Admin admin = (Admin) user;

        Posting posting = admin.getPosting(id);

        if (!admin.allowPosting(posting)) {
            return com.cleancommunity.misc.Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }
}
