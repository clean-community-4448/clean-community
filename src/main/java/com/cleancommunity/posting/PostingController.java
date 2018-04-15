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
    private PostingDAO postingDAO = new MysqlPostingDAO();

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting(@RequestParam(value="request") String request) {
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Volunteer)) {
            return Response.getBadPermissionsResponse();
        }

        Posting posting = postingFactory.createPostingByRequest(request);

        Volunteer volunteer = (Volunteer) user;

        if (!postingDAO.addPosting(posting)) {
            return Response.getServerErrorResponse();
        }

        // TODO update user's statistics here for projects posted
        // User.userDAO.updateUser(this) <-- old code from volunteer class

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings(@RequestParam(value="request") String request) {
        return postingDAO.getPostings();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        return postingDAO.getPostingById(id);
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.DELETE)
    public Response deletePosting(@PathVariable int id, @RequestParam(value="request") String request) {
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Admin)) {
            return Response.getBadPermissionsResponse();
        }

        Posting postingToDelete = postingDAO.getPostingById(id);

        if (!postingDAO.deletePosting(postingToDelete)) {
            Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/flag/{id}", method = RequestMethod.PUT)
    public Response flagPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // report a specific posting
        User user = userFactory.createUserByRequest(request);
        Posting posting = postingDAO.getPostingById(id);

        posting.setFlagged(true);

        if (!postingDAO.updatePosting(posting)) {
            return Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        User user = userFactory.createUserByRequest(request);

        if (!(user instanceof Admin)) {
            return Response.getBadPermissionsResponse();
        }

        Posting posting = postingDAO.getPostingById(id);
        posting.setFlagged(false);

        if (!postingDAO.updatePosting(posting)) {
            return Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }
}
