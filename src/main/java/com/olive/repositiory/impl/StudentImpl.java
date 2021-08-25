package com.olive.repositiory.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.olive.model.Student;
import com.olive.repositiory.Repo;
@Component
public class StudentImpl implements Repo{
@Autowired	
 JdbcTemplate jt;	

public int saveStudent(Student s) {
	String sql="INSERT INTO STUDENT VALUE(?,?,?,?)";
	int rec  =jt.update(sql,s.getId(), s.getName(), s.getAddress(), s.getCity());
	return rec;
}

	public List<Student> getAllData() {
        String sql ="select * from Student";	
 	List<Student>list=jt.query(sql,(rs, rowNum)->{
 			
 			return new Student(rs.getInt("id"),
 					rs.getString("name"),
 					rs.getString("address"),
 					rs.getString("city")
 					);
 		} );
		return list;
	}


	public int updateData(Student s) {
	  String sql ="update student set name=?,address=? where id=?";
	         int count= jt.update(sql,s.getName(),s.getAddress(),s.getId());
		return count;
	}

	public int deleteData(int id) {
		String sql="delete from student where id=?";
	int c= jt.update(sql,id);
		return c;
	}

}
