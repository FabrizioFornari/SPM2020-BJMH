package spm.bjmh.SPM2020BJMH.controllers;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spm.bjmh.SPM2020BJMH.models.Driver;
import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;


@Controller
@RequestMapping("/driver")
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String getDrivers(Model model) {
        model.addAttribute("drivers", driverRepository.findAll());
        return "driver/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "driver/create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(required=false)Object id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String licensePlate, @RequestParam String email, @RequestParam String password, @RequestParam String phoneNumber, @RequestParam(required=false) Boolean disability) {
        Driver driver = new Driver();

        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driver.setLicensePlate(licensePlate);
        driver.setEmail(email);
        driver.setPassword(password);
        driver.setPhoneNumber(phoneNumber);
        driver.setDisability(disability);

        driverRepository.save(driver);
        return "driver/homepage";
        // return "redirect:/show/" + driver.get_id();
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "driver/homepage";
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("driver", driverRepository.findById(id).get());
        return "driver/show";
    }
}
