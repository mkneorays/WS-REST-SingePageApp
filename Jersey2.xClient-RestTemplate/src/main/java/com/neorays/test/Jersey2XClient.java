package com.neorays.test;

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
		String s="http://localhost:8091/Jersey2.xBeanParam/webapi/bean/jsonpost";
		String ss="http://localhost:8091/Jersey2.xBeanParam/webapi/bean/jsonpost?id=123&name=www&price=0989767";
		
		// create client obj
	      Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		// create WebResource obj with request URL
	      WebTarget webTarget = client.target(ss);
		// get the builder obj for WebResource
		 Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
		 builder.accept(MediaType.APPLICATION_JSON);
		 Product product = new Product();
			product.setId(111);
			product.setName("wwww");
			product.setPrice(43343);
		// get ClientResponse obj using builder
		//Response response = builder.get();
		Response response = builder.post(Entity.entity(product, MediaType.APPLICATION_JSON),Response.class);

		String json = response.readEntity(String.class);
		System.out.println(json);
		

	}// main

}// class
