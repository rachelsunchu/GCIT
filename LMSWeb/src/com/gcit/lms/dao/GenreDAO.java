package com.gcit.lms.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;

@SuppressWarnings("unchecked")
public class GenreDAO extends BaseDAO{
	
	public GenreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void createGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("insert into tbl_genre (genre_name) values(?)", new Object[] { genre.getGenre_Name()});
	}

	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("update tbl_genre set genre_Name = ?",
				new Object[] { genre.getGenre_Name()});
	}

	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("delete from tbl_genre where genre_Id=?", new Object[] { genre.getGenre_Id() });
	}

	public List<Genre> getAllGenre() throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_genre", null);
	}

	public Genre getGenreByGenreId(Genre genre) throws ClassNotFoundException, SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		genres = readAll("select * from tbl_genre where genre_Id = ?", new Object[] { genre.getGenre_Id() });

		if (genres != null && genres.size() > 0) {
			return genres.get(0);
		}
		return null;
	}

	public Genre getGenreByGenre(Genre genre) throws ClassNotFoundException, SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		genres = readAll("select * from tbl_genre where genre_Name = ?", new Object[] { genre.getGenre_Name() });

		if (genres != null && genres.size() > 0) {
			return genres.get(0);
		}
		return null;
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Genre> genres = new ArrayList<Genre>();

		try {
			while (rs.next()) {
				Genre g = new Genre();
				g.setGenre_Id(rs.getInt("genre_Id"));
				g.setGenre_Name(rs.getString("genre_Name"));

				genres.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genres;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<Genre> genres = new ArrayList<Genre>();

		try {
			while (rs.next()) {
				Genre g = new Genre();
				g.setGenre_Id(rs.getInt("genre_id"));
				g.setGenre_Name(rs.getString("genre_name"));
				
				
				genres.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return genres;
	}



}
