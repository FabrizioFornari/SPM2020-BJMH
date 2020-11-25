package spm.bjmh.SPM2020BJMH.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spm.bjmh.SPM2020BJMH.Objects.DriverDTO;


import javax.validation.Valid;

public class DriverController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/register/driver")
    public String register(@ModelAttribute DriverDTO driverDTO, Model model){
        model.addAttribute("driverDTO",driverDTO);
        return "register driver";
    }


    @PostMapping("/register/driver")
    public String save(@Valid DriverDTO driverDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return "register driver";
        log.info(">> driverDTO : {}", driverDTO.toString());
        return "redirect:/login";
    }
}

