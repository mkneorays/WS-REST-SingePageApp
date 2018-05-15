package com.neorays.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JerseyClientRestTemplate {

	public static void main(String[] args) {
	   RestTemplate rs=null;
	   
	   String url="http://localhost:8091/Jersey1.x/product/json";
	   String url1="http://localhost:8091/Jersey1.x/product/xml";
	   String  url2 ="http://localhost:8091/Jersey1.xDemo/product/xml";
	   String  url3="http://localhost:8091/Jersey1.xDemo/product/xml";

     //create RestTemplate obj
	   rs=new RestTemplate();
	   //consumes services
       ResponseEntity<String> json=rs.getForEntity(url2, String.class);
       System.out.println(json);
	   
	}//main
}//class
