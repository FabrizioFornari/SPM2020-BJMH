package spm.bjmh.SPM2020BJMH.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spm.bjmh.SPM2020BJMH.repositories.DriverRepository;


@Controller
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @RequestMapping("/drivers")
    public String getDrivers(Model model) {
        model.addAttribute("driver", driverRepository.findAll());
        return "driver/list";
    }
}
