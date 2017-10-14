package com.wipro.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.domain.Place;


public interface PlaceRepository extends CrudRepository<Place,String> {

}
