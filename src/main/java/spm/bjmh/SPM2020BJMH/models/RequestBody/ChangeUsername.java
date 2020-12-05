package spm.bjmh.SPM2020BJMH.models.RequestBody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangeUsername {
    @NotNull(message = "Current username must not be null")
    @NotEmpty(message ="Current username must not be empty" )
    private String currentUsername;
    @NotNull(message = "New username must not be null")
    @NotEmpty(message = "New username must not be empty")
    private String newUsername;

    public ChangeUsername(){}


    public ChangeUsername(String currentUsername, String newUsername){
        this.setCurrentUsername(currentUsername);
        this.setNewUsername(newUsername);

    }
    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newEmail) {
        this.newUsername = newUsername;
    }



}



