package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.TickeDao;
import entity.Ticket;
import entity.User;
import util.DBcon;

public class TicketImpl implements TickeDao{

	@Override
	public boolean add(String station_arrival, String station_depart, String depart_date, String depart_time,
			int ticket_number, String seattypeid, String tickettypeid, int tickets_left, String fares,
			String ticket_office) throws Exception {
			Connection con = DBcon.getConnection();
			String sqladd = "insert into ticket(station_arrival,station_depart,depart_date,depart_time,ticket_number,seattypeid,"
					+ "tickettypeid,tickets_left,fares,ticket_office) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sqladd);
			stmt.setString(1, station_arrival);
			stmt.setString(2, station_depart);
			stmt.setString(3, depart_date);
			stmt.setString(4, depart_time);
			stmt.setInt(5, ticket_number);
			stmt.setString(6, seattypeid);
			stmt.setString(7, tickettypeid);
			stmt.setInt(8, tickets_left);
			stmt.setString(9, fares);
			stmt.setString(10, ticket_office);
			ResultSet rs = null;
			stmt.executeUpdate();
			DBcon.closeAll(stmt, rs);
			return true;
	}

	@Override
	public boolean update(Ticket ticket) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "update ticket set station_arrival=?,station_depart=?,depart_date=?,"
				+ "depart_time=?,ticket_number=?,seattypeid=?,tickettypeid=?,tickets_left=?,fares=?,"
				+ "ticket_office=? where ticketid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setString(1, ticket.getStation_arrival());
		stmt.setString(2, ticket.getStation_depart());
		stmt.setString(3, ticket.getDepart_date());
		stmt.setString(4, ticket.getDepart_time());
		stmt.setInt(5, ticket.getTicket_number());
		stmt.setString(6, ticket.getSeattypeid());
		stmt.setString(7, ticket.getTickettypeid());
		stmt.setInt(8, ticket.getTickets_left());
		stmt.setString(9, ticket.getFares());
		stmt.setString(10, ticket.getTicket_office());
		stmt.setInt(11, ticket.getTicketid());
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
		return true;
	}

	@Override
	public void delete(int ticketid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "delete from ticket where ticketid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, ticketid);
		ResultSet rs = null;
		stmt.executeUpdate();
		DBcon.closeAll(stmt, rs);
		
	}

	@Override
	public List<Ticket> QueryById(int ticketid) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from ticket where ticketid=?";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		ResultSet rs = stmt.executeQuery();
		List<Ticket> ticket = new ArrayList<>();
		while(rs.next()) {
			int ticketid0 = rs.getInt(1);
			String station_arrival = rs.getString(2);
			String station_depart = rs.getString(3);
			String depart_date = rs.getString(4);
			String depart_time= rs.getString(5);
			int ticket_number = (rs.getInt(6));
			String seattypeid = rs.getString(7);
			String tickettypeid = rs.getString(8);
			int tickets_left = rs.getInt(9);
			String fares = rs.getString(10);		
			String ticket_office = rs.getString(11);
			Ticket ticket2 = new Ticket(ticketid0, station_arrival, 
					station_depart, depart_date, depart_time, ticket_number, 
					seattypeid, tickettypeid, tickets_left, fares, ticket_office);
			ticket.add(ticket2);
		}
		DBcon.closeAll(stmt, rs);
		return ticket;
	}

	@Override
	public List<Ticket> queryAll() throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from ticket ";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		ResultSet rs = stmt.executeQuery();
		List<Ticket> ticket = new ArrayList<>();
		while(rs.next()) {
			int ticketid0 = rs.getInt(1);
			String station_arrival = rs.getString(2);
			String station_depart = rs.getString(3);
			String depart_date = rs.getString(4);
			String depart_time= rs.getString(5);
			int ticket_number = (rs.getInt(6));
			String seattypeid = rs.getString(7);
			String tickettypeid = rs.getString(8);
			int tickets_left = rs.getInt(9);
			String fares = rs.getString(10);		
			String ticket_office = rs.getString(11);
			Ticket ticket2 = new Ticket(ticketid0, station_arrival, 
					station_depart, depart_date, depart_time, ticket_number, 
					seattypeid, tickettypeid, tickets_left, fares, ticket_office);
			ticket.add(ticket2);
		}
		DBcon.closeAll(stmt, rs);
		return ticket;
	}

	@Override
	public List<Ticket> quetida(String station_arrival,String station_depart,String depart_date) throws SQLException {
		Connection con = DBcon.getConnection();
		String sqladd = "select * from ticket where station_arrival=? and station_depart=? and depart_date=? ";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setString(1, station_arrival);
		stmt.setString(2, station_depart);
		stmt.setString(3, depart_date);
		ResultSet rs = stmt.executeQuery();
		List<Ticket> ticket = new ArrayList<>();
		while(rs.next()) {
			int ticketid0 = rs.getInt(1);
			String station_arrival0 = rs.getString(2);
			String station_depart0 = rs.getString(3);
			String depart_date0 = rs.getString(4);
			String depart_time= rs.getString(5);
			int ticket_number = (rs.getInt(6));
			String seattypeid = rs.getString(7);
			String tickettypeid = rs.getString(8);
			int tickets_left = rs.getInt(9);
			String fares = rs.getString(10);		
			String ticket_office = rs.getString(11);
			Ticket ticket2 = new Ticket(ticketid0, station_arrival0, 
					station_depart0, depart_date0, depart_time, ticket_number, 
					seattypeid, tickettypeid, tickets_left, fares, ticket_office);
			ticket.add(ticket2);
		}
		System.out.println(rs.next());
		DBcon.closeAll(stmt, rs);
		
		return ticket;
	}

	@Override
	public int fares(int ticketid) throws SQLException {
		Connection con = DBcon.getConnection();
		int far = 0;
		String sqladd = "select fares from ticket where ticketid=? ";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		stmt.setInt(1, ticketid);
		ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				far = rs.getInt(1);
			}
			return far;
	}
	
}
