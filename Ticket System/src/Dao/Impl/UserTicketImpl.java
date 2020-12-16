package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.UserTicketDao;
import entity.Ticket;
import entity.User;
import entity.UserTicket;
import util.DBcon;

public class UserTicketImpl implements UserTicketDao{

	@Override
	public boolean add(int userticketuserid, int userticketticketid, String userticketname,
			String userticketidentity_number, String userticketstation_arrival, String userticketstation_depart,
			String userticketdepart_date, String userticketdepart_time, int userticketticket_number,
			String userticketseattype, String usertickettickettype, String userticketfares,
			String userticketticket_office) throws Exception {
			Connection con = DBcon.getConnection();
			String sqladd = "insert into userticket(userticketuserid,userticketticketid,userticketname,userticketidentity_number,userticketstation_arrival,"
				+ "userticketstation_depart,userticketdepart_date,"
				+ "userticketdepart_time,userticketticket_number,userticketseattype,"
				+ "usertickettickettype,userticketfares,userticketticket_office) values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sqladd);
				stmt.setInt(1, userticketuserid);
				stmt.setInt(2, userticketticketid);
				stmt.setString(3, userticketname);
				stmt.setString(4, userticketidentity_number);
				stmt.setString(5, userticketstation_arrival);
				stmt.setString(6, userticketstation_depart);
				stmt.setString(7, userticketdepart_date);
				stmt.setString(8, userticketdepart_time);
				stmt.setInt(9, userticketticket_number);
				stmt.setString(10, userticketseattype);
				stmt.setString(11, usertickettickettype);
				stmt.setString(12, userticketfares);
				stmt.setString(13, userticketticket_office);
				stmt.executeUpdate();
				return true;
	}

	@Override
	public boolean update(UserTicket UserTicket) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(int userticketid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "delete from userticket where userticketid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userticketid);
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
		
	}

	@Override
	public List<UserTicket> QueryByuserticketuserid(int userticketuserid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from userticket where userticketuserid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userticketuserid);
		ResultSet rs = stmt.executeQuery();
		
