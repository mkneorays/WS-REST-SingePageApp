package ind.neorays.service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.neorays.beans.Product;

@Path("book")
public class BookService {
	@Path("json")
	@GET
//	@Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Product fetchInJson() {
		System.out.println("json");
		Product product = new Product();
		product.setId(100);
		product.setName("SAMSUNG");
		product.setPrice(20000);
		return product;
	}// method

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
}

// for @QueryParam
// ->http://localhost:8091/Jersey1.xMaven/product/json?id=121&name=www&price=123212
// for @PathParam
// ->http://localhost:8091/Jersey1.xMaven/product/xml/123/xxxx/123321
// for @PathParam ->
// http://localhost:8091/Jersey1.xMaven/product/text;id=123;name=wwww;price=9876554