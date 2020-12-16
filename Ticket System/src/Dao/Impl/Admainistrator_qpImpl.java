package Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Admainistrator_qpDao;
import util.DBcon;

public class Admainistrator_qpImpl implements Admainistrator_qpDao{

	@Override
	public boolean Login(String accountg, String passwordg) throws SQLException {
		boolean flag = false;
		String sql = "select accountg,passwordg from administrator_ap";
		Connection con = DBcon.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rr = stmt.executeQuery();
		while(rr.next()){
			String account1 = rr.getString(1);
			String password1 =rr.getString(2);
					if(accountg.equals(account1)&&passwordg.equals(password1)){
						flag = true;
						break;
					}
		}
		DBcon.closeAll(stmt, rr);
			return flag;
	}

}
