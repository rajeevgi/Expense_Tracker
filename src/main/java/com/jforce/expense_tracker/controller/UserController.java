package com.jforce.expense_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jforce.expense_tracker.entity.User;
import com.jforce.expense_tracker.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("User", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("User") User user, Model model){
        User user2 = userService.login(user.getEmail(), user.getPassword());

        if(user2 != null){
            return "redirect:/index";
        }

        model.addAttribute("error", "Invalid Username and password");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("User", new User());
        return "register";
    }

    @GetMapping("/homepage")
    public String homepage(){
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("message", "Registration successful!");
        return "redirect:/login";
    }
}
