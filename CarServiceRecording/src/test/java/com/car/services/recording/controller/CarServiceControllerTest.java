package com.car.services.recording.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.car.services.recording.entity.Customer;
import com.car.services.recording.model.Details;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CarServiceControllerTest {

	@LocalServerPort
    int randomServerPort;

	@MockBean
	private CarServiceController carServiceController;


	@Autowired
	WebApplicationContext webApplicationContext;


	@Test
	public void allCustomerDataTest() throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/customers/";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, null);
         
        Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void createRecord() throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/recordCarService/";
        URI uri = new URI(baseUrl);
        Details details = new Details();
		details.setCarName("hummer");
		details.setCarNo("c400");
		details.setCustomerName("joker");
		details.setCustomerPhone(100);  
		
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<Details> request = new HttpEntity<>(details, headers);
         
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void getCustomerDetails() throws Exception{
		
		RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/allCar4Customer?custPhone=123456";
        URI uri = new URI(baseUrl);
		
        HttpHeaders headers = new HttpHeaders();
//        headers.set("custPhone", "12345");
 
        HttpEntity<Customer> requestEntity = new HttpEntity<>(null, headers);
 
        try
        {
          ResponseEntity<?> entity =   restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
	}
	
	@Test
	public void getCarDetails() throws Exception{
		
		RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/allService4Car?carNo=c11";
        URI uri = new URI(baseUrl);
		
        HttpHeaders headers = new HttpHeaders();
//        headers.set("custPhone", "12345");
 
        HttpEntity<Customer> requestEntity = new HttpEntity<>(null, headers);
 
        try
        {
          ResponseEntity<?> entity =   restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Object.class);
        }
        catch(HttpClientErrorException ex) 
        {
            //Verify bad request and missing header
            Assertions.assertEquals(400, ex.getRawStatusCode());
            Assertions.assertEquals(true, ex.getResponseBodyAsString().contains("Missing request header"));
        }
	}

}
