package com.wipro.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.domain.Place;
@Service
public interface PlaceService {
	public List getallplaces();
	public Place getplace(String id);
	public Place addplace(Place place);
	public void updateplace(String id,Place place);
	public String deleteplace(String id);
	
	
	

}
