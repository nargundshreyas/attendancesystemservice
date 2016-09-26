package dto;

import java.util.Arrays;

public class StudentData 
{
	private int s_id;
	private String s_first_name;
	private String s_last_name;
	private String s_fingerprint;
	private String s_photo;
	private int c_id;
	private byte s_Photo_Byte[];
	private byte s_Fingerprint_Byte[];
	private long s_Photo_Size;
	private long s_FingerPrint_Size;

	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_first_name() {
		return s_first_name;
	}
	public void setS_first_name(String s_first_name) {
		this.s_first_name = s_first_name;
	}
	public String getS_last_name() {
		return s_last_name;
	}
	public void setS_last_name(String s_last_name) {
		this.s_last_name = s_last_name;
	}
	public String getS_fingerprint() {
		return s_fingerprint;
	}
	public void setS_fingerprint(String s_fingerprint) {
		this.s_fingerprint = s_fingerprint;
	}
	public String getS_photo() {
		return s_photo;
	}
	public void setS_photo(String s_photo) {
		this.s_photo = s_photo;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public byte[] getS_Photo() {
		return s_Photo_Byte;
	}
	public byte[] getS_Photo_Byte() {
		return s_Photo_Byte;
	}
	public void setS_Photo_Byte(byte[] s_Photo_Byte) {
		this.s_Photo_Byte = s_Photo_Byte;
	}
	public byte[] getS_Fingerprint_Byte() {
		return s_Fingerprint_Byte;
	}
	public void setS_Fingerprint_Byte(byte[] s_Fingerprint_Byte) {
		this.s_Fingerprint_Byte = s_Fingerprint_Byte;
//		System.out.println("fingerprint size "+s_Fingerprint_Byte.length);
	}
	public long getS_Photo_size() {
		return s_Photo_Size;
	}
	public void setS_Photo_size(long s_Photo_size) {
		this.s_Photo_Size = s_Photo_size;
		System.out.println("photo size "+s_Photo_size);
	}
	public long getS_FingerPrint_size() {
		return s_FingerPrint_Size;
	}
	public void setS_FingerPrint_size(long s_FingerPrint_size) {
		this.s_FingerPrint_Size = s_FingerPrint_size;
		System.out.println("finger size "+s_FingerPrint_size);
	}
	@Override
	public String toString() {
		return "StudentData [s_id=" + s_id + ", s_first_name=" + s_first_name + ", s_last_name=" + s_last_name
				+ ", s_fingerprint=" + s_fingerprint + ", s_photo=" + s_photo + ", c_id=" + c_id + ", s_Photo_Byte="
				+ Arrays.toString(s_Photo_Byte) + ", s_Fingerprint_Byte=" + Arrays.toString(s_Fingerprint_Byte)
				+ ", s_Photo_size=" + s_Photo_Size + ", s_FingerPrint_size=" + s_FingerPrint_Size + "]";
	}
}
