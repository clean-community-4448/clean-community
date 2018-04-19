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
    private UserFactory userFactory = new UserFactory();
    private PostingDAO postingDAO = new MysqlPostingDAO();

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting( @RequestBody Posting newPosting) {

        User user = userFactory.createUserByUsername(newPosting.getAssociatedUsername());

        if (!(user instanceof Volunteer)) {
            return Response.getBadPermissionsResponse();
        }

        if (!postingDAO.addPosting(newPosting)) {
            return Response.getServerErrorResponse();
        }

        // TODO update user's statistics here for projects posted
        // User.userDAO.updateUser(this) <-- old code from volunteer class

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings() {
        return postingDAO.getPostings();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@PathVariable int id) {
        return postingDAO.getPostingById(id);
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.DELETE)
    public Response deletePosting(@PathVariable int id, @RequestParam(value="username") String username) {
        User user = userFactory.createUserByUsername(username);

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
    public Response flagPosting(@PathVariable int id) {
        // report a specific posting
        Posting posting = postingDAO.getPostingById(id);

        posting.setFlagged(true);

        if (!postingDAO.updatePosting(posting)) {
            return Response.getServerErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@PathVariable int id, @RequestParam(value="username") String username) {
        User user = userFactory.createUserByUsername(username);

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
