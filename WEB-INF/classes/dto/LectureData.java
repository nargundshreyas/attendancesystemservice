package dto;

import java.sql.Date;
import java.sql.Time;

public class LectureData 
{
	private int l_id;
	private Date l_date;
	private Time l_time;
	private int c_id;
	private int sub_id;
	
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	
	public Date getL_date() {
		return l_date;
	}
	public void setL_date(Date l_date) {
		this.l_date = l_date;
	}
	public Time getL_time() {
		return l_time;
	}
	public void setL_time(Time l_time) {
		this.l_time = l_time;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	@Override
	public String toString() {
		return "LectureData [l_id=" + l_id + ", l_date=" + l_date + ", l_time="
				+ l_time + ", c_id=" + c_id + ", sub_id=" + sub_id + "]";
	}
}
