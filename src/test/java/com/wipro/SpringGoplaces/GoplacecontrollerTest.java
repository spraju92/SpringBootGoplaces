package com.wipro.SpringGoplaces;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.SpringGoplacesApplication;
import com.wipro.domain.Place;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringGoplacesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class GoplacecontrollerTest {

	 	String user1;
	    @LocalServerPort
	    private int port;
	    TestRestTemplate restTemplate = new TestRestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    Place place;
	    @Before
	    public void setUp() throws Exception {
	         place = new Place("1","Ravi","urll","atp");
	    }
	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	    @After
	    public void tearDown() throws Exception {
	    }
	    @Test
	    public void testAddPlace() throws Exception {
	        HttpEntity<Place> entity = new HttpEntity<Place>(place, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/places"),
	                HttpMethod.POST, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        System.out.println(actual);
	        assertEquals("User saved successfully",actual);
	    }
	    @Test
	    public void testList() throws Exception {
	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/places"),
	                HttpMethod.GET, entity, String.class);
	        assertNotNull(response);
	        String actual= response.getBody();
	       
	    }
	    @Test
	    public void testGetPlace() throws Exception {
	    	 HttpEntity<Place> entity = new HttpEntity<Place>(place, headers);
		        ResponseEntity<String> response = restTemplate.exchange(
		                createURLWithPort("/places/3"),
		                HttpMethod.POST, entity, String.class);
		        assertNotNull(response);
		        String actual = response.getBody();
		        assertEquals("Place getting successfully",actual);
	    }
	    @Test
	    public void testUpdatePlace() throws Exception {
	    	HttpEntity<Place> entity = new HttpEntity<Place>(place, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/places/1"),
	                HttpMethod.PUT, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        assertEquals("Place Updated successfully",actual);
	    }
	    @Test
	    public void testDeletePlace() throws Exception {
	    	HttpEntity<Place> entity = new HttpEntity<Place>(place, headers);
	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/places/1"),
	                HttpMethod.DELETE, entity, String.class);
	        assertNotNull(response);
	        String actual = response.getBody();
	        assertEquals("Place Deleted successfully",actual);
	    }
}

