package com.cleancommunity.posting;

public class PostingFactory
{
    private int numInstancesMade;

    PostingFactory() {

        // Query database to get number of postings
        this.numInstancesMade = 0;

    }

    public Posting createPostingByRequest(String request) {

        numInstancesMade++;
        Posting posting = new Posting(request, numInstancesMade);

        return posting;
    }

    public Posting createPostingById(int id) {

        Posting posting = new Posting(id);
        numInstancesMade++;

        return new Posting(id);
    }

    // Why is this private?
    private Posting getPostingFromDatabase(int id) {

        // Querying from database will be next milestone

        return null;
    }

}




