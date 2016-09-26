package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.DBAccessor;
import model.Test;

import com.google.gson.Gson;

import dao.DBManager;
import dto.AttendanceData;
import dto.ClassData;
import dto.FacultyData;
import dto.LectureData;
import dto.StudentData;
import dto.SubjectData;

@Path("/Services")
public class Service 
{
	@GET
	@Path("/getStudentData") //function written in service class
	@Produces("application/json")
	public Response getStudentData()
	{
		System.out.println("Student Hit");
		DBAccessor dba=new DBAccessor();
		ArrayList<StudentData> studentarraylist=new ArrayList<StudentData>();
		
		Test obj = new Test();
//		System.out.println("HERE "+obj.pathString());
		
/*	    String path = currDir.getAbsolutePath();
	    System.out.println("service path "+path);
*/		studentarraylist=dba.getStudentData(obj.pathString());
		
		Gson gs=new Gson();
		String studentdata=gs.toJson(studentarraylist);
		return Response.status(200).entity(studentdata).build();
	}
	
	@GET
	@Path("/getSubjectData") 
	@Produces("application/json")
	public Response getSubjectData()
	{
		System.out.println("Subject Hit");
		DBAccessor dba=new DBAccessor();
		ArrayList<SubjectData> subjectarraylist=new ArrayList<SubjectData>();
		subjectarraylist=dba.getSubjectData();
		
		Gson gs=new Gson();
		String subjectdata=gs.toJson(subjectarraylist);
		return Response.status(200).entity(subjectdata).build();
	}

	@GET
	@Path("/getLectureData") 
	@Produces("application/json")
	public Response geLectureData()
	{
		System.out.println("Lecture Hit");		
		DBAccessor dba=new DBAccessor();
		ArrayList<LectureData> lecturearraylist=new ArrayList<LectureData>();
		lecturearraylist=dba.getLectureData();
		
		Gson gs=new Gson();
		String lecturedata=gs.toJson(lecturearraylist);
		return Response.status(200).entity(lecturedata).build();
	}
	
	@GET
	@Path("/getFacultyData") 
	@Produces("application/json")
	public Response getFacultyData()
	{
		System.out.println("Faculty Hit");		
		Test obj = new Test();
//		System.out.println("HERE "+obj.pathString());
		DBAccessor dba=new DBAccessor();
		ArrayList<FacultyData> facultyarraylist=new ArrayList<FacultyData>();
		facultyarraylist=dba.getFacultyData(obj.pathString());
		
		Gson gs=new Gson();
		String facultydata=gs.toJson(facultyarraylist);
		return Response.status(200).entity(facultydata).build();
	}
	
	@GET
	@Path("/getClassData") 
	@Produces("application/json")
	public Response getClassData()
	{
		System.out.println("Class hit");
		DBAccessor dba=new DBAccessor();
		ArrayList<ClassData> classarraylist=new ArrayList<ClassData>();
		classarraylist=dba.getClassData();
		
		Gson gs=new Gson();
		String classdata=gs.toJson(classarraylist);
		return Response.status(200).entity(classdata).build();
	}
	
	@GET
	@Path("/getAttendanceData") 
	@Produces("application/json")
	public Response getAttendanceData()
	{
		System.out.println("Attendance Hit");		
		DBAccessor dba=new DBAccessor();
		ArrayList<AttendanceData> attendancearraylist=new ArrayList<AttendanceData>();
		attendancearraylist=dba.getAttendanceData();
		
		Gson gs=new Gson();
		String attendancedata=gs.toJson(attendancearraylist);
		return Response.status(200).entity(attendancedata).build();
	}

/*	@POST
	@Path("/updateUserSyncTable")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateUserSyncTable(String json)
	{
		Gson gs = null;
		try 
		{
				gs = new Gson();
				List<AttendanceData> attendanceList = Arrays.asList(gs.fromJson(json, AttendanceData[].class));
				DBAccessor.updateAttendanceTable(attendanceList);
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return Response.status(200).entity(gs.toJson("false")).build();
		}
		return Response.status(200).entity(gs.toJson("false")).build();
	}
*/	
}
