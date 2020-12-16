package Dao;

import java.sql.SQLException;
import java.util.List;

import entity.AcPs;
import entity.GetUserid;
import entity.User;

public interface UserDao {
	/**
	 * 添加
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean add(String name,String identity_number,String account,String password) throws Exception;
	/**
	 * 修改
	 * @param user
	 * @return
	 * @throws SQLException 
	 */

	boolean update(User user) throws SQLException;
	/**
	 * 删除
	 * @param userid
	 * @return
	 * @throws SQLException 
	 */
	void delete(int userid) throws SQLException;
	
	/**
	 * 通过Id查找 一条记录
	 * @param userid
	 * @return
	 * @throws SQLException 
	 */
	List<User> QueryById(int userid) throws SQLException;
	
	/**
	 * 查找全部记录
	 * @return
	 * @throws SQLException 
	 */
	List<User> queryAll() throws SQLException;
	/**
	 * 查找账号密码
	 * @param account
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	boolean SlectAcPs(String account,String password) throws SQLException;
	/**
	 * 查找账号
	 * @param account
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	List<AcPs> getAC(String account,String password) throws SQLException;
	/**
	 * 根据账号查id
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	int GetUseridbyaccount(String account) throws SQLException;
	/**
	 * 验证账号是否存在
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	boolean SelectAc(String account) throws SQLException;
	boolean addBlance(int userid,int yuan) throws SQLException;
	boolean reduBlance(int userid,int yuan) throws SQLException;
	int selectbl(int userid) throws SQLException;
}
