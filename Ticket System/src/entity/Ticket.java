package entity;

import java.io.Serializable;
/**
 * ³µΖ±ΚµΜε
 * @author ZJL
 *
 */
public class Ticket implements Serializable{
	private int ticketid;
	private String station_arrival;
	private String station_depart;
	private String depart_date;
	private String depart_time;
	private int ticket_number;
	private String seattypeid;
	private String tickettypeid;
	private int	tickets_left;
	private String fares;
	private String ticket_office;
	
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public String getStation_arrival() {
		return station_arrival;
	}
	public void setStation_arrival(String station_arrival) {
		this.station_arrival = station_arrival;
	}
	public String getStation_depart() {
		return station_depart;
	}
	public void setStation_depart(String station_depart) {
		this.station_depart = station_depart;
	}
	
	public String getDepart_date() {
		return depart_date;
	}
	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}
	public String getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}
	public int getTicket_number() {
		return ticket_number;
	}
	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
	}

	public String getSeattypeid() {
		return seattypeid;
	}
	public void setSeattypeid(String seattypeid) {
		this.seattypeid = seattypeid;
	}
	public String getTickettypeid() {
		return tickettypeid;
	}
	public void setTickettypeid(String tickettypeid) {
		this.tickettypeid = tickettypeid;
	}
	public int getTickets_left() {
		return tickets_left;
	}
	public void setTickets_left(int tickets_left) {
		this.tickets_left = tickets_left;
	}
	public String getFares() {
		return fares;
	}
	public void setFares(String fares) {
		this.fares = fares;
	}
	public String getTicket_office() {
		return ticket_office;
	}
	public void setTicket_office(String ticket_office) {
		this.ticket_office = ticket_office;
	}
	@Override
	public String toString() {
		return "Ticket [ticketid=" + ticketid + ", station_arrival=" + station_arrival + ", station_depart="
				+ station_depart + ", depart_date=" + depart_date + ", depart_time=" + depart_time + ", ticket_number="
				+ ticket_number + ", seattypeid=" + seattypeid + ", tickettypeid=" + tickettypeid + ", tickets_left="
				+ tickets_left + ", fares=" + fares + ", ticket_office=" + ticket_office + "]";
	}
	public Ticket(int ticketid, String station_arrival, String station_depart, String depart_date, String depart_time,
			int ticket_number, String seattypeid, String tickettypeid, int tickets_left, String fares,
			String ticket_office) {
		super();
		this.ticketid = ticketid;
		this.station_arrival = station_arrival;
		this.station_depart = station_depart;
		this.depart_date = depart_date;
		this.depart_time = depart_time;
		this.ticket_number = ticket_number;
		this.seattypeid = seattypeid;
		this.tickettypeid = tickettypeid;
		this.tickets_left = tickets_left;
		this.fares = fares;
		this.ticket_office = ticket_office;
	}

	
	
	
}
