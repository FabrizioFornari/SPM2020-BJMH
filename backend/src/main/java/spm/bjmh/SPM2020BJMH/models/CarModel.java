package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("car")

public class CarModel {

	private String id;
	private String cod;
	private String owner;

	public CarModel() {
	}

	public CarModel(String id, String cod, String owner) {
		this.id = id;
		this.cod = cod;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Document("PolicemanModel")
	public static class PolicemanModel implements Serializable {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		@Id
		private String matriculaNumber;
		private String email;
		private String name;
		private String lastName;
		private String password;
		private int phoneNumber;
	
		public PolicemanModel() {
	
		}
	
		public PolicemanModel(String email, String name, String lastName, String matriculaNumber, String password,
				int phoneNumber) {
			this.email = email;
			this.name = name;
			this.lastName = lastName;
			this.matriculaNumber = matriculaNumber;
			this.password = password;
			this.phoneNumber = phoneNumber;
	
		}
	
		@Override
		public String toString() {
			return String.format("Policeman[matriculaNumber=%s, firstName='%s', lastName='%s']", matriculaNumber, name,
					lastName);
		}
	
		public String getEmail() {
			return email;
		}
	
		public String getName() {
			return name;
		}
	
		public String getLastName() {
			return lastName;
		}
	
		public String getmatriculaNumber() {
	
			return matriculaNumber;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public String getPassword() {
			return password;
		}
	
		public int getPhoneNumber() {
			return phoneNumber;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public void setPassword(String password) {
			this.password = password;
		}
	
		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	
		public void setlmatriculaNumber(String matriculaNumber) {
			this.matriculaNumber = matriculaNumber;
		}
	
	}
}