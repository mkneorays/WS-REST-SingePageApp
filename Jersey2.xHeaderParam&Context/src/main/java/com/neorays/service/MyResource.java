package com.neorays.service;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.neorays.beans.Product;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("product")
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
    }
    @Path("json")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	// @Produces("application/json")
	public Response fetchInJs(@HeaderParam("user-agent") String browser) {
		System.out.println("json "+browser);
		
		return Response.status(200).entity(browser).build();
	}// method
    
    @Path("json1")
   	@GET
   	public Response fetchInJson(@Context  HttpHeaders browser) {
   		String ss=browser.getRequestHeader("user-agent").get(0);
   		System.out.println(ss+"  json "+browser);

   		return Response.status(200).entity(ss).build();
   	}// method
    
    @Path("json2")
   	@GET
   	public Response getAllHeaders(@Context  HttpHeaders browser) {
    	MultivaluedMap<String,String>  map=browser.getRequestHeaders();
    	Set<String> keys=map.keySet();
    	for(String k:keys){
    		System.out.println("Header name "+k);
    		List<String> headerValues=browser.getRequestHeader(k);
			for(String header:headerValues){
				System.out.println("inner loop  "+header);
    		}//inner for loop
    		
    	}//outer for loop
    	
   		String ss=browser.getRequestHeader("user-agent").get(0);
   		System.out.println(ss+"  json "+browser);

   		return Response.status(200).build();
   	}// method

}

//   http://localhost:8091/Jersey2.xHeaderParam/webapi/product/json
/*
 * 
 * output will come
 */
//Header name host
//inner loop  localhost:8091
//Header name connection
//inner loop  keep-alive
//Header name cache-control
//inner loop  no-cache
//Header name content-type
//inner loop  application/x-www-form-urlencoded
//Header name user-agent
//inner loop  Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
//Header name postman-token
//inner loop  5951af2c-c0c7-19a0-2c00-d481328cfe74
//Header name accept
//inner loop  
//Header name accept-encoding
//inner loop  gzip, deflate, br
//Header name accept-language
//inner loop  en-US,en;q=0.9
//Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36  json org.glassfish.jersey.server.ContainerRequest@372b07ae