		List<UserTicket> userticket = new ArrayList<>();
		while(rs.next()) {
			int userticketid = rs.getInt(1);
			int userticketuserid0 = rs.getInt(2);
			int userticketticketid = rs.getInt(3);
			String userticketname = rs.getString(4);
			String userticketidentity_number = rs.getString(5);
			String userticketstation_arrival = rs.getString(6);
			String userticketstation_depart = rs.getString(7);
			String userticketdepart_date = rs.getString(8);
			String userticketdepart_time = rs.getString(9);
			int userticketticket_number = rs.getInt(10);
			String userticketseattype = rs.getString(11);
			String usertickettickettype = rs.getString(12);
			String userticketfares = rs.getString(13);
			String userticketticket_office = rs.getString(14);
			System.out.println(userticketticket_office);
			UserTicket userticket1 = new UserTicket(userticketid, userticketuserid0,
					userticketticketid, userticketname, userticketidentity_number,
					userticketstation_arrival, userticketstation_depart, userticketdepart_date,
					userticketdepart_time, userticketticket_number, userticketseattype,
					usertickettickettype, userticketfares, userticketticket_office);
			
			userticket.add(userticket1);
		}
		DBcon.closeAll(stmt, rs);
		return userticket;
	}

	@Override
	public List<UserTicket> QueryByuserticketticketid(int userticketticketid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from userticket where userticketticketid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, userticketticketid);
		ResultSet rs = stmt.executeQuery();
		List<UserTicket> userticket = new ArrayList<>();
		while(rs.next()) {
			int userticketid = rs.getInt(1);
			int userticketuserid = rs.getInt(2);
			int userticketticketid0 = rs.getInt(3);
			String userticketname = rs.getString(4);
			String userticketidentity_number = rs.getString(5);
			String userticketstation_arrival = rs.getString(6);
			String userticketstation_depart = rs.getString(7);
			String userticketdepart_date = rs.getString(8);
			String userticketdepart_time = rs.getString(9);
			int userticketticket_number = rs.getInt(10);
			String userticketseattype = rs.getString(11);
			String usertickettickettype = rs.getString(12);
			String userticketfares = rs.getString(13);
			String userticketticket_office = rs.getString(14);
			
			UserTicket userticket0 = new UserTicket(userticketid, userticketuserid, userticketticketid0,
					userticketname, userticketidentity_number, userticketstation_arrival,
					userticketstation_depart, userticketdepart_date,
					userticketdepart_time, userticketticket_number, userticketseattype,
					usertickettickettype, userticketfares, userticketticket_office);
			
			userticket.add(userticket0);
		}
		DBcon.closeAll(stmt, rs);
		return userticket;
	}

	@Override
	public List<UserTicket> queryAll() throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from userticket";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		ResultSet rs = stmt.executeQuery();
		List<UserTicket> userticket = new ArrayList<>();
		while(rs.next()) {
			int userticketid = rs.getInt(1);
			int userticketuserid = rs.getInt(2);
			int userticketticketid0 = rs.getInt(3);
			String userticketname = rs.getString(4);
			String userticketidentity_number = rs.getString(5);
			String userticketstation_arrival = rs.getString(6);
			String userticketstation_depart = rs.getString(7);
			String userticketdepart_date = rs.getString(8);
			String userticketdepart_time = rs.getString(9);
			int userticketticket_number = rs.getInt(10);
			String userticketseattype = rs.getString(11);
			String usertickettickettype = rs.getString(12);
			String userticketfares = rs.getString(13);
			String userticketticket_office = rs.getString(14);
			
			UserTicket userticket0 = new UserTicket(userticketid, userticketuserid, userticketticketid0,
					userticketname, userticketidentity_number, userticketstation_arrival,
					userticketstation_depart, userticketdepart_date,
					userticketdepart_time, userticketticket_number, userticketseattype,
					usertickettickettype, userticketfares, userticketticket_office);
			
			userticket.add(userticket0);
		}
		DBcon.closeAll(stmt, rs);
		return userticket;
	}

	@Override
	public boolean buyTicket(int ticketid, int userid) throws Exception {
			Connection con = DBcon.getConnection();
		
				String sqlll = "update ticket set tickets_left=tickets_left-1 where ticketid = ?";
				PreparedStatement stmttt = con.prepareStatement(sqlll);
				stmttt.setInt(1, ticketid);
				stmttt.executeUpdate();
				
				ResultSet rs = null;
				DBcon.closeAll(stmttt, rs);
				return true;
	}

	@Override
	public boolean buyTicketb(int ticketid, int userid) throws Exception {
		Connection conn = DBcon.getConnection();
		String sqladd = "select * from user,ticket where userid = ? and ticketid=?";
		PreparedStatement stmt = conn.prepareStatement(sqladd);
		stmt.setInt(1, userid);
		stmt.setInt(2, ticketid);
		ResultSet rt = stmt.executeQuery();
		System.out.println(rt);
		System.out.println(ticketid+"+++"+userid);
		while(rt.next()){
			
			int userticketuserid = rt.getInt(1);
			String userticketname = rt.getString(2);
			String userticketidentity_number = rt.getString(3);
			String ac = rt.getString(4);
			String ps = rt.getString(5);
			int bl = rt.getInt(6);
			int userticketticketid = rt.getInt(7);
			String userticketstation_arrival = rt.getString(8);
			String userticketstation_depart = rt.getString(9);
			String userticketdepart_date = rt.getString(10);
			String userticketdepart_time = rt.getString(11);
			int userticketticket_number = rt.getInt(12);
			String userticketseattype = rt.getString(13);
			String usertickettickettype = rt.getString(14);
			int left = rt.getInt(15);
			String userticketfares = rt.getString(16);
			String userticketticket_office = rt.getString(17);
			
			System.out.println(userid+userticketdepart_date+ac+ps+left+bl);
			
			add(userticketuserid, userticketticketid, userticketname,
				userticketidentity_number, userticketstation_arrival,
				userticketstation_depart, userticketdepart_date,
				userticketdepart_time, userticketticket_number, userticketseattype,
				usertickettickettype, userticketfares, userticketticket_office);
			
		}
			
			DBcon.closeAll(stmt, rt);
			
			return true;
	}
	
	@Override
	public boolean fundTicket(int userticketid, int userticketticketid) throws SQLException, Exception {
		Connection con = DBcon.getConnection();
		String sqlll = "update ticket set tickets_left=tickets_left+1 where ticketid = ?";
		PreparedStatement stmttt = con.prepareStatement(sqlll);
		stmttt.setInt(1, userticketticketid);
		stmttt.executeUpdate();
		String sql = "delete from userticket where userticketid=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, userticketid);
		stmt.executeUpdate();
		return true;
	}

	@Override
	public boolean SelectUidTid( int ticketid,int userid) throws SQLException {
		boolean flag = true;
		String sql = "select userticketuserid,userticketticketid from userticket";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rr = stmt.executeQuery();
		while(rr.next()){
			int useridd = rr.getInt(1);
			int ticketidd =rr.getInt(2);
					if(useridd==userid&&ticketidd==ticketid){
						flag = false;
						break;
					}
		}
		DBcon.closeAll(stmt, rr);
			return flag;
		
		
		/*String sql = "select userticketuserid,userticketticketid";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, ticketid);
		stmt.executeUpdate();
		
		ResultSet rs = null;
		DBcon.closeAll(stmt, rs);
		return true;*/
	}

	@Override
	public boolean Left(int ticketid) throws SQLException {
		boolean flag = false;
		Connection conn = DBcon.getConnection();
		String sqladd = "select tickets_left from ticket where ticketid=?";
		PreparedStatement stmt = conn.prepareStatement(sqladd);
		stmt.setInt(1, ticketid);
		ResultSet rt = stmt.executeQuery();
		
		while(rt.next()){
			int useridd = rt.getInt(1);
					if(useridd>0){
						flag = true;
						break;
					}
		}
	
		return flag;
		
	}



	

}
