package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.UserDao;
import entity.AcPs;
import entity.User;
import util.*;
public class UserDaoImpl implements UserDao{

	public boolean add(String name,String identity_number,String account,String password) throws Exception{
		Connection con = DBcon.getConnection();
		String sqladd = "insert into user(name,identity_number,account,password) values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setString(1, name);
		stmt.setString(2, identity_number);
		stmt.setString(3, account);
		stmt.setString(4, password);
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
		return true;
	}

	public boolean update(User user) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "update user set name=?,identity_number=? ,account=?, password=? where userid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getIdentity_number());
		stmt.setString(3, user.getAccount());
		stmt.setString(4, user.getPassword());
		stmt.setInt(5, user.getUserid());
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
		return true;
	}

	public void delete(int userid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "delete from user where userid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userid);
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
	}

	public List<User> QueryById(int userid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from user where userid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userid);
		ResultSet rs = stmt.executeQuery();
		List<User> user = new ArrayList<>();
		while(rs.next()) {
			int userid0 = rs.getInt(1);
			String name = rs.getString(2);
			String identity_number = rs.getString(3);
			String account = rs.getString(4);
			String password = rs.getString(5);
			User user0 = new User(userid0, name, identity_number, account, password);
			user.add(user0);
		}
		DBcon.closeAll(stmt, rs);
		return user;
	}

	public List<User> queryAll() throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from user";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		ResultSet rs = stmt.executeQuery();
		List<User> user = new ArrayList<>();
		while(rs.next()) {
			int userid0 = rs.getInt(1);
			String name = rs.getString(2);
			String identity_number = rs.getString(3);
			String account = rs.getString(4);
			String password = rs.getString(5);
			User user0 = new User(userid0, name, identity_number, account, password);
			user.add(user0);
		}
		DBcon.closeAll(stmt, rs);
		return user;
	}

	@Override
	public boolean SlectAcPs(String account, String password) throws SQLException {
		boolean flag = false;
		String sql = "select account,password from user";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rr = stmt.executeQuery();
		while(rr.next()){
			String account1 = rr.getString(1);
			String password1 =rr.getString(2);
					if(account.equals(account1)&&password.equals(password1)){
						flag = true;
						break;
					}
		}
		DBcon.closeAll(stmt, rr);
			return flag;
	}

	@Override
	public List<AcPs> getAC(String account, String password) throws SQLException {
		String account0 = account;
		String password0  = password;
		List<AcPs> acps = new ArrayList<>();
		AcPs acpss = new AcPs(account0, password0);
		acps.add(acpss);
		
		return acps;
	}

	@Override
	public int GetUseridbyaccount(String account) throws SQLException {
		Connection con = DBcon.getConnection();
		String sql = "select userid from user where account = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, account);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		int userid = rs.getInt(1);
		DBcon.closeAll(stmt, rs);
		return userid;
	}

	@Override
	public boolean SelectAc(String account) throws SQLException {
		boolean flag = false;
		String sql = "select account from user";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rr = stmt.executeQuery();
		while(rr.next()){
			String account1 = rr.getString(1);
					if(account.equals(account1)){
						flag = true;
						break;
					}
		}
		DBcon.closeAll(stmt, rr);
			return flag;
	}

	@Override
	public boolean addBlance(int userid, int yuan) throws SQLException {
		System.out.println(userid+"----"+yuan);
		boolean flag = false;
		String sql = "update user set balance=balance+? where userid = ?";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, yuan);
		stmt.setInt(2, userid);
		int result = stmt.executeUpdate();
		ResultSet rr =null;
		System.out.println(sql);
		if(result>=1){
			flag = true;
		}
		
		DBcon.closeAll(stmt, rr);
			return flag;
	}

	@Override
	public boolean reduBlance(int userid, int yuan) throws SQLException {
		System.out.println(userid+"+++++"+yuan);
		boolean flag = false;
		String sql = "update user set balance=balance-? where userid = ?";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, yuan);
		stmt.setInt(2, userid);
		int result = stmt.executeUpdate();
		ResultSet rr =null;
		System.out.println(sql);
		if(result>=1){
			flag = true;
		}
		
		DBcon.closeAll(stmt, rr);
			return flag;
	}

	@Override
	public int selectbl(int userid) throws SQLException {
		Connection con = DBcon.getConnection();
		int far = 0;
		String sqladd = "select balance from user where userid=? ";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userid);
		ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				far = rs.getInt(1);
			}
			return far;
	}
	
}
