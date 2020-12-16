package Dao.Impl;

import java.sql.SQLException;

import Dao.TickeDao;

public class Test {
	public static void main(String[] args) throws SQLException {
		TickeDao t = new TicketImpl();
		int s = t.fares(26);
		System.out.println(s);
	}
}
