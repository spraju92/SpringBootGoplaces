package com.wipro.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.domain.Place;

public class PlaceServiceImpl implements PlaceService {
	List<Place> places=new ArrayList<>(Arrays.asList(
			new Place("1","raju","atp","url1"),
			new Place("2","sai","btm","url2"),
			new Place("3","nani","silkboard","url3")));
	
	
	public List<Place> getallplaces(){
		
		return places;
		
	}
	public Place getplace(String id) {
		
		return (Place) places.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}
	public Place addplace(Place place) {
		places.add(place);
		return place;
		
	}
	public void updateplace(String id,Place place) {
		for(int i=0;i<places.size();i++) {
			Place t=places.get(i);
			if(t.getId().equals(id)) {
				places.set(i, place);
			}
		}
	}
	public String deleteplace(String id) {
		places.removeIf(t -> t.getId().equals(id));
		return id;
	}

}
