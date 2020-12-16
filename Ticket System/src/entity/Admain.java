package entity;
/**
 * 管理员实体
 * @author ZJL
 *
 */
public class Admain {
	String accountg;
	String passeordg;
	public String getAccountg() {
		return accountg;
	}
	public void setAccountg(String accountg) {
		this.accountg = accountg;
	}
	public String getPasseordg() {
		return passeordg;
	}
	public void setPasseordg(String passeordg) {
		this.passeordg = passeordg;
	}
	@Override
	public String toString() {
		return "Admain [accountg=" + accountg + ", passeordg=" + passeordg + "]";
	}
	public Admain(String accountg, String passeordg) {
		super();
		this.accountg = accountg;
		this.passeordg = passeordg;
	}
	
}
