package spm.bjmh.SPM2020BJMH.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DriverModel {
    @Id
    private String id;
    private String email;
    private String name;
    private  String password;
    private int phoneNumber;
    private String licensePlate;
    private Boolean handicap;
    private Date creationDate = new Date();
    private Map<String, String> driverSettings = new HashMap<>();
    //private Set<PaymentMethod> paymentMethod;

    public DriverModel() {}

    public DriverModel(String id, String email, String name, String password, int phoneNumber, String licensePlate, Boolean handicap) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.licensePlate = licensePlate;
        this.handicap = handicap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Boolean getHandicap() {
        return handicap;
    }

    public void setHandicap(Boolean handicap) {
        this.handicap = handicap;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getDriverSettings() {
        return driverSettings;
    }

    public void setDriverSettings(Map<String, String> driverSettings) {
        this.driverSettings = driverSettings;
    }
}
