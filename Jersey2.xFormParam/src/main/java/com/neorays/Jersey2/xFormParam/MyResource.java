package com.neorays.Jersey2.xFormParam;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public String getIt() {
        return "Got it!";
    }//method
    @Path("data")
    @POST   //only post request will work not others
    @Produces(MediaType.APPLICATION_JSON)
    public Product getFormData(@FormParam("id") Integer name,
    		@FormParam("name") String age,@FormParam("price") Integer add) {
    	 System.out.println(name+"   "+age+"  "+add);
    	Product p=new Product();
    	p.setId(name);
    	p.setName(age);
    	p.setPrice(add);
        return p;
    }//method
    
    
}//class

//   http://localhost:8091/Jersey2.xFormParam/webapi/myresource/data     
//  if u used postman then used form urlencoded to pass form data 
