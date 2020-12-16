package entity;
/**
 * ’À∫≈√‹¬Î µÃÂ
 * @author ZJL
 *
 */
public class AcPs {
	String account;
	String password;
	@Override
	public String toString() {
		return "AcPs [account=" + account + ", password=" + password + "]";
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
	public AcPs(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
	
}
