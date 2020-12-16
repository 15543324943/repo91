package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.Tickettype;

public interface TickettypeDao {
	/**
	 * 查找全部ticket类型
	 * @return
	 * @throws SQLException 
	 */
	List<Tickettype> queryAll() throws SQLException;
}
