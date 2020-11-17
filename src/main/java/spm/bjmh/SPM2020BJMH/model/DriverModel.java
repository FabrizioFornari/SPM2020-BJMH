package spm.bjmh.SPM2020BJMH.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("DriverModel")
public class DriverModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String licenseNumber;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private int phoneNumber;
    private Boolean disability;

    public DriverModel() {

    }

    public DriverModel(String email, String name, String lastName, String licenseNumber, String password,
            int phoneNumber, Boolean disability) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.disability = disability;
    }

    @Override
    public String toString() {
        return String.format("Driver[licenseNumber=%s, firstName='%s', lastName='%s']", licenseNumber, name, lastName);
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

    public String getlicenceNumber() {

        return licenseNumber;
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

    public Boolean getDisability() {
        return disability;
    }

    public void setDisability(Boolean disability) {
        this.disability = disability;
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

    public void setlicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

}