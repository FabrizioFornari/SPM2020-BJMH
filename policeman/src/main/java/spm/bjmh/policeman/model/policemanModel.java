package spm.bjmh.policeman.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("policemanModel")
public class policemanModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String Name;
    private String LastName;
    private String idPoliceman;
    private String Username;
    private String Password;
    private String PhoneNumber;
    private String Email;

    public policemanModel(String id, String Name, String LastName, String idPoliceman, String Username, String Password, String PhoneNumber, String Email){
        this.id = id;
        this.Name = Name;
        this.LastName = LastName;
        this.idPoliceman = idPoliceman;
        this.Username = Username;
        this.Password = Password;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
    }

    @Override
    public String toString(){
        return String.format("Policeman[Name='%s', lastName='%s']", Name, LastName);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getIdPoliceman() {
        return idPoliceman;
    }

    public void setIdPoliceman(String idPoliceman) {
        this.idPoliceman = idPoliceman;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
