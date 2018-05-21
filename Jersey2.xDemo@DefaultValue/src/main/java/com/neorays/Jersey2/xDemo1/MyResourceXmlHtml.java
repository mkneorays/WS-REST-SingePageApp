package com.neorays.Jersey2.xDemo1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("xmlhtml")
public class MyResourceXmlHtml {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@Path("xml")
	@GET
	//@Produces("application/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Product fetchInXml() {
		System.out.println("xml");

		Product product = new Product();
		product.setId(200);
		product.setName("APPLE");
		product.setPrice(50000);
		return product;
	}// method
    
	@Path("html")
	@GET
//	@Produces("application/json")
	@Produces(MediaType.TEXT_HTML)
	public Product fetchInJson() {
		System.out.println("html");
		Product product = new Product();
		product.setId(100);
		product.setName("SAMSUNG");
		product.setPrice(20000);
		return product;
	}// method
}
