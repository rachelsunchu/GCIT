package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Borrower;

@SuppressWarnings("unchecked")
public class BorrowerDAO extends BaseDAO{
	
	public BorrowerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void createBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("insert into tbl_borrower (name, address, phone) values(?,?,?)", new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?",
				new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo() });
	}

	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("delete from tbl_borrower where cardNo=?", new Object[] { borrower.getCardNo() });
	}

	public List<Borrower> getAllBorrower() throws ClassNotFoundException, SQLException {
		return readFirstLevel("select * from tbl_borrower", null);
	}

	public Borrower getBorrowerByCardNo(int cardNo) throws ClassNotFoundException, SQLException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		borrowers = readFirstLevel("select * from tbl_borrower where cardNo = ?", new Object[] { cardNo });

		if (borrowers != null && borrowers.size() > 0) {
			return borrowers.get(0);
		}
		return null;
	}

	public Borrower getBorrowerByName(Borrower borrower) throws ClassNotFoundException, SQLException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		borrowers = readAll("select * from tbl_borrower where name = ?", new Object[] { borrower.getName() });

		if (borrowers != null && borrowers.size() > 0) {
			return borrowers.get(0);
		}
		return null;
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Borrower> borrowers = new ArrayList<Borrower>();

		try {
			while (rs.next()) {
				Borrower b = new Borrower();
				b.setCardNo(rs.getInt("cardNo"));
				b.setName(rs.getString("name"));

				borrowers.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return borrowers;
	}
	

	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<Borrower> borrowers = new ArrayList<Borrower>();

		try {
			while (rs.next()) {
				Borrower b = new Borrower();
				b.setCardNo(rs.getInt("cardNo"));
				b.setName(rs.getString("name"));
				b.setAddress(rs.getString("address"));
				b.setPhone(rs.getString("phone"));
				borrowers.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return borrowers;
	}


}
