package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.DBManager;
import dto.AttendanceData;
import dto.ClassData;
import dto.FacultyData;
import dto.LectureData;
import dto.Server;
import dto.StudentData;
import dto.SubjectData;

public class DBAccessor 
{
	File currDir = new File("");
	public DBAccessor() 
	{
//		File currDir = new File("");
//	    path = currDir.getAbsolutePath();
	}
	
	public ArrayList<StudentData> getStudentData(String path)
	{
		ResultSet rs=null;
		ArrayList<StudentData> studentlist=new ArrayList<StudentData>();
		DBManager db=new DBManager();
		try 
		{
			// fetch all student data from database
			db.getConnection();
			rs=db.fetchAllStudentRecord();
			while(rs.next())
			{
				StudentData studentdata=new StudentData();
				
				studentdata.setS_id(rs.getInt("s_id"));
				studentdata.setS_first_name(rs.getString("s_first_name"));
				studentdata.setS_last_name(rs.getString("s_last_name"));
				studentdata.setS_fingerprint(rs.getString("s_fingerprint"));
				studentdata.setS_photo(rs.getString("s_photo"));
				studentdata.setC_id(rs.getInt("c_id"));
//				new Server(path, rs.getString("s_fingerprint"));
				studentdata.setS_Fingerprint_Byte(sendFingerPrint(path,rs.getString("s_fingerprint")));
				studentdata.setS_FingerPrint_size(sendFingerPrint(path,rs.getString("s_fingerprint")).length);
				if(rs.getString("s_photo").equals("none"))
				{
					System.out.println("Photo not avaible");
				}
				else
				{
					studentdata.setS_Photo_Byte(sendPhoto(path,rs.getString("s_photo")));
					studentdata.setS_Photo_size(sendPhoto(path,rs.getString("s_photo")).length);
				}
				studentlist.add(studentdata);
			}
			return studentlist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return studentlist;
	}
	
	public ArrayList<SubjectData> getSubjectData()
	{
		ResultSet rs=null;
		ArrayList<SubjectData> subjectlist=new ArrayList<SubjectData>();
		DBManager db=new DBManager();
		try 
		{
			db.getConnection();
			rs=db.fetchAllSubjectRecord();
			while(rs.next())
			{
				SubjectData subjectdata=new SubjectData();
				subjectdata.setSub_id(rs.getInt("sub_id"));
				subjectdata.setSub_name(rs.getString("sub_name"));
				subjectdata.setF_id(rs.getInt("f_id"));
				subjectdata.setC_id(rs.getInt("c_id"));
				subjectlist.add(subjectdata);
			}
			return subjectlist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return subjectlist;
	}
	
	public ArrayList<LectureData> getLectureData()
	{
		ResultSet rs=null;
		ArrayList<LectureData> lecturelist=new ArrayList<LectureData>();
		DBManager db=new DBManager();
		try 
		{
			db.getConnection();
			rs=db.fetchAllLectureRecord();
			while(rs.next())
			{
				LectureData lecturedata=new LectureData();
				lecturedata.setL_id(rs.getInt("l_id"));
				lecturedata.setL_date(rs.getDate("l_date"));
				lecturedata.setL_time(rs.getTime("l_time"));
				lecturedata.setC_id(rs.getInt("c_id"));
				lecturedata.setSub_id(rs.getInt("sub_id"));
				lecturelist.add(lecturedata);
			}
			return lecturelist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return lecturelist;
	}

	public ArrayList<FacultyData> getFacultyData(String path)
	{
		ResultSet rs=null;
		ArrayList<FacultyData> facultylist=new ArrayList<FacultyData>();
		DBManager db=new DBManager();
		try 
		{
			db.getConnection();
			rs=db.fetchAllFacultyRecord();
			while(rs.next())
			{
				FacultyData facultydata=new FacultyData();
				facultydata.setF_id(rs.getInt("f_id"));
				facultydata.setF_first_name(rs.getString("f_first_name"));
				facultydata.setF_last_name(rs.getString("f_last_name"));
				facultydata.setF_photo(rs.getString("f_photo"));
				
				facultydata.setF_Fingerprint_Byte(sendFingerPrint(path,rs.getString("f_fingerprint")));
				
				if(rs.getString("f_photo").equals("none"))
				{
//					System.out.println("Photo not avaible");
				}
				else 
				{
					facultydata.setF_Photo_Byte(sendPhoto(path,rs.getString("f_photo")));
				}
				facultylist.add(facultydata);
			}
			return facultylist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return facultylist;
	}

	public ArrayList<ClassData> getClassData()
	{
		ResultSet rs=null;
		ArrayList<ClassData> classlist=new ArrayList<ClassData>();
		DBManager db=new DBManager();
		try 
		{
			db.getConnection();
			rs=db.fetchAllClassRecord();
			while(rs.next())
			{
				ClassData classdata=new ClassData();
				classdata.setC_id(rs.getInt("c_id"));
				classdata.setC_name(rs.getString("c_name"));
				classlist.add(classdata);
			}
			return classlist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return classlist;
	}

	public ArrayList<AttendanceData> getAttendanceData()
	{
		ResultSet rs=null;
		ArrayList<AttendanceData> attendancelist=new ArrayList<AttendanceData>();
		DBManager db=new DBManager();
		try 
		{
			db.getConnection();
			rs=db.fetchAllAttendanceRecord();
			while(rs.next())
			{
				AttendanceData attendancedata=new AttendanceData();
				attendancedata.setL_id(rs.getInt("l_id"));
				attendancedata.setS_id(rs.getInt("s_id"));
				attendancelist.add(attendancedata);
			}
			return attendancelist;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return attendancelist;
	}

	public byte[] sendPhoto(String path,String photoFileName)
	{
//		Test t=new Test();
//		String path=t.pathString();
		String fullPath=path+"/AttendanceSystemService/photo/"+photoFileName;
//		reportGenerator(path,fullPath);
		FileInputStream fileInputStream=null;
        File file = new File(fullPath);
        byte[] bFile = new byte[(int) file.length()];
        try 
        {
        	fileInputStream = new FileInputStream(file);
        	fileInputStream.read(bFile);
        	fileInputStream.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return bFile;
	}
	
	public byte[] sendFingerPrint(String path,String fingerFileName)
	{
//		Test t=new Test();
//		String path=t.pathString();
		String fullPath=path+"/AttendanceSystemService/fingerprint/"+fingerFileName;
//		reportGenerator(path,fullPath);
		FileInputStream fileInputStream=null;
        File file = new File(fullPath);
        byte[] bFile = new byte[(int) file.length()];
        try 
        {
        	fileInputStream = new FileInputStream(file);
        	fileInputStream.read(bFile);
        	fileInputStream.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return bFile;
	}
	
/*	public static boolean updateAttendanceTable(List<AttendanceData> attendanceList)
	{
		DBManager db=new DBManager();
		try
		{
			db.getConnection();
			return dbManager.updateAttendanceTable(connection,attendanceList);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}*/
	
	public void reportGenerator(String path,String fullPath)
	{
		try 
		{
			FileWriter fw;
			String newPath=path+"/AttendanceSystemService";
			File file = new File(newPath);
			
			if( file.exists() || file.mkdirs())
			{
				file = new File(newPath+"/Report.txt");
				if (!file.exists()) 
				{
					fw = new FileWriter(file);	
					fw.write(fullPath);
				}
				else
					fw = new FileWriter(file,true);
				
				StringBuffer sb= new StringBuffer(100);
				fw.write(sb.toString());
				fw.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
