package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.SeattypeDao;
import entity.Seattype;
import util.DBcon;

public class SeattypeImpl implements SeattypeDao{
	@Override
	public List<Seattype> queryAll() throws SQLException {
		Connection con = DBcon.getConnection();
		List<Seattype> seattypt = new ArrayList<>();
		String sqladd = "select * from Seattype ";
		PreparedStatement stmt = con.prepareStatement(sqladd);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int tickettypeid  =rs.getInt(1);
			String ticketname = rs.getString(2);
			Seattype seattype = new Seattype(tickettypeid, ticketname);
			seattypt.add(seattype);
		}
		return seattypt;
	}
}
