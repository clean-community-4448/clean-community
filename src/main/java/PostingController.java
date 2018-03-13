import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostingController {

    @RequestMapping(value = "/postings/", method = RequestMethod.POST)
    public Response newPosting(@RequestParam(value="payload") String payload) {
        // create new posting
        return new Response();
    }

    @RequestMapping(value = "/postings/", method = RequestMethod.GET)
    public List<Posting> getAllPostings(@RequestParam(value="payload") String payload) {
        // get all users
        return new ArrayList<Posting>();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.GET)
    public Posting getPosting(@RequestParam(value="payload") String payload) {
        // get specific posting
        return new Posting();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.PUT)
    public Response updatePosting(@RequestParam(value="payload") String payload) {
        // update specific posting
        return new Response();
    }

    @RequestMapping(value = "/postings/{id}", method = RequestMethod.PUT)
    public Response deletePosting(@RequestParam(value="payload") String payload) {
        // delete specific posting
        return new Response();
    }

    @RequestMapping(value = "/report/{id}", method = RequestMethod.PUT)
    public Response reportPosting(@RequestParam(value="payload") String payload) {
        // report a specific posting
        return new Response();
    }

    @RequestMapping(value = "/unreport/{id}", method = RequestMethod.PUT)
    public Response unreportPosting(@RequestParam(value="payload") String payload) {
        // unreport a specific posting
        return new Response();
    }
}
