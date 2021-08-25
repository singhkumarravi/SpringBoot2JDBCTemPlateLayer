package com.olive.repositiory;

import java.util.List;

import com.olive.model.Student;

public interface Repo {
      public int saveStudent(Student s);
      public List<Student> getAllData();
      public int updateData(Student s);
      public int deleteData(int id);
      
	
}
