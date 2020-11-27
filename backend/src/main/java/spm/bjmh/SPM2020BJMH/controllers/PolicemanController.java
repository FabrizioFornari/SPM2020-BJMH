package spm.bjmh.SPM2020BJMH.controllers;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spm.bjmh.SPM2020BJMH.models.PolicemanModel;
import spm.bjmh.SPM2020BJMH.repositories.PolicemanRepository;

@Controller
@RequestMapping("/policeman")
public class PolicemanController {

    private final PolicemanRepository policemanRepository;

    public PolicemanController(PolicemanRepository policemanRepository) {
        this.policemanRepository = policemanRepository;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String getDrivers(Model model) {
        model.addAttribute("policemen", policemanRepository.findAll());
        return "policemen/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "policeman/create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(required=false)Object id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String licensePlate, @RequestParam String email, @RequestParam String password, @RequestParam String phoneNumber, @RequestParam(required=false) Boolean disability) {
        PolicemanModel policeman = new PolicemanModel();

        policeman.setFirstName(firstName);
        policeman.setLastName(lastName);
        policeman.setLicensePlate(licensePlate);
        policeman.setEmail(email);
        policeman.setPassword(password);
        policeman.setPhoneNumber(phoneNumber);
        policeman.setDisability(disability);

        policemanRepository.save(policeman);
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
        model.addAttribute("driver", policemanRepository.findById(id).get());
        return "driver/show";
    }
}
