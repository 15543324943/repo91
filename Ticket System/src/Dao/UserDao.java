package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.AcPs;
import entity.GetUserid;
import entity.User;

public interface UserDao {
	/**
	 * ���
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean add(String name,String identity_number,String account,String password) throws Exception;
	/**
	 * �޸�
	 * @param user
	 * @return
	 * @throws SQLException 
	 */

	boolean update(User user) throws SQLException;
	/**
	 * ɾ��
	 * @param userid
	 * @return
	 * @throws SQLException 
	 */
	void delete(int userid) throws SQLException;
	
	/**
	 * ͨ��Id���� һ����¼
	 * @param userid
	 * @return
	 * @throws SQLException 
	 */
	List<User> QueryById(int userid) throws SQLException;
	
	/**
	 * ����ȫ����¼
	 * @return
	 * @throws SQLException 
	 */
	List<User> queryAll() throws SQLException;
	/**
	 * �����˺�����
	 * @param account
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	boolean SlectAcPs(String account,String password) throws SQLException;
	/**
	 * �����˺�
	 * @param account
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	List<AcPs> getAC(String account,String password) throws SQLException;
	/**
	 * �����˺Ų�id
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	int GetUseridbyaccount(String account) throws SQLException;
	/**
	 * ��֤�˺��Ƿ����
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	boolean SelectAc(String account) throws SQLException;
	boolean addBlance(int userid,int yuan) throws SQLException;
	boolean reduBlance(int userid,int yuan) throws SQLException;
	int selectbl(int userid) throws SQLException;
}
