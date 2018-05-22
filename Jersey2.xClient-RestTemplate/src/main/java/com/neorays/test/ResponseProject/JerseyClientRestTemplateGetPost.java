package com.neorays.test.ResponseProject;

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

public class JerseyClientRestTemplateGetPost{

	public static void main(String[] args) {
	   RestTemplate rs=null;
	   
	   String url1="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource";
      String url2="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/json?{id}&{name}&{price}";
      // String url2="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/json?id=111&name=www&price=2322";
       String url5="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/xml/{id}/{name}/{price}";
       String url3= "http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/json1?id=111&name=www&price=2322";
     String url4="http://localhost:8091/Jersey2.xResponseClass/webapi/myresource/jsonxml?id=111&name=www&price=2322";
        Product p=new Product();
        p.setId(111);p.setName("xxxxx");
        p.setPrice(545345);
        rs=new RestTemplate();
        Map<String,Object> map=new HashMap();
        map.put("id", "111");
        map.put("name", "wwww");
        map.put("price", "54321");
   //  ResponseEntity<String> json=rs.getForEntity(url1, String.class);
     ResponseEntity<String> json=rs.getForEntity(url5, String.class,map);
     //  ResponseEntity<String> json=rs.postForEntity(url3, p, String.class);
      // ResponseEntity<String> json=rs.postForEntity(url4, p, String.class);

       System.out.println(json);
	   
	}//main
}//class
