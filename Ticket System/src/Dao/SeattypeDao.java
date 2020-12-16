package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.Seattype;

public interface SeattypeDao {
	/**
	 * 查找全部座位
	 * @return
	 * @throws SQLException 
	 */
	List<Seattype> queryAll() throws SQLException;
}
