package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Dao.TickettypeDao;
import entity.Tickettype;
import util.DBcon;

public class TickettypeImpl implements TickettypeDao{
@Test
		@Override
		public List<Tickettype> queryAll() throws SQLException {
			Connection con = DBcon.getConnection();
			List<Tickettype> seattype = new ArrayList<>();
			String sqladd = "select * from tickettype ";
			PreparedStatement stmt = con.prepareStatement(sqladd);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int tickettypeid  =rs.getInt(1);
				String ticketname = rs.getString(2);
				Tickettype Tickettype = new Tickettype(ticketname);
				seattype.add(Tickettype);
			}
			return seattype;
		}
}