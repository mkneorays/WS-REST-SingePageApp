package com.neorays.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

@Path("product")
public class ProductResource {
	@Path("json")
	@GET
	@Produces("application/json")
	public Product fetchInJson() {
		System.out.println("json");
		Product product = new Product();
		product.setId(100);
		product.setName("SAMSUNG");
		product.setPrice(20000);
		return product;
	}// method
	
	@Path("xml")
	@GET
	@Produces("application/xml")
	public Product fetchInXml() {
		System.out.println("xml");

		Product product = new Product();
		product.setId(200);
		product.setName("APPLE");
		product.setPrice(50000);
		return product;
	}// method
}// class
