package spm.bjmh.SPM2020BJMH.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spm.bjmh.SPM2020BJMH.models.DriverModel;
import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/")
    public String react() {
        return "index";
    }
    // create an instance of driverRepository for access and modify drivers in db
    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/drivers")
    Collection<DriverModel> groups() {
        return driverRepository.findAll();
    }
    @PostMapping(value ="/register/driver")
    public DriverModel registerDriver(@RequestBody DriverModel driver) {
        driver.set_id(ObjectId.get());
        driverRepository.save(driver);
        return driver;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable ObjectId id) {
        driverRepository.delete(driverRepository.findBy_id(id));
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

