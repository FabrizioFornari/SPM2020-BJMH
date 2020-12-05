package spm.bjmh.SPM2020BJMH.models.RequestBody;

public class Cred {
    private String email;
    private String password;


    public Cred(){}

    public Cred(String email, String password){
        this.email= email;
        this.password= password;
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


