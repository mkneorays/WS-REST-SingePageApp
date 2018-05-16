package com.neorays.test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class Jersey1XClientPassingDataWithUrl {

	public static void main(String[] args) {
		String urljson = "http://localhost:8091/Jersey1.xMaven/product/json?id=121&name=www&price=123212";
		String urlxml = "http://localhost:8091/Jersey1.xMaven/product/xml/123/xxxx/123321";
		String urltext = "http://localhost:8091/Jersey1.xMaven/product/text;id=123;name=wwww;price=9876554";
		Client client = null;
		// create client obj
		client = Client.create();
		// create WebResource obj with request URL
		WebResource web = client.resource(urltext);
		// get the builder obj for WebResource
		// Builder builder=web.accept(MediaType.APPLICATION_JSON);
		// Builder builder=web.accept(MediaType.APPLICATION_XML);
		Builder builder = web.accept("application/text");
		// get ClientResponse obj using builder
		ClientResponse response = builder.get(ClientResponse.class);
		String json = response.getEntity(String.class);
		System.out.println(json);
		System.out.println(response.getStatus() + "  "
				+ response.getStatusInfo());

	}// main

}// class
