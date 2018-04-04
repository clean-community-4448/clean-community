package com.cleancommunity.posting;

public class PostingFactory
{
    private int numInstancesMade;
    private PostingDAO postingDAO;

    PostingFactory() {

        // TODO Query database to get number of postings instead
        this.numInstancesMade = 0;
        this.postingDAO = new MysqlPostingDAO();

    }

    public Posting createPostingByRequest(String request) {

        int postingId = extractPostingIdFromRequest(request);
        Posting posting = postingDAO.getPostingById(postingId);

        numInstancesMade++;

        return posting;
    }

    private int extractPostingIdFromRequest(String request) {
        // let's do some nasty string searching here instead of parsing json
        return 0;
    }

}




