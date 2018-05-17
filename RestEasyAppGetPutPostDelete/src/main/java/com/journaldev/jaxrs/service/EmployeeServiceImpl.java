package com.journaldev.jaxrs.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.journaldev.jaxrs.model.Employee;
import com.journaldev.jaxrs.model.GenericResponse;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class EmployeeServiceImpl implements EmployeeService {

	private static Map<Integer,Employee> emps = new HashMap<Integer,Employee>();
	
//	@POST
	@PUT
    @Path("/add")
	
	public Response addEmployee(Employee e) {
		System.out.println("addEmployee");
		GenericResponse response = new GenericResponse();
		if(emps.get(e.getId()) != null){
			response.setStatus(false);
			response.setMessage("Employee Already Exists");
			response.setErrorCode("EC-01");
			return Response.status(422).entity(response).build();
		}
		emps.put(e.getId(), e);
		response.setStatus(true);
		response.setMessage("Employee created successfully");
		return Response.ok(response).build();
	}


	@DELETE
    @Path("/{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		System.out.println("deleteEmployee");

		GenericResponse response = new GenericResponse();
		if(emps.get(id) == null){
			response.setStatus(false);
			response.setMessage("Employee Doesn't Exists");
			response.setErrorCode("EC-02");
			return Response.status(404).entity(response).build();
		}
		emps.remove(id);
		response.setStatus(true);
		response.setMessage("Employee deleted successfully");
		return Response.ok(response).build();
	}


	@GET
	@Path("/{id}/get")
	public Employee getEmployee(@PathParam("id") int id) {
		System.out.println("getEmployee");

		System.out.println("getEmployee");
		return emps.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public Employee getDummyEmployee(@PathParam("id") int id) {
		System.out.println("getDummyEmployee");

		Employee e = new Employee();
		e.setSalary(8976.55);
		e.setName("Dummy");
		e.setId(id);
		return e;
	}

	@GET
	@Path("/getAll")
	public Employee[] getAllEmployees() {
		System.out.println("getAllEmployees");

		Set<Integer> ids = emps.keySet();
		Employee[] e = new Employee[ids.size()];
		int i=0;
		for(Integer id : ids){
			e[i] = emps.get(id);
			i++;
		}
		return e;
	}

}

//     https://www.journaldev.com/9189/resteasy-tutorial-eclipse-tomcat
//      http://localhost:8091/RestEasyApp/employee/111/getDummy
//      http://localhost:8091/RestEasyApp/employee/add
/* these type of data u have to pass in add employee
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<employee>
    <id>1</id>
    <name>mithilesh</name>
    <salary>18976.55</salary>
</employee>*/

//      http://localhost:8091/RestEasyApp/employee/1/delete
