package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.domain.Place;


import com.wipro.service.PlaceService;

import java.util.*;
@RestController

public class GoplaceController {
	@Autowired
	private PlaceService placeservice;
	
	@RequestMapping("/places")
	public ResponseEntity<List<Place>> getallPlaces() {
		
		return ResponseEntity.ok( placeservice.getallplaces());
		
	}
	@RequestMapping("/places/{id}")
	public ResponseEntity<String> getplace(@PathVariable String id) {
		placeservice.getplace(id);
		return ResponseEntity.ok("Place getting successfully");
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/places")
	public ResponseEntity<String> addplace(@RequestBody Place place) {
		
		placeservice.addplace(place);
		return ResponseEntity.ok("User saved successfully");
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/places/{id}")
	public ResponseEntity<String> updateplace(@RequestBody Place place, @PathVariable String id) {
		
		placeservice.updateplace(id,place);
		return ResponseEntity.ok("Place Updated successfully");
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/places/{id}")
	public ResponseEntity<String> deleteplace(@PathVariable String id) {
		
		 placeservice.deleteplace(id);
		 
		 return ResponseEntity.ok("Place Deleted successfully");
	}

}
