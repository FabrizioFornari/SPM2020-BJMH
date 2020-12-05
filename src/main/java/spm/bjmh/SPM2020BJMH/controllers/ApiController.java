package spm.bjmh.SPM2020BJMH.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spm.bjmh.SPM2020BJMH.models.Driver;
import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {
    // create an instance of driverRepository for access and modify drivers in db
    @Autowired
    DriverRepository driverRepository;

    @PostMapping(value ="/register/driver")
    public Driver registerDriver(@RequestBody Driver driver) {
        driverRepository.save(driver);
        return driver;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable UUID id) {
        driverRepository.delete(driverRepository.findById(id));
    }
}

/*
 firstName;
         lastName;
         licensePlate;
         email;
         password;
         oneNumber;
         n disability;
*/

