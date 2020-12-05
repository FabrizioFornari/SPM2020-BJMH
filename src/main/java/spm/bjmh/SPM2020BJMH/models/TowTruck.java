package spm.bjmh.SPM2020BJMH.models;

import spm.bjmh.SPM2020BJMH.Enum.Roles;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TowTruck extends User {
    @NotNull(message = "Vat number must not be null")
    @NotEmpty(message = "Vat number must be not empty")
    private  String vatnumber;



    public TowTruck(String firstname, String lastname, String email, String phone, String username, String password, String vatnumber ) {
        super(firstname, lastname, email, phone, username, password, Roles.ROLE_TOW_TRUCK);
    }

    public String getVatnumber() {
        return vatnumber;
    }

    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }
}