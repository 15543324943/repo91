package entity;

import java.io.Serializable;
/**
 * ×ùÎ»ÀàĞÍ
 * @author ZJL
 *
 */
public class Seattype implements Serializable{
	private int seattypeid;
	private String seattypename;

	
	public int getSeattypeid() {
		return seattypeid;
	}

	public void setSeattypeid(int seattypeid) {
		this.seattypeid = seattypeid;
	}

	public String getSeattypename() {
		return seattypename;
	}

	public void setSeattypename(String seattypename) {
		this.seattypename = seattypename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seattypeid;
		result = prime * result + ((seattypename == null) ? 0 : seattypename.hashCode());
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
		Seattype other = (Seattype) obj;
		if (seattypeid != other.seattypeid)
			return false;
		if (seattypename == null) {
			if (other.seattypename != null)
				return false;
		} else if (!seattypename.equals(other.seattypename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return seattypename;
	}

	public Seattype(int seattypeid, String seattypename) {
		super();
		this.seattypeid = seattypeid;
		this.seattypename = seattypename;
	}

	
}
