package com.neorays.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

@Path("product")
public class ProductResource {
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
	@POST
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

}// class

// for @QueryParam ->http://localhost:8091/Jersey1.xMaven/product/json?id=121&name=www&price=123212
// for @PathParam ->http://localhost:8091/Jersey1.xMaven/product/xml/123/xxxx/123321
// for @PathParam -> http://localhost:8091/Jersey1.xMaven/product/text;id=123;name=wwww;price=9876554