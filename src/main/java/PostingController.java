import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostingController {
//    private PostingDAO postingDAO = new PostingDAO();
//    private PostingFactory postingFactory = new PostingFactory();
//    private UserFactory userFactory = new UserFactory();

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting(@RequestParam(value="request") String request) {
        // create new posting
//        User user = userFactory.createUserByRequest(request);
//
//        if (!(user instanceof Volunteer)) {
//            return Response.getBadPermissionsResponse();
//        }
//
//        Posting posting = postingFactory.createPostingByRequest(request);
//
//        if (!((Volunteer) user.addPosting(posting))) {
//            return Response.getServerErrorResponse();
//        }

        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings(@RequestParam(value="request") String request) {
        // get all users
//        User user = userFactory.createUserByRequest(request);
//        return user.getAllPostings();
        return new ArrayList<>(); // TEMP
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // get specific posting
//        User user = userFactory.createUserByRequest(request);
//        return user.getPosting(id);
        return new Posting(); // TEMP
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.DELETE)
    public Response deletePosting(@RequestParam(value="request") String request) {
        // delete specific posting
//        User user = userFactory.createUserByRequest(request);
//
//        if (!(user instanceof Admin)) {
//            return Response.getBadPermissionsResponse();
//        }
//
//        Admin admin = (Admin)user;
//
//        Posting posting = postingFactory.createPostingByRequest(request);
//
//        if (!(admin.removePosting(posting))) {
//            Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/flag/{id}", method = RequestMethod.PUT)
    public Response flagPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // report a specific posting
//        User user = userFactory.createUserByRequest(request);
//        Posting posting = postingFactory.createPostingById(id);
//
//        if (!user.flagPosting(posting)) {
//            return Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@PathVariable int id, @RequestParam(value="request") String request) {
        // unreport a specific posting
//        User user = userFactory.createUserByRequest(request);
//
//        if (!(user instanceof Admin)) {
//            return Response.getBadPermissionsResponse();
//        }
//
//        Admin admin = (Admin)user;
//
//        Posting posting = postingFactory.createPostingById(id);
//
//        if (!admin.allowPosting(posting)) {
//            return Response.getServerErrorResponse();
//        }
        return Response.getSuccessResponse();
    }
}
