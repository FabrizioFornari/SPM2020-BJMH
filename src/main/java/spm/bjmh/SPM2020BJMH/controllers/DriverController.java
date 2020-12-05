package spm.bjmh.SPM2020BJMH.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spm.bjmh.SPM2020BJMH.models.Driver;
import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;
import spm.bjmh.SPM2020BJMH.repositories.UserRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("management/driver")
@CrossOrigin(origins = "*")
public class DriverController {

    private static final List<Driver> STUDENTS = Arrays.asList(
            new Driver("1", "t", "t", "455678", "mi.pe@gmail.com", "6tyuunk", 345678, false),
            new Driver("2", "t", "t", "455678", "mi.pe@gmail.com", "6tyuunk", 345678, false),
            new Driver("3", "t", "t", "455678", "mi.pe@gmail.com", "6tyuunk", 345678, false)
    );


    private UserRepository userRepository;
    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

/*
    @GetMapping(path="/{driverId")
    public String getDrivers(@PathVariable("driverId") String driverId) {
        int studentId = Integer.parseInt(driverId);
        return STUDENTS.stream().filter(student -> studentId.equals(student.getId())).findFirst().orElseThrow(() -> new IllegalStateException(("FUCK")));
    }
    */

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewDriver(@RequestBody Driver driver) {
        System.out.println("registerNewDriver");
        System.out.println(driver);
    }

    @DeleteMapping(path = "{driverId}")
    @PreAuthorize("hasAuthority('driver:write')")
    public void deleteDriver(@PathVariable("driverId") UUID driverId) {
        System.out.println("deleteDriver");
        System.out.println(driverId);
    }

    @PutMapping(path = "{driverId}")
    @PreAuthorize("hasAuthority('driver:write')")
    public void updateDriver(@PathVariable("driverId") UUID driverId, @RequestBody Driver driver) {
        System.out.println("updateStudent");
        System.out.println(String.format("%s %s", driverId, driver));
    }

    /* post api registration */
    /*
    @PostMapping(value="/registration",consumes = "application/json" )
    public void registration(Driver driver) {
        //userRepository.save(driver);
        driverRepository.save(driver);
    }

    @RequestMapping("/drivers")
    public String getDrivers(Model model) {
        model.addAttribute("driver", driverRepository.findAll());
        return "driver/list";
    }

     */
}

