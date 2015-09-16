package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Branch;
@SuppressWarnings("unchecked")
public class BranchDAO extends BaseDAO{
	
	public BranchDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void createBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchName, branchAddress) values(?,?)", new Object[] { branch.getBranchName(), branch.getBranchAddress() });
	}

	public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("update tbl_library_branch set branchName = ?, branchAddress=? where branchId = ?",
				new Object[] { branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId() });
	}

	public void deleteBranch(Branch branch) throws ClassNotFoundException, SQLException {
		save("delete from tbl_library_branch where branchId=?", new Object[] { branch.getBranchId() });
	}

	public List<Branch> getAllBranch() throws ClassNotFoundException, SQLException {
		return readFirstLevel("select * from tbl_library_branch", null);
	}

	public Branch getBranchByBranchId(int branchId) throws ClassNotFoundException, SQLException {
		List<Branch> branches = new ArrayList<Branch>();
		branches = readFirstLevel("select * from tbl_library_branch where branchId = ?", new Object[] { branchId });

		if (branches != null && branches.size() > 0) {
			return branches.get(0);
		}
		return null;
	}

	public Branch getBranchByBranchName(Branch branch) throws ClassNotFoundException, SQLException {
		List<Branch> branches = new ArrayList<Branch>();
		branches = readAll("select * from tbl_library_branch where branchName = ?", new Object[] { branch.getBranchName() });

		if (branches != null && branches.size() > 0) {
			return branches.get(0);
		}
		return null;
	}
	
	public List<Branch> getBranchByName(String search) throws ClassNotFoundException, SQLException {
		search = "%"+search+"%";
		
		return readFirstLevel("select * from tbl_library_branch where branchName like ?", new Object[] {search});
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Branch> branches = new ArrayList<Branch>();

		try {
			while (rs.next()) {
				Branch br = new Branch();
				br.setBranchId(rs.getInt("branchId"));
				br.setBranchName(rs.getString("branchName"));

				branches.add(br);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return branches;
	}
	
	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<Branch> branches = new ArrayList<Branch>();

		try {
			while (rs.next()) {
				Branch b = new Branch();
				b.setBranchId(rs.getInt("branchId"));
				b.setBranchName(rs.getString("branchName"));
				b.setBranchAddress(rs.getString("branchAddress"));
				
				branches.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return branches;
	}



}
