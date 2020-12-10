package spm.bjmh.SPM2020BJMH.models;

import org.hibernate.validator.constraints.NotEmpty;

import spm.bjmh.SPM2020BJMH.Constants.RegexConstants;

import spm.bjmh.SPM2020BJMH.Enum.Roles;

import javax.validation.constraints.NotNull;

public class Driver extends User{

    @NotNull(message = "Plate must not be null")
    @NotEmpty(message = "Plate must not be empty")
    private  String plate;



    public Driver(String firstname, String lastname, String email, String phone, String username, String password, String plate) {
        super(firstname, lastname, email, phone, username, password, Roles.ROLE_DRIVER);
        this.plate= plate;
    }
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {

        if(plate != null && plate != "" &&
                plate.matches(RegexConstants.PLATE_REGEX)) {
            this.plate = plate;
        }
        else {
            throw new IllegalArgumentException("Plate is invalid");

        }
    }


    }

        this.plate = plate;
    }
}






