package spm.bjmh.SPM2020BJMH.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import spm.bjmh.SPM2020BJMH.Enum.Roles;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Document("UserModels")
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = " First name must be not null")
    @NotEmpty(message =" First name must be not empty")
    private String firstname;
    @NotNull(message = "Last name must not be null")
    @NotEmpty(message = "Last name must be not empty")
    private String lastname;
    @NotNull(message = "Email must be not null ")
    @NotEmpty(message = "Email must be not empty")
    private String email;
    private String phone;
    @NotNull(message = "Username must not be null ")
    @NotEmpty(message = "Username must not be empty")
    private String username;
    @NotNull(message = "Password must not be null")
    @NotEmpty(message = "Password must not be empty")
    @Length(min = 6, message ="Password must be at least 6 characters" )
    private String password;
    private Roles role;

    public  User (String firstname, String lastname, String email, String phone, String username, String password,
                              Roles role){
        this.firstname= firstname;
    this.lastname= lastname;
    this.email= email;
    this.phone= phone;
    this.username= username;
    this.password= password;
    this.role= role;

    }



    /*ACCESSORY METHODS  */


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}

