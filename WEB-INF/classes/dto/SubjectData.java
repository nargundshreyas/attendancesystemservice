package dto;

public class SubjectData 
{
	private int sub_id;
	private String sub_name;
	private int f_id;
	private int c_id;
	
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	@Override
	public String toString() {
		return "SubjectData [sub_id=" + sub_id + ", sub_name=" + sub_name
				+ ", f_id=" + f_id + ", c_id=" + c_id + "]";
	}
}
