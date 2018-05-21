package com.neorays.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.neorays.beans.Product;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getIt() {
    	System.out.println("text plain");
    	
        return  Response.status(200).entity("Mithilesh").build();
    }//method
    
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
    @Path("json1")
   @POST
   	@Produces(MediaType.APPLICATION_JSON)
   	// @Produces("application/json")
   	public Response fetchInJso(@BeanParam  Product p) {
   /*	public Response fetchInJsonRes(@QueryParam("id") Integer Id,
   			@QueryParam("name") String Name, @QueryParam("price") Integer Price) {*/
   		System.out.println("product");
   		Product product = new Product();
   		product.setId(p.getId());
   		product.setName(p.getName());
   		product.setPrice(p.getPrice());
   		System.out.println(p);
   		System.out.println(product);
        return  Response.status(200).entity(product).build();
   	}// method
    @Path("jsonxml")
    @POST
    	@Produces(MediaType.APPLICATION_XML)
    	// @Produces("application/json")
    	public Response fetchInJsonResXml(@QueryParam("id") Integer Id,
    			@QueryParam("name") String Name, @QueryParam("price") Integer Price) {
    		System.out.println("product");
    		Product product = new Product();
    		product.setId(Id);
    		product.setName(Name);
    		product.setPrice(Price);
    		System.out.println(product);
         return  Response.status(200).entity(product).build();
    	}// method
    
}//class
