/*package com.neorays.test;

import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.neorays.beans.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class Jersey1XClientPassingDataWithoutUrl {

 * be carefull
 * not working
 * 
 * 
	public static void main(String[] args) throws JAXBException {
		String urljson = "http://localhost:8091/Jersey1.xMaven/product/json";
		String urlxml = "http://localhost:8091/Jersey1.xMaven/product/xml";
		String urltext = "http://localhost:8091/Jersey1.xMaven/product/text";
		Client client = null;
		// create client obj
		client = Client.create();
		// create WebResource obj with request URL
		WebResource web = client.resource(urlxml);
		// get the builder obj for WebResource
		// Builder builder=web.accept(MediaType.APPLICATION_JSON);
		 Builder builder=web.accept(MediaType.APPLICATION_XML);
		//Builder builder = web.accept("application/text");
		 Product product = new Product();
			product.setId(100);
			product.setName("mithu");
			product.setPrice(54321);
		  JAXBContext jaxb=JAXBContext.newInstance(Product.class);
		  Marshaller mar=jaxb.createMarshaller();
		  StringWriter sw=new StringWriter();
		  mar.marshal(product, sw);
		  String xml=sw.toString();
		  
		// get ClientResponse obj using builder
		ClientResponse response = builder.post(ClientResponse.class, xml);
		String json = response.getEntity(String.class);
		System.out.println(json);
		System.out.println(response.getStatus() + "  "
				+ response.getStatusInfo());

	}// main

}// class
*/