package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.domain.Place;
import com.wipro.repository.PlaceRepository;
@Service
public class PlaceDbserviceImpl implements PlaceService{
	@Autowired
	PlaceRepository placerepository;

	public List<Place> getallplaces(){
		List<Place> l=(List<Place>) placerepository.findAll();
		
		return l; 
		
	}

	@Override
	public Place getplace(String id) {
	Place place=placerepository.findOne(id);
		
		return place;
	}

	@Override
	public Place addplace(Place place) {
		
		return placerepository.save(place);
		
	}

	@Override
	public void updateplace(String id,Place place) {
		placerepository.save(place);
		
	}

	@Override
	public String deleteplace(String id) {
		placerepository.delete(id);
		return "";
		
	}

}
