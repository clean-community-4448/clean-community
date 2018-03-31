package com.cleancommunity.posting;

import com.cleancommunity.misc.MysqlDAO;

import java.util.*;

public class MysqlPostingDAO extends MysqlDAO implements PostingDAO {

	private static final String TABLE_NAME = "postings";

	private Posting createPostingFromHashMap(HashMap<String, Object> row) {

		int postingId = (int) row.get("id");
		String title = row.get("title").toString();
		String description = row.get("description").toString();
		String submitter = row.get("submitter").toString();
		String location = row.get("location").toString();
		Boolean accepted = (Boolean) row.get("accepted");

		return new Posting(postingId, title, description, submitter, location, accepted);
	}

	public List<Posting> getPostings() {

		List<Posting> postingsList = new ArrayList<>();
		String sql_query = String.format("SELECT * FROM %s", TABLE_NAME);
		List<HashMap<String, Object>> list =  this.getQuery(sql_query);

		for (HashMap<String, Object> row : list) {
			postingsList.add(createPostingFromHashMap(row));
		}

		return postingsList;
	}

	public Posting getPostingById(int postingId) {

		String sql_query = String.format("SELECT * FROM %s WHERE id = %d",
				TABLE_NAME, postingId);
		HashMap<String, Object> postingElements = this.getQuery(sql_query).get(0);

		return createPostingFromHashMap(postingElements);
	}

	public boolean addPosting(Posting post) {

		String sql_query = String.format(
				"INSERT INTO %s (title, description, submitter, location) values ('%s' '%s' '%s', '%s')",
				post.getTitle(), post.getDescription(), post.getAssociatedUsername(), post.getLocation());

		return this.updateQuery(sql_query);
	}

	public boolean updatePosting(Posting post) {
		// TODO: Write updatePosting
		return false;
	}


	public boolean deletePosting(Posting post) {

		String sql_query = String.format(
				"DELETE FROM %s WHERE id = %d",
				TABLE_NAME, post.getId());

		return this.updateQuery(sql_query);
	}

	public static void main(String[] args) {

		PostingDAO mysql = new MysqlPostingDAO();

		// Get postings
		List<Posting> postings = mysql.getPostings();
		for (Posting post : postings) {
			System.out.println(post);
		}

	}
}
