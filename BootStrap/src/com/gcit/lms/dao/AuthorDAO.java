package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;

@SuppressWarnings("unchecked")
public class AuthorDAO extends BaseDAO {
	
	public AuthorDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void createAuthor(Author author) throws ClassNotFoundException,
			SQLException {
		save("insert into tbl_author (authorName) values(?)",
				new Object[] { author.getAuthorName() });
	}

	public void updateAuthor(Author author) throws ClassNotFoundException,
			SQLException {
		save("update tbl_author set authorName = ? where authorId = ?",
				new Object[] { author.getAuthorName(), author.getAuthorId() });
	}

	public void deleteAuthor(Author author) throws ClassNotFoundException,
			SQLException {
		System.out.println("adao"+author.getAuthorId());
		save("delete from tbl_author where authorId=?",
				new Object[] { author.getAuthorId() });
	}

	public List<Author> getAllAuthors() throws ClassNotFoundException,
			SQLException {
		return readFirstLevel("select * from tbl_author", null);
	}

	
	public Author getAuthorById(Author author) throws ClassNotFoundException,
			SQLException {
		List<Author> authors = new ArrayList<Author>();
		authors = readFirstLevel("select * from tbl_author where authorId = ?",
				new Object[] { author.getAuthorId() });

		if (authors != null && authors.size() > 0) {
			return  authors.get(0);
		}
		return null;
	}

	public Author getAuthorByName(Author author) throws ClassNotFoundException,
			SQLException {
		List<Author> authors = new ArrayList<Author>();
		authors = readAll("select * from tbl_author where authorName = ?",
				new Object[] { author.getAuthorName() });

		if (authors != null && authors.size() > 0) {
			return authors.get(0);
		}
		return null;
	}
	
	public List<Author> getAuthorByName(String search) throws ClassNotFoundException, SQLException {
		search = "%"+search+"%";
		
		return readFirstLevel("select * from tbl_author where authorName like ?", new Object[] {search});
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Author> authors = new ArrayList<Author>();

		try {
			while (rs.next()) {
				Author a = new Author();
				a.setAuthorId(rs.getInt("authorId"));
				a.setAuthorName(rs.getString("authorName"));

				authors.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
	}
	
	public List extractDataFirstLevel(ResultSet rs) {
		List<Author> authors = new ArrayList<Author>();

		try {
			while (rs.next()) {
				Author a = new Author();
				a.setAuthorId(rs.getInt("authorId"));
				a.setAuthorName(rs.getString("authorName"));
				authors.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
	}

	
}
