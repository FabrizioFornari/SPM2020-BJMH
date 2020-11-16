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
 71  src/main/java/spm/bjmh/SPM2020BJMH/model/PaymentModel.java 
@@ -1,71 +0,0 @@
package spm.bjmh.SPM2020BJMH.model;	

import org.springframework.data.annotation.Id;	
import org.springframework.data.mongodb.core.mapping.Document;	

import java.io.Serializable;	

@Document("PaymentModel")	

public class Payment {	


	private String id;	
	private double price;	
	private long emission;	
	private long life;	
	private String parking;	


	public Payment() { }	

	public Payment(String id, double price, long emission, long life, String parking) {	
		super();	
		this.id = id;	
		this.price = price;	
		this.emission = emission;	
		this.life = life;	
		this.parking = parking;	
	}	

	public String getId() {	
		return id;	
	}	

	public void setId(String id) {	
		this.id = id;	
	}	

	public double getPrice() {	
		return price;	
	}	

	public void setPrice(double price) {	
		this.price = price;	
	}	

	public long getEmission() {	
		return emission;	
	}	

	public void setEmission(long emission) {	
		this.emission = emission;	
	}	

	public long getLife() {	
		return life;	
	}	

	public void setLife(long life) {	
		this.life = life;	
	}	

	public String getParking() {	
		return parking;	
	}	

	public void setParking(String parking) {	
		this.parking = parking;	
	}	

} 