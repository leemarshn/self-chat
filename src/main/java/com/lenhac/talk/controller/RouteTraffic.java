package com.lenhac.talk.controller;

import com.lenhac.talk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RouteTraffic {

    private final UserRepository userRepository;

    @Autowired
    public RouteTraffic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String welcome() {
        return "index";
    }
//
//    @GetMapping("/user")
//    public String addUser() {
//        return "addUser";
//    }
//
//    @GetMapping("/message")
//    public String getMessages() {
//        return "Lee I love you";
//    }


    @GetMapping("/add-user")
    public String showSignUpForm() {
        return "add-user";
    }

//    @PostMapping("user_create")
//    public String addUser(@Valid User leen, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "create_user";
//        }
//        userRepository.save(leen);
//        model.addAttribute("users", userRepository.findAll());
//        return "redirect:/index";
//    }
}