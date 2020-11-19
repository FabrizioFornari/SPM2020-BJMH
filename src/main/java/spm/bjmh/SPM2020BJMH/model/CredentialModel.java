package spm.bjmh.SPM2020BJMH.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document("CredentialModel")
public class CredentialModel implements Serializable{

    /**
     *
     */
    @Id
     private static final long serialVersionUID = 1L;

     private String email;
     private String password;
     
     public CredentialModel() {}
     
     public CredentialModel(String email, String password) {
         this.email = email;
         this.password = password;
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
 }

