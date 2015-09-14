package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Publisher;

@SuppressWarnings("unchecked")
public class PublisherDAO extends BaseDAO{
	
	public PublisherDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	
	public void createPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values(?,?,?)", new Object[] { publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone()});
	}

	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress=?, publisherPhone=? where publisherId=?",
				new Object[] { publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone(), publisher.getPublisherId()});
	}

	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("delete from tbl_publisher where publisherId=?", new Object[] { publisher.getPublisherId() });
	}

	public List<Publisher> getAllPublisher() throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_publisher", null);
	}

	public Publisher getPublisherById(int publisherId) throws ClassNotFoundException, SQLException {
		List<Publisher> publishers = new ArrayList<Publisher>();
		publishers = readAll("select * from tbl_publisher where publisherId = ?", new Object[] { publisherId });

		if (publishers != null && publishers.size() > 0) {
			return  publishers.get(0);
		}
		return null;
	}

	public Publisher getPublisherByPublisherName(Publisher publisher) throws ClassNotFoundException, SQLException {
		List<Publisher> publishers = new ArrayList<Publisher>();
		publishers = readAll("select * from tbl_publisher where publisherName = ?", new Object[] { publisher.getPublisherName() });

		if (publishers != null && publishers.size() > 0) {
			return publishers.get(0);
		}
		return null;
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Publisher> publishers = new ArrayList<Publisher>();

		try {
			while (rs.next()) {
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherAddress(rs.getString("publisherAddress"));
				p.setPublisherPhone(rs.getString("publisherPhone"));

				publishers.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return publishers;
	}

	
	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<Publisher> publishers = new ArrayList<Publisher>();

		try {
			while (rs.next()) {
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherPhone(rs.getString("publisherPhone"));
				
				publishers.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return publishers;
	}

	



}
