package spm.bjmh.SPM2020BJMH.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document("TowTruckCompany")
public class TowTruckCompanyModel implements Serializable {
    @Id
    private String name;
    private String vatNumber;
    private String email;
    private String password;
    private int phoneNumber;


    public TowTruckCompanyModel() {

    }

    public TowTruckCompanyModel(String email, String password, int phoneNumber) {

        this.name = name;
        this.email = email;
        this.vatNumber = vatNumber;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return String.format(
                "Company[VAT number=%s, Name='%s']",
                vatNumber, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
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
}
