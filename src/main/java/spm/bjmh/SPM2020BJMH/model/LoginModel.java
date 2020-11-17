package spm.bjmh.SPM2020BJMH.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("LoginModel")
public class LoginModel {

  private String username;
  private String password;

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
}