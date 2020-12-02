package spm.bjmh.SPM2020BJMH.models.RequestBody;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ChangePlate {
    @NotNull(message = "Current plate must not be null")
    @NotEmpty(message ="Current plate must not be empty" )
    private String currentPlate;
    @NotNull(message = "New plate must not be null")
    @NotEmpty(message = "New plate must not be empty")
    private String newPlate;

    public ChangePlate(){}


    public ChangePlate(String currentPlate, String newPlate){
        this.setCurrentPlate(currentPlate);
        this.setNewPlate(newPlate);

    }




    public String getCurrentPlate() {
        return currentPlate;
    }

    public void setCurrentPlate(String currentPlate) {
        this.currentPlate = currentPlate;
    }

    public String getNewPlate() {
        return newPlate;
    }

    public void setNewPlate(String newPlate) {
        this.newPlate = newPlate;
    }



}



