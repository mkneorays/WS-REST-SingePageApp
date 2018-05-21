package com.neorays.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.neorays.beans.Product;

public class JerseyClientRestTemplateWithJavaObject {

	public static void main(String[] args) {
	   RestTemplate rs=null;
	   
	   String url="http://localhost:8091/Jersey2.xDemo/book/json";
	   String url1="http://localhost:8091/Jersey2.xDemo/book/xml";
       String u="http://localhost:8091/Jersey2.xDemo1/webapi/textjson/jsonrest";
        Product p=new Product();
        p.setId(111);p.setName("xxxxx");
        p.setPrice(545345);
        rs=new RestTemplate();
      //ResponseEntity<String> json=rs.getForEntity(u, String.class);
       ResponseEntity<String> json=rs.postForEntity(u, p, String.class);
                              //   System.out.println(rs.postForEntity(u, p, String.class));
       System.out.println(json);
	   
	}//main
}//class
