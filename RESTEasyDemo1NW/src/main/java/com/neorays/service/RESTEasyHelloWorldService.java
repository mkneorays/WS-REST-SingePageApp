package com.neorays.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.neorays.beans.Product;

@Path("product")
public class RESTEasyHelloWorldService {

	@Path("json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/json")
	public Product fetchInJson(@QueryParam("id") Integer Id,
			@QueryParam("name") String Name, @QueryParam("price") Integer Price) {
		System.out.println("json");
		Product product = new Product();
		product.setId(Id);
		product.setName(Name);
		product.setPrice(Price);
		return product;
	}// method

	@Path("xml/{id}/{name}/{price}")
	@GET
	@Produces("application/xml")
	// both r working
	// @Produces(MediaType.APPLICATION_XML)
	public Product fetchInXml(@PathParam("id") Integer Id,
			@PathParam("name") String Name, @PathParam("price") Integer Price) {
		System.out.println("xml");

		Product product = new Product();
		product.setId(Id);
		product.setName(Name);
		product.setPrice(Price);
		return product;
	}// method

	@Path("text")
	@GET
	@Produces("application/text")
	public String fetchInText(@MatrixParam("id") Integer Id,
			@MatrixParam("name") String Name, @MatrixParam("price") Integer Price) {
		System.out.println("TEXT");
		Product product = new Product();
		product.setId(Id);
		product.setName(Name);
		product.setPrice(Price);
		System.out.println(product);
		return "welcome to webservice";
	}// method
	/*@GET
	@Path("/{pathParameter}")
	public Response responseMsg(
			@PathParam("pathParameter") String pathParameter,

			@DefaultValue("Nothing to say") 
			@QueryParam("queryParameter") String queryParameter) {
	  System.out.println("service");
		String response = "Hello from: " + pathParameter + " : "
				+ queryParameter;

		return Response.status(200).entity(response).build();

	}// method
*/}// class

//for @QueryParam ->http://localhost:8091/RESTEasyDemo/nit/product/json?id=121&name=www&price=123212    //not working   bcoz of jar
//for @PathParam ->http://localhost:8091/RESTEasyDemo/nit/product/xml/123/xxxx/123321       //not working bcoz of jar
//for @MatrixParam -> http://localhost:8091/RESTEasyDemo/nit/product/text;id=123;name=wwww;price=9876554    //working

//http://localhost:8091/RESTEasyDemo/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy