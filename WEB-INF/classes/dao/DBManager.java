package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

import dto.AttendanceData;

public class DBManager 
{
	PreparedStatement preparedStatement;
	Connection con=null;
	public void getConnection()throws Exception
	{
		try
		{
			String connectionURL="jdbc:mysql://localhost:3306/attendance_system";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(connectionURL,"root","");//sspdb
		}
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	public ResultSet fetchAllStudentRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from student_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet fetchAllSubjectRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from subject_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet fetchAllLectureRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from lecture_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet fetchAllFacultyRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from faculty_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet fetchAllClassRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from class_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet fetchAllAttendanceRecord()
	{
		ResultSet result=null;
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from attendance_table");
			result=ps.executeQuery();
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public void closeConnection()
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
/*	
	public void updateStudent() {
		try {
			String roll[]=new String[18];
			String roll1[]=new String[18];
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("Select * from student_table limit 100");		
			int i=0;
			while(rs.next()) 
			{
				roll1[i]=roll[i] = rs.getString("s_id");
				System.out.println("roll:"+roll[i]);
				roll[i] = roll[i] +".jpg";
				i++;
			}
			for(int j=0;j<roll.length;j++) {
				st.executeUpdate("Update student_table set s_photo='"+roll[j]+"' where s_id='"+roll1[j]+"'");
			}
			
		}
		catch(Exception e) {
			
		}
	}
	
*/
	/*public boolean updateAttendanceTable(Connection con, List<AttendanceData> attendanceList) 
	{
		try 
		{
			Iterator<AttendanceData> itr = attendanceList.iterator();
			while( itr.hasNext() )
			{
				AttendanceData AttendanceData = itr.next();
				preparedStatement=con.prepareStatement("insert into attendance_table(l_id,s_id) values(?,?)");
				preparedStatement.setInt(1,l_id);
				preparedStatement.setInt(2,s_id);
				preparedStatement.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	
/*	public boolean updateAttendanceTable(Connection con, List<AttendanceData> attendanceList) 
	{
		try 
		{
			Statement statement = con.createStatement();
			statement.execute("create table if not exists user_"+user_deviceid+"(question_id int, chapter_id int, important int, revised int, done int, hard int, skip int)");
			statement.close();

			PreparedStatement psQ = con.prepareStatement("delete from user_"+user_deviceid+" where chapter_id = ?");
			psQ.setInt(1,chapter_id);
			psQ.execute();

			Iterator<AttendanceData> itr = userSyncQuestionDataList.iterator();
			while( itr.hasNext() )
			{
				UserSyncQuestionData userSyncQuestionData = itr.next();
				preparedStatement=con.prepareStatement("insert into user_"+ user_deviceid + "(question_id,chapter_id,important,hard,done,skip,revised) values(?,?,?,?,?,?,?)");
				preparedStatement.setInt(1,userSyncQuestionData.getQuestion_id());
				preparedStatement.setInt(2,chapter_id);
				preparedStatement.setInt(3,userSyncQuestionData.getImp());
				preparedStatement.setInt(4,userSyncQuestionData.getHard());
				preparedStatement.setInt(5,userSyncQuestionData.getDone());
				preparedStatement.setInt(6,userSyncQuestionData.getSkip());
				preparedStatement.setInt(7,userSyncQuestionData.getRevise());
				preparedStatement.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
*/
}
