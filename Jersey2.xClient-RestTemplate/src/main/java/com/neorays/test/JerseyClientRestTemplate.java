package com.neorays.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JerseyClientRestTemplate {

	public static void main(String[] args) {
	   RestTemplate rs=null;
	   
	   String url="http://localhost:8091/Jersey2.xDemo/book/json";
	   String url1="http://localhost:8091/Jersey2.xDemo/book/xml";


     //create RestTemplate obj
	   rs=new RestTemplate();
	   //consumes services
       ResponseEntity<String> json=rs.getForEntity(url, String.class);
       System.out.println(json);
	   
	}//main
}//class
