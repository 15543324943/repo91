package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.Ticket;
import entity.User;

public interface TickeDao {

	/**
	 * 添加
	 * @param ticket
	 * @return
	 * @throws Exception 
	 */
	boolean add(String station_arrival,String station_depart,String depart_date,String depart_time,int ticket_number,String seattypeid,
			String tickettypeid,int tickets_left,String fares,String ticket_office) throws Exception;
	/**
	 * 修改
	 * @param ticket
	 * @return
	 * @throws SQLException 
	 */

	boolean update(Ticket ticket) throws SQLException;
	/**
	 * 删除
	 * @param ticketid
	 * @return
	 * @throws SQLException 
	 */
	void delete(int ticketid) throws SQLException;
	
	/**
	 * 通过Id查找 一条记录
	 * @param ticketid
	 * @return
	 * @throws SQLException 
	 */
	List<Ticket> QueryById(int ticketid) throws SQLException;
	
	/**
	 * 查找全部记录
	 * @return
	 * @throws SQLException 
	 */
	List<Ticket> queryAll() throws SQLException;
	
	List<Ticket> quetida(String station_arrival,String station_depart,String depart_date) throws SQLException;
	
	int fares(int ticketid) throws SQLException;
}
