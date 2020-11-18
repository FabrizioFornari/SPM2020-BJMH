package spm.bjmh.policeman.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document("LoginModel")
public class loginModel {

    private String Username;
    private String Password;

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
}
