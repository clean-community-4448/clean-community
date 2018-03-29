package com.cleancommunity.posting;

import java.util.List;

public interface PostingDAO {

	List<Posting> getPostings();
	Posting getPosting(int postingId);
	boolean addPosting(Posting post);
	boolean updatePosting(Posting post);
	boolean deletePosting(Posting post);
}
