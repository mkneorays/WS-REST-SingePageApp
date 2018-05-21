package com.neorays.Jersey2.xBeanParam;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

public class Jersey2XClientGet {

	public static void main(String[] args) {
		String s="http://localhost:8091/Jersey2.xBeanParam/webapi/bean";
		// create client obj
	      Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		// create WebResource obj with request URL
	      WebTarget webTarget = client.target(s);
		// get the builder obj for WebResource
		 Builder builder=webTarget.request(MediaType.APPLICATION_JSON);
		 builder.accept(MediaType.TEXT_PLAIN);
		 
		// Builder builder=web.accept(MediaType.APPLICATION_XML);
		// get ClientResponse obj using builder
		Response response = builder.get();

		String json = response.readEntity(String.class);
		System.out.println(json);
		

	}// main

}// class
