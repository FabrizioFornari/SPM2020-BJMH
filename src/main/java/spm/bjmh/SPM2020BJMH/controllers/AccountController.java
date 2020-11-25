package spm.bjmh.SPM2020BJMH.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spm.bjmh.SPM2020BJMH.Objects.UserDTO;
import spm.bjmh.SPM2020BJMH.services.UserModelServices;

import javax.validation.Valid;

@Controller
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final UserModelServices userModelServices;

    public AccountController(UserModelServices userModelServices){
        this.userModelServices = userModelServices;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        return "register";
    }




    @PostMapping("/register")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult){

        // check if the user exist

        if (userModelServices.userModelExists(userDTO.getEmail())){
            bindingResult.addError(new FieldError("userDTO" , "email" ,
                    "Email address already in use"));
        }

        // check if the password match
        if ((userDTO.getPassword() != null && userDTO.getRpassword() != null)){
            if (userDTO.getPassword().equals(userDTO.getRpassword())){
                bindingResult.addError(new FieldError("userDTO", "rpassword",
                        "Passwords must match"));
            }
        }


        if(bindingResult.hasErrors()){
            return "register";
        }
        userModelServices.register(userDTO);
        return "redirect:/login";
}
}