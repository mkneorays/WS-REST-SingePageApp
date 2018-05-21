package com.neorays.test.ResponseProject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.neorays.beans.Product;

public class Jersey2XClient {

	public static void main(String[] args) {
		  String url1="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource";
	       String url2="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/json?id=111&name=www&price=2322";
			String url3= "http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/json1?id=111&name=www&price=2322";
	     String url4="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/jsonxml?id=111&name=www&price=2322";
	 	
		// create client obj
	      Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		// create WebResource obj with request URL
	      //WebTarget webTarget = client.target(url1);
	    // WebTarget webTarget = client.target(url2);
	     WebTarget webTarget = client.target(url3);//not working
	     // WebTarget webTarget = client.target(url4);  //not working
		// get the builder obj for WebResource
		 Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
		 builder.accept(MediaType.APPLICATION_JSON);
		 Product product = new Product();
			product.setId(111);
			product.setName("wwww");
			product.setPrice(43343);
		// get ClientResponse obj using builder
	//	Response response = builder.get();  //for url1 and url2
		Response response = builder.post(Entity.entity(product, MediaType.APPLICATION_JSON),Response.class);
		//Response response =builder.post(Entity.entity(entity, mediaType))
		String json = response.readEntity(String.class);
		System.out.println(json);
		

	}// main

}// class
