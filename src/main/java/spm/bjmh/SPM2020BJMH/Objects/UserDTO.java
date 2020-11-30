package spm.bjmh.SPM2020BJMH.Objects;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email")
    private String email;
    @NotBlank(message = "Enter your password")
    @Length(min= 6, message = "Passwords must be ta least 6 characters")
    private String password;
    @NotBlank(message = "Re-enter your password")
    private String rpassword;
    @NotBlank(message = "Enter your first name")
    private String firstname;
    @NotBlank(message = "Enter your lastname")
    private String lastname;


    public UserDTO(){

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

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rpassword='" + rpassword + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

