package school_control.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import school_control.beans.Teacher;
import school_control.beans.Student;

public class DBUtils {
	
	public static Teacher findUser(Connection conn, //
			String userName, String password) throws SQLException {
		String sql = "Select a.Name, a.Password, a.Work_exp from Teacher a"//
				+ " where a.Name = ? and a.password = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			float work_exp = rs.getFloat("Work_exp");
			Teacher user = new Teacher();
			user.setUserName(userName);
			user.setPassword(password);
			user.setWorkExp(work_exp);
			return user;
		}
		return null;
	} 
	
	public static Teacher findUser(Connection conn, //
			String userName) throws SQLException {
		String sql = "Select a.Name, a.Password, a.Work_exp from Teacher a"//
				+ " where a.Name = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()) {
			String password = rs.getString("Password");
			float work_exp = rs.getFloat("Work_exp");
			Teacher user = new Teacher();
			user.setUserName(userName);
			user.setPassword(password);
			user.setWorkExp(work_exp);
			return user;
		}
		return null;
	} 
	
	public static void insertTeacher(Connection conn, Teacher teacher) throws SQLException {
		String sql = "Insert into Teacher(Name, Password, Work_exp) values (?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, teacher.getUserName());
		pstm.setString(2, teacher.getPassword());
		pstm.setFloat(3, teacher.getWorkExp());
		
		
		pstm.executeUpdate();
	}
	
	
	public static List<Student> queryStudent(Connection conn) throws SQLException {
		String sql = "Select a.Avg_mark, a.Name, a.Id, a.Parent from Student a";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		List<Student> list = new ArrayList<Student>();
		
		
		while(rs.next()) {
			float avg_mark = rs.getFloat("Avg_mark");
			String name = rs.getString("Name");
			int id = rs.getInt("Id");
			String parent = rs.getString("Parent");
			Student student = new Student();
			student.setAvgMark(avg_mark);
			student.setId(id);
			student.setName(name);
			student.setParent(parent);
			list.add(student);
		}
		return list;
		
	}
	
	public static Student findStudent(Connection conn, String name) throws SQLException {
		String sql = "Select  a.Id, a.Name, a.Avg_mark, a.Parent from Student a where a.Name=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, name);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			float avg_mark = rs.getFloat("Avg_mark");
			int id = rs.getInt("Id");
			String parent = rs.getString("Parent");
			Student student = new Student(id, name,avg_mark, parent);
			return student;
		}
		return null;
	}
	
	public static void updateStudent(Connection conn, Student student) throws SQLException {
		String sql = "Update Student set  Id=?, Avg_mark=?, Parent=?  where Name=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, student.getId());
		pstm.setFloat(2, student.getAvgMark());
		pstm.setString(3, student.getParent());
		pstm.setString(4, student.getName());
		
		pstm.executeUpdate();
	}
	
	public static void insertStudent(Connection conn, Student student) throws SQLException {
		String sql = "Insert into Student(Id, Name, Avg_mark, Parent) values (?,?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, student.getId());
		pstm.setString(2, student.getName());
		pstm.setFloat(3, student.getAvgMark());
		pstm.setString(4, student.getParent());
		
		pstm.executeUpdate();
	}
	
	public static void deleteStudent(Connection conn, String name) throws SQLException {
		String sql = "Delete From Student where Name=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, name);
		
		pstm.executeUpdate();
		
	}
}
