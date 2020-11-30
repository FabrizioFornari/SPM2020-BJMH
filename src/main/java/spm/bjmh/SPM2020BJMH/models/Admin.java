package spm.bjmh.SPM2020BJMH.models;

import spm.bjmh.SPM2020BJMH.Enum.Roles;

public class Admin extends User {
    public Admin(String firstname, String lastname, String email, String phone, String username, String password, Roles role) {
        super(firstname, lastname, email, phone, username, password, Roles.ROLE_ADMIN);
    }
}
