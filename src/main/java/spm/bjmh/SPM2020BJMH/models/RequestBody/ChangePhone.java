package spm.bjmh.SPM2020BJMH.models.RequestBody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePhone {
    @NotNull(message = "Current phone must not be null")
    @NotEmpty(message ="Current phone must not be empty" )
    private String currentPhone;
    @NotNull(message = "New phone must not be null")
    @NotEmpty(message = "New phone must not be empty")
    private String newPhone;

    public ChangePhone(){}


    public ChangePhone(String currentPhone, String newPhone){
        this.setCurrentPhone(currentPhone);
        this.setNewPhone(newPhone);

    }
    public String getCurrentPhone() {
        return currentPhone;
    }

    public void setCurrentPhone(String currentPhone) {
        this.currentPhone = currentPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }



}





