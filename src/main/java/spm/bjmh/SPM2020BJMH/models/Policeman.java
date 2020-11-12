package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;

public class Policeman {
    @Id
    private int id;
    private String username;
    private String password;
    private String address;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
