package com.neorays.Jersey2.xBeanParam;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("bean")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	System.out.println("text");
        return "Got it!";
    }
    
    @Path("json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("application/json")
	public Product fetchInJson(@BeanParam  Product p) {
		System.out.println("json");
		Product product = new Product();
		product.setId(p.getId());
		product.setName(p.getName());
		product.setPrice(p.getPrice());
		System.out.println(p);
		return product;
	}// method
    @Path("jsonpost")
   	@POST
   	@Produces(MediaType.APPLICATION_JSON)
   	// @Produces("application/json")
   	public Product fetchInJso(@BeanParam  Product p) {
   		System.out.println("post");
   		Product product = new Product();
   		product.setId(p.getId());
   		product.setName(p.getName());
   		product.setPrice(p.getPrice());
   		System.out.println(p);
   		return product;
   	}// method
}

//    http//localhost:8091/Jersey2.xBeanParam/webapi/bean/json?id=123&name=www&price=0989767
