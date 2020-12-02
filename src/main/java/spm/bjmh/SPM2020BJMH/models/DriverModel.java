package spm.bjmh.SPM2020BJMH.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document(collection = "driver")
public class DriverModel implements Serializable {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String licensePlate;

    private String email;
    private String password;

    private int phoneNumber;
    private Boolean disability;

    public DriverModel() {
    }

    public DriverModel(String email, String firstName, String lastName, String licensePlate, String password, int phoneNumber, Boolean disability) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.licensePlate = licensePlate;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.disability = disability;
    }

    @Override
    public String toString() {
        return "Driver{" +
                ", firstName='" + firstName + '\'' +
                ", licensePlate=" + licensePlate +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getDisability() {
        return disability;
    }

    public void setDisability(Boolean disability) {
        this.disability = disability;
    }
}