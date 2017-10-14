package com.wipro.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Place {
	@Id
	String id;
	String name;
	String Address;
	String url;
	
	public Place() {
		
	}
	
	public Place(String id, String name, String address, String url) {
		super();
		this.id = id;
		this.name = name;
		this.Address=address;
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
