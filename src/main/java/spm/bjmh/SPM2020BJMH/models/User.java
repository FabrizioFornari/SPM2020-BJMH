package spm.bjmh.SPM2020BJMH.models;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
<<<<<<< HEAD
import spm.bjmh.SPM2020BJMH.Constants.RegexConstants;
=======
>>>>>>> us-2-frontend
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
<<<<<<< HEAD
    @Pattern(regexp=RegexConstants.EMAIL_REGEX, message="Invalid Email format")
    private String email;
    @NotNull(message="Phone must not be null")
    @NotEmpty(message = "Phone must not be empty")
    @Pattern(regexp=RegexConstants.PHONE_REGEX, message="Invalid Phone format")
    private String phone;
    @NotNull(message = "Username must not be null ")
    @NotEmpty(message = "Username must not be empty")
    @NotNull(message="Email must not be null")
    @NotEmpty(message = "Email must not be empty")
    @Pattern(regexp=RegexConstants.USERNAME_REGEX, message="Invalid Username format")
=======
    private String email;
    private String phone;
    @NotNull(message = "Username must not be null ")
    @NotEmpty(message = "Username must not be empty")
>>>>>>> us-2-frontend
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


<<<<<<< HEAD
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(password != null && password != "") {
            this.password = password.trim();
        }
        else {
            throw new IllegalArgumentException("Password is invalid");
        }
    }

    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }

=======
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
>>>>>>> us-2-frontend

    public String getEmail() {
        return email;
    }
<<<<<<< HEAD
    public void setEmail(String email) {
        if(email != null && email != "" &&
                email.matches(RegexConstants.EMAIL_REGEX)) {
            this.email = email;
        }
        else {
            throw new IllegalArgumentException("Email is invalid");
        }
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }



=======

    public void setEmail(String email) {
        this.email = email;
    }

>>>>>>> us-2-frontend
    public String getPhone() {
        return phone;
    }

<<<<<<< HEAD

    public void setPhone(String phone) {
        if(phone != null && phone != "" &&
                phone.matches(RegexConstants.PHONE_REGEX)) {
            this.phone = phone;
        }
        else {
            throw new IllegalArgumentException("Phone is invalid");
        }
    }





    public String getLastName() {
        return lastname;
    }


    public void setLastName(String lastName) {
        if(lastName != null && lastName != "") {
            this.lastname = lastName.trim();
        }
        else {
            throw new IllegalArgumentException("Last name is invalid");
        }
    }


    public String getFirstName() {
        return firstname;
    }


    public void setFirstName(String firstName) {
        if(firstName != null && firstName != "") {
            this.firstname = firstName.trim();
        }
        else {
            throw new IllegalArgumentException("First name is invalid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return(user.getEmail().equals(this.getEmail()) &&
                user.getPassword().equals(this.getPassword()) &&
                user.getRole().equals(this.getRole()));
    }


}
=======
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

>>>>>>> us-2-frontend
