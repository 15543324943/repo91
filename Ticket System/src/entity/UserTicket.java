package entity;
/**
 * Æ±ÃæÊµÌå
 * @author ZJL
 *
 */
public class UserTicket {
	int userticketid;
	int userticketuserid;
	int userticketticketid;
	String userticketname;
	String userticketidentity_number;
	String userticketstation_arrival;
	String userticketstation_depart;
	String userticketdepart_date;
	String userticketdepart_time;
	int userticketticket_number;
	String userticketseattype;
	String usertickettickettype;
	String userticketfares;
	String userticketticket_office;
	public int getUserticketid() {
		return userticketid;
	}
	public void setUserticketid(int userticketid) {
		this.userticketid = userticketid;
	}
	
	
	public int getUserticketuserid() {
		return userticketuserid;
	}
	public void setUserticketuserid(int userticketuserid) {
		this.userticketuserid = userticketuserid;
	}
	public int getUserticketticketid() {
		return userticketticketid;
	}
	public void setUserticketticketid(int userticketticketid) {
		this.userticketticketid = userticketticketid;
	}
	public String getUserticketname() {
		return userticketname;
	}
	
	public String getUserticketidentity_number() {
		return userticketidentity_number;
	}
	public void setUserticketidentity_number(String userticketidentity_number) {
		this.userticketidentity_number = userticketidentity_number;
	}
	public void setUserticketname(String userticketname) {
		this.userticketname = userticketname;
	}
	public String getUserticketstation_arrival() {
		return userticketstation_arrival;
	}
	public void setUserticketstation_arrival(String userticketstation_arrival) {
		this.userticketstation_arrival = userticketstation_arrival;
	}
	public String getUserticketstation_depart() {
		return userticketstation_depart;
	}
	public void setUserticketstation_depart(String userticketstation_depart) {
		this.userticketstation_depart = userticketstation_depart;
	}
	public String getUserticketdepart_date() {
		return userticketdepart_date;
	}
	public void setUserticketdepart_date(String userticketdepart_date) {
		this.userticketdepart_date = userticketdepart_date;
	}
	public String getUserticketdepart_time() {
		return userticketdepart_time;
	}
	public void setUserticketdepart_time(String userticketdepart_time) {
		this.userticketdepart_time = userticketdepart_time;
	}

	public int getUserticketticket_number() {
		return userticketticket_number;
	}
	public void setUserticketticket_number(int userticketticket_number) {
		this.userticketticket_number = userticketticket_number;
	}
	public String getUserticketseattype() {
		return userticketseattype;
	}
	public void setUserticketseattype(String userticketseattype) {
		this.userticketseattype = userticketseattype;
	}
	public String getUsertickettickettype() {
		return usertickettickettype;
	}
	public void setUsertickettickettype(String usertickettickettype) {
		this.usertickettickettype = usertickettickettype;
	}
	public String getUserticketfares() {
		return userticketfares;
	}
	public void setUserticketfares(String userticketfares) {
		this.userticketfares = userticketfares;
	}
	public String getUserticketticket_office() {
		return userticketticket_office;
	}
	public void setUserticketticket_office(String userticketticket_office) {
		this.userticketticket_office = userticketticket_office;
	}
	@Override
	public String toString() {
		return "Userticket [userticketid=" + userticketid + ", userticketuserid=" + userticketuserid
				+ ", userticketticketid=" + userticketticketid + ", userticketname=" + userticketname
				+ ", userticketidentity_number=" + userticketidentity_number + ", userticketstation_arrival="
				+ userticketstation_arrival + ", userticketstation_depart=" + userticketstation_depart
				+ ", userticketdepart_date=" + userticketdepart_date + ", userticketdepart_time="
				+ userticketdepart_time + ", userticketticket_number=" + userticketticket_number
				+ ", userticketseattype=" + userticketseattype + ", usertickettickettype=" + usertickettickettype
				+ ", userticketfares=" + userticketfares + ", userticketticket_office=" + userticketticket_office + "]";
	}
	public UserTicket(int userticketid, int userticketuserid, int userticketticketid, String userticketname,
			String userticketidentity_number, String userticketstation_arrival, String userticketstation_depart,
			String userticketdepart_date, String userticketdepart_time, int userticketticket_number,
			String userticketseattype, String usertickettickettype, String userticketfares,
			String userticketticket_office) {
		super();
		this.userticketid = userticketid;
		this.userticketuserid = userticketuserid;
		this.userticketticketid = userticketticketid;
		this.userticketname = userticketname;
		this.userticketidentity_number = userticketidentity_number;
		this.userticketstation_arrival = userticketstation_arrival;
		this.userticketstation_depart = userticketstation_depart;
		this.userticketdepart_date = userticketdepart_date;
		this.userticketdepart_time = userticketdepart_time;
		this.userticketticket_number = userticketticket_number;
		this.userticketseattype = userticketseattype;
		this.usertickettickettype = usertickettickettype;
		this.userticketfares = userticketfares;
		this.userticketticket_office = userticketticket_office;
	}
	
	
}
