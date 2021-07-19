package com.learnerAcademy.learnerAcademy.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class indexController {


    @GetMapping("/")
    public String index(Principal user, Model model){

        if(user !=null)
            model.addAttribute("user",user.getName());
        return "index";
    }

}
