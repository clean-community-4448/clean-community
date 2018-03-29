package com.cleancommunity.posting;

import com.cleancommunity.misc.MysqlDAO;

import java.util.*;

public class MysqlPostingDAO extends MysqlDAO implements PostingDAO {

	private static final String TABLE_NAME = "postings";

	public List<Posting> getPostings() {

		List<HashMap<String, Object>> postingsList;
		String sql_query = String.format("SELECT * FROM %s", TABLE_NAME);
		List<HashMap<String, Object>> list =  this.getQuery(sql_query);

		for (HashMap<String, Object> row : list) {
			// TODO: Create the actual postingsList here
		}

		return new ArrayList<>();
	}

	public Posting getPosting(int postingId) {

		String sql_query = String.format("SELECT * FROM %s WHERE id = %d",
				TABLE_NAME, postingId);
		HashMap<String, Object> postingElements = this.getQuery(sql_query).get(0);

		// TODO: Create the com.cleancommunity.posting here
		return new Posting();
	}

	public boolean addPosting(Posting post) {

		String sql_query = String.format(
				"INSERT INTO %s (title, description, submitter, location) values (%d \"%s\" \"%s\", %f, %f",
				post.getTitle(), post.getDescription(), post.getAssociatedUsername(), post.getLocation());

		return this.updateQuery(sql_query);
	}
}
