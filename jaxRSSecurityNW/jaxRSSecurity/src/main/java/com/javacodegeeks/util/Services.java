package com.javacodegeeks.util;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.javacodegeeks.model.Student;

@Path("/rest")
public class Services {

	@GET
	@Path("/student/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> studentList(){
		List<Student> studentList = new ArrayList<Student>();
		Student st1 = new Student();
		st1.setFirstName("Emily");
		st1.setLastName("Watson");
		st1.setSchool("Edinburgh High School");
		studentList.add(st1);
		
		Student st2 = new Student();
		st2.setFirstName("Sarah");
		st2.setLastName("Williams");
		st2.setSchool("MountainView High School");
		studentList.add(st2);
		return studentList;
	}
	
	
	@GET
	@Path("/student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student studentById(@PathParam("id") int id){		
		Student student = new Student();
		student.setFirstName("Andrew");
		student.setLastName("Jones");
		student.setSchool("St.Mary's");
		student.setId(id);
		return student;
	}
}
