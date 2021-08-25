package com.olive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.olive.model.Student;
import com.olive.repositiory.Repo;
@Component
public class TestRunner implements CommandLineRunner{
@Autowired
private Repo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
	int count	=repo.saveStudent(new Student(10, "Ravi", "hyd", "ameerpet"));
	int count1	=repo.saveStudent(new Student(50, "Rohit", "hyd", "ameerpet"));
	System.out.println("Inserted  Record :: " + count +"Record 2 : " +count1);
	
	System.out.println("...........All Record Getting ................................");
	   List<Student> list = repo.getAllData();
	  for(Student rec:list) {
		  System.out.println(" All Record :: " + rec);
	  }
	
	  System.out.println("...........Updating Data ................................");
	  
	              int count2= repo.updateData(new Student(10,"sunil","bhadohi","hi"));
	              System.out.println("count.update....." + count2);
	              
	  System.out.println("...........Delete Data ................................");
	        	  
	              int r1= repo.deleteData(50);
	              System.out.println("count......" + r1);
	  
	  
	}

}
