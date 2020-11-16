package spm.bjmh.SPM2020BJMH.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("CarModel")
public class Car {

	private String licence plate;
    
    private String owner;
	
	
	public Car() { }
	
	public Car(String licence plate, String owner) {
		this.licence plate = licence plate;
		
	    this.owner = owner;
	}
	
	public String get licence plate() {
		return licence plate;
	}
	
	public void set licence plate(String licence plate) {
		this.licence plate = licence plate;
	}
	
	
	
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}