package com.neorays.Jersey2.xDemo1;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("textjson")
public class MyResourceTextJson {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("text/{name}")
     @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@PathParam("name") String nam) {
    	System.out.println("text");
        return "Got it!  "+nam;
    }//method
    
    @Path("json1")
	@POST
   //@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Integer fetchInJson1(@QueryParam("id") Integer no) {
		System.out.println("json");
		Product product = new Product();
		product.setId(no);
		product.setName("SAMSUNG");
		product.setPrice(20000);
		return no;
		//return product;
	}// method
    
    @Path("json2")
   	@GET
//   	@Produces("application/json")
      // @Consumes(MediaType.APPLICATION_XML)
   	@Produces(MediaType.APPLICATION_XML)
   	public Product fetchInJson2() {
   		System.out.println("json");
   		Product product = new Product();
   		product.setId(111);
   		product.setName("SAMSUNG");
   		product.setPrice(20000);

   		return product;
   	}// method
	@Path("json")
	@POST
//	@Produces("application/json")
//    @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Product fetchInJson(@DefaultValue("12345") @QueryParam("id") Integer no,
			                                                     @QueryParam("name") String nam) {
		System.out.println("json");
		System.out.println("name="+nam);
		Product product = new Product();
		product.setId(no);
		product.setName(nam);
		product.setPrice(20000);
		return product;
	}// method
	
	@Path("jsonrest")
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String fetchInJsonRest(String json) {
		System.out.println("json");
		System.out.println("name="+json);
		/*Product product = new Product();
		product.setId(no);
		product.setName(nam);
		product.setPrice(20000);
		return product;*/
		return json;
	}// method
}
