package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.Tickettype;

public interface TickettypeDao {
	/**
	 * ����ȫ��ticket����
	 * @return
	 * @throws SQLException 
	 */
	List<Tickettype> queryAll() throws SQLException;
}
