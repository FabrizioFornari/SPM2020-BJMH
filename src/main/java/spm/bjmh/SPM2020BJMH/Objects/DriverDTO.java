package spm.bjmh.SPM2020BJMH.Objects;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DriverDTO {
    @NotBlank(message = "Enter your firstname")
    private String firstName;
    @NotBlank(message = "Enter your lastname")
    private String lastName;
    @NotBlank(message = "Enter your licenseplate")
    private String licensePlate;
    @NotBlank(message = "Enter your valid email")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Enter your password")
    @Length(min = 6 , message = "Password mut be at least 6 characters")
    private String password;
    @NotBlank(message = "Enter yor phonenumber")
    private int phoneNumber;
    @NotBlank(message = "Enter your disability permission")
    private Boolean disability;




    public DriverDTO(){

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


    @Override
    public String toString() {
        return "DriverDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", disability=" + disability +
                '}';
    }
}


