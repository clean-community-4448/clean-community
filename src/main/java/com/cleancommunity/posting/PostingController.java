package com.cleancommunity.posting;

import com.cleancommunity.misc.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostingController {
//    private com.cleancommunity.com.cleancommunity.posting.PostingDAO postingDAO = new com.cleancommunity.com.cleancommunity.posting.PostingDAO();
//    private com.cleancommunity.com.cleancommunity.posting.PostingFactory postingFactory = new com.cleancommunity.com.cleancommunity.posting.PostingFactory();
//    private com.cleancommunity.com.cleancommunity.user.UserFactory userFactory = new com.cleancommunity.com.cleancommunity.user.UserFactory();

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting(@RequestParam(value="request") String request) {
        // create new com.cleancommunity.posting
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//
//        if (!(com.cleancommunity.user instanceof com.cleancommunity.com.cleancommunity.user.Volunteer)) {
//            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
//        }
//
//        com.cleancommunity.com.cleancommunity.posting.com.cleancommunity.com.cleancommunity.posting com.cleancommunity.posting = postingFactory.createPostingByRequest(request);
//
//        if (!((com.cleancommunity.com.cleancommunity.user.Volunteer) com.cleancommunity.user.addPosting(com.cleancommunity.posting))) {
//            return com.cleancommunity.misc.Response.getServerErrorResponse();
//        }

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings(@RequestParam(value="request") String request) {
        // get all users
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//        return com.cleancommunity.user.getAllPostings();
        return new ArrayList<>(); // TEMP
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // get specific com.cleancommunity.posting
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//        return com.cleancommunity.user.getPosting(id);
        return new Posting(); // TEMP
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.DELETE)
    public Response deletePosting(@RequestParam(value="request") String request) {
        // delete specific com.cleancommunity.posting
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//
//        if (!(com.cleancommunity.user instanceof com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin)) {
//            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
//        }
//
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin admin = (com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin)com.cleancommunity.user;
//
//        com.cleancommunity.com.cleancommunity.posting.com.cleancommunity.com.cleancommunity.posting com.cleancommunity.posting = postingFactory.createPostingByRequest(request);
//
//        if (!(admin.removePosting(com.cleancommunity.posting))) {
//            com.cleancommunity.misc.Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/flag/{id}", method = RequestMethod.PUT)
    public Response flagPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // report a specific com.cleancommunity.posting
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//        com.cleancommunity.com.cleancommunity.posting.com.cleancommunity.com.cleancommunity.posting com.cleancommunity.posting = postingFactory.createPostingById(id);
//
//        if (!com.cleancommunity.user.flagPosting(com.cleancommunity.posting)) {
//            return com.cleancommunity.misc.Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // unreport a specific com.cleancommunity.posting
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user com.cleancommunity.user = userFactory.createUserByRequest(request);
//
//        if (!(com.cleancommunity.user instanceof com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin)) {
//            return com.cleancommunity.misc.Response.getBadPermissionsResponse();
//        }
//
//        com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin admin = (com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user.Admin)com.cleancommunity.user;
//
//        com.cleancommunity.com.cleancommunity.posting.com.cleancommunity.com.cleancommunity.posting com.cleancommunity.posting = postingFactory.createPostingById(id);
//
//        if (!admin.allowPosting(com.cleancommunity.posting)) {
//            return com.cleancommunity.misc.Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }
}
