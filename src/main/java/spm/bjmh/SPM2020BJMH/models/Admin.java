package spm.bjmh.SPM2020BJMH.models;

public class Admin {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;


        // Constructor//

    public Admin() {

    }

      // Accessory Methods//


     String getFirstname() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
