package spm.bjmh.SPM2020BJMH.models.RequestBody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangeEmail {
    @NotNull(message = "Current email must not be null")
    @NotEmpty(message ="Current email must not be empty" )
    private String currentEmail;
    @NotNull(message = "New email must not be null")
    @NotEmpty(message = "New email must not be empty")
    private String newEmail;

    public ChangeEmail(){}


    public ChangeEmail(String currentEmail, String newEmail){
        this.setCurrentEmail(currentEmail);
        this.setNewEmail(newEmail);

    }
    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }



    }

