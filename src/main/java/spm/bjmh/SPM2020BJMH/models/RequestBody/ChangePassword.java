package spm.bjmh.SPM2020BJMH.models.RequestBody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePassword {
    @NotNull(message = "Current password must not be null")
    @NotEmpty(message ="Current password must not be empty" )
    private String currentPassword;
    @NotNull(message = "New password must not be null")
    @NotEmpty(message = "New password must not be empty")
    private String newPassword;

    public ChangePassword(){}


    public ChangePassword(String currentPassword, String newPassword){
        this.setCurrentPassword(currentPassword);
        this.setNewPassword(newPassword);

    }
    public String getCurrentEmail() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }



}



