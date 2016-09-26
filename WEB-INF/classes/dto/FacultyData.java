package dto;

import java.util.Arrays;

public class FacultyData 
{
	private int f_id;
	private String f_first_name;
	private String f_last_name;
	private String f_photo;
	private byte f_Photo_Byte[];
	private byte f_Fingerprint_Byte[];

	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_first_name() {
		return f_first_name;
	}
	public void setF_first_name(String f_first_name) {
		this.f_first_name = f_first_name;
	}
	public String getF_last_name() {
		return f_last_name;
	}
	public void setF_last_name(String f_last_name) {
		this.f_last_name = f_last_name;
	}
	public String getF_photo() {
		return f_photo;
	}
	public void setF_photo(String f_photo) {
		this.f_photo = f_photo;
	}
	public byte[] getF_Photo_Byte() {
		return f_Photo_Byte;
	}
	public void setF_Photo_Byte(byte[] f_Photo_Byte) {
		this.f_Photo_Byte = f_Photo_Byte;
	}
	public byte[] getF_Fingerprint_Byte() {
		return f_Fingerprint_Byte;
	}
	public void setF_Fingerprint_Byte(byte[] f_Fingerprint_Byte) {
		this.f_Fingerprint_Byte = f_Fingerprint_Byte;
	}

	@Override
	public String toString() {
		return "FacultyData [f_id=" + f_id + ", f_first_name=" + f_first_name
				+ ", f_last_name=" + f_last_name + ", f_photo=" + f_photo
				+ ", f_Photo_Byte=" + Arrays.toString(f_Photo_Byte)
				+ ", f_Fingerprint_Byte=" + Arrays.toString(f_Fingerprint_Byte)
				+ "]";
	}
}
