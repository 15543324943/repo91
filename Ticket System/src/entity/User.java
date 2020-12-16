package entity;

import java.io.Serializable;

/**
 * @author zhanglj
 * 用户实体
 *
 */
public class User implements Serializable {
	
	private int userid;
	private String name;
	private String identity_number;
	private String account;
	private String password;
	private int blance;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentity_number() {
		return identity_number;
	}
	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBlance() {
		return blance;
	}
	public void setBlance(int blance) {
		this.blance = blance;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", identity_number=" + identity_number + ", account="
				+ account + ", password=" + password + "]";
	}
	public User(int userid, String name, String identity_number, String account, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.identity_number = identity_number;
		this.account = account;
		this.password = password;
	}
}
