package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.Seattype;

public interface SeattypeDao {
	/**
	 * ����ȫ����λ
	 * @return
	 * @throws SQLException 
	 */
	List<Seattype> queryAll() throws SQLException;
}
