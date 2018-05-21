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

public class JerseyClientRestTemplate {

	public static void main(String[] args) {
	   RestTemplate rs=null;
	   
	   String url="http://localhost:8091/Jersey2.xDemo/book/json";
	   String url1="http://localhost:8091/Jersey2.xDemo/book/xml";
       String u="http://localhost:8091/Jersey2.xDemo1/webapi/textjson/json2";
/* Map map1=new HashMap<String,Object>();
 map1.put("name","www");*/
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
      map.add("name","www");
      
       HttpEntity<MultiValueMap<String, String>> requestEntity= 
               new HttpEntity<MultiValueMap<String, String>>(map, headers);
     //create RestTemplate obj
	   rs=new RestTemplate();
	   //consumes services
      ResponseEntity<String> json=rs.getForEntity(u, String.class);
     //  ResponseEntity<String> json=rs.postForEntity(u, map, String.class);
                             //    System.out.println(rs.postForEntity(u, requestEntity, String.class));
       System.out.println(json);
	   
	}//main
}//class
