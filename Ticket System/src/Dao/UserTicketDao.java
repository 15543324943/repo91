package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.UserTicket;


public interface UserTicketDao {
	
	/**
	 * ���
	 * @param UserTicket
	 * @return
	 * @throws Exception 
	 */
	boolean add(int userticketuserid,int userticketticketid,String userticketname,String userticketidentity_number,String userticketstation_arrival,String userticketstation_depart,String userticketdepart_date,String userticketdepart_time,int userticketticket_number,String userticketseattype,String usertickettickettype,String userticketfares,String userticketticket_office) throws Exception;
	/**
	 * �޸�
	 * @param UserTicket
	 * @return
	 * @throws SQLException 
	 */

	boolean update(UserTicket UserTicket) throws SQLException;
	/**
	 * ɾ��
	 * @param UserTicketid
	 * @return
	 * @throws SQLException 
	 */
	void delete(int userticketid) throws SQLException;
	
	/**
	 * ͨ��UserTicketid���Ҽ�¼
	 * @param UserTicketid
	 * @return
	 * @throws SQLException 
	 */
	List<UserTicket> QueryByuserticketuserid(int userticketuserid) throws SQLException;
	/**
	 * ͨ��UserTicketid���Ҽ�¼
	 * @param UserTicketid
	 * @return
	 * @throws SQLException 
	 */
	List<UserTicket> QueryByuserticketticketid(int userticketticketid) throws SQLException;
	
	/**
	 * ����ȫ����¼
	 * @return
	 * @throws SQLException 
	 */
	List<UserTicket> queryAll() throws SQLException;
	/**
	 * �ظ���֤
	 * @param ticketid
	 * @param userid
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	boolean buyTicket(int ticketid,int userid) throws SQLException, Exception;
	/**
	 * adduserticket
	 * @param ticketid
	 * @param userid
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	boolean buyTicketb(int ticketid,int userid) throws SQLException, Exception;
	/**
	 * ����userticketid,userticketticketid ɾ��һ����Ϣ
	 * @param userticketid
	 * @param userticketticketid
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	boolean fundTicket(int userticketid,int userticketticketid) throws SQLException, Exception;
	/**
	 * �ظ�����֤
	 * @param userid
	 * @param ticketid
	 * @return
	 * @throws SQLException
	 */
	boolean SelectUidTid(int userid,int ticketid) throws SQLException;
	
	boolean Left(int ticketid) throws SQLException;
}
