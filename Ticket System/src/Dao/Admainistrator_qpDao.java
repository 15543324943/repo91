package Dao;

import java.sql.SQLException;

public interface Admainistrator_qpDao {
	/**
	 * 
	 * �����˺�����
	 * @param accountg
	 * @param passwordg
	 * @return
	 * @throws SQLException
	 */
	boolean Login(String accountg,String passwordg) throws SQLException;
}
