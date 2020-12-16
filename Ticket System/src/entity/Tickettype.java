package entity;
/**
 * ≥µ¿‡–Õ
 */
import java.io.Serializable;

public class Tickettype implements Serializable{

	private int tickettypeid;
	private String ticketname;
	
	public int getTickettypeid() {
		return tickettypeid;
	}

	public void setTickettypeid(int tickettypeid) {
		this.tickettypeid = tickettypeid;
	}

	public String getTicketname() {
		return ticketname;
	}

	public void setTicketname(String ticketname) {
		this.ticketname = ticketname;
	}

	@Override
	public String toString() {
		return this.ticketname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ticketname == null) ? 0 : ticketname.hashCode());
		result = prime * result + tickettypeid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tickettype other = (Tickettype) obj;
		if (ticketname == null) {
			if (other.ticketname != null)
				return false;
		} else if (!ticketname.equals(other.ticketname))
			return false;
		if (tickettypeid != other.tickettypeid)
			return false;
		return true;
	}

	public Tickettype(String ticketname) {
		super();
		this.ticketname = ticketname;
	}


}
