package com.learnerAcademy.learnerAcademy.Controller;


import com.learnerAcademy.learnerAcademy.Model.users;
import com.learnerAcademy.learnerAcademy.Service.impl.usersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminController {

    @Autowired
    private usersServiceImpl usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/admin")
    public String adminIndex(Model model){
        model.addAttribute("admin" , usersService.listAll());
        return "admin";
    }

    @GetMapping("/add-admin")
    public String addADmin(Model model){
        model.addAttribute("admin" , new users());
        return "addAdmin";
    }

    @GetMapping("/admin/delete")
    public String deleteAdmin(@RequestParam("adminId") int adminId){
        usersService.deleteById(adminId);
        return "redirect:/admin";
    }


    @PostMapping("/add-admin")
    public String addAdmin(@ModelAttribute("admin") users user){
        user.setRole("ADMIN_ROLE");
        user.setEnable(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersService.create(user);
        return "redirect:/admin";
    }

}
