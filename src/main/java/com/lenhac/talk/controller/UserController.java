package com.lenhac.talk.controller;


import com.lenhac.talk.model.User;
import com.lenhac.talk.repositories.UserRepository;
import com.lenhac.talk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {


//     private final UserRepository userRepository;

//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView createbill() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("add-user");
        return modelAndView;
    }


        @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView createNewBill(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        Bill billExists = //userService.findUserByEmail(user.getEmail());
//        if (billExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add-user");
        } else {
            //userService.saveUser(user);
            userService.addUser(user);
            modelAndView.addObject("successMessage", "user has been added successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("add-user");

        }

        return modelAndView;
    }

}