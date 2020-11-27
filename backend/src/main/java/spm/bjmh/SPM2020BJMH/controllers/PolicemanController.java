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
        return "policeman/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "policeman/create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(required=false)Object id, @RequestParam String matricola, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String phoneNumber) {
        PolicemanModel policeman = new PolicemanModel();

        policeman.setMatriculaNumber(matricola);
        policeman.setFirstName(firstName);
        policeman.setLastName(lastName);
        policeman.setEmail(email);
        policeman.setPassword(password);
        policeman.setPhoneNumber(phoneNumber);

        policemanRepository.save(policeman);
        return "policeman/homepage";
        // return "redirect:/show/" + driver.get_id();
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "policeman/homepage";
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("driver", policemanRepository.findById(id).get());
        return "policeman/show";
    }
}
