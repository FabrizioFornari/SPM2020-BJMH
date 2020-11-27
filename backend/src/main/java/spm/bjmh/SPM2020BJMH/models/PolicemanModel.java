package spm.bjmh.SPM2020BJMH.models;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Policeman")
public class PolicemanModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private ObjectId id;
    private String matriculaNumber;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;

    public PolicemanModel() {
    }

    public PolicemanModel(ObjectId id, String matriculaNumber, String email, String firstName, String lastName, String password, String phoneNumber) {
        this.id = id;
        this.matriculaNumber = matriculaNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Driver[licenseNumber=%s, firstName='%s', lastName='%s']", matriculaNumber, firstName,
                lastName);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMatriculaNumber() {
        return matriculaNumber;
    }

    public void setMatriculaNumber(String matriculaNumber) {
        this.matriculaNumber = matriculaNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
