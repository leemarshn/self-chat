package com.lenhac.talk.controller;


import com.lenhac.talk.model.User;
import com.lenhac.talk.repositories.SecurityService;
import com.lenhac.talk.repositories.UserRepository;
import com.lenhac.talk.repositories.UserService;
import com.lenhac.talk.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView userRegistration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("add-user");
        return modelAndView;
    }


//    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
////        Bill billExists = //userService.findUserByEmail(user.getEmail());
////        if (billExists != null) {
////            bindingResult
////                    .rejectValue("email", "error.user",
////                            "There is already a user registered with the email provided");
////        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("add-user");
//        } else {
//            //userService.saveUser(user);
//            userService.save(user);
//            modelAndView.addObject("successMessage", "user has been added successfully");
////            modelAndView.addObject("user", new User());
//            securityService.autoLogin(user.getEmail(), user.getConfirmPassword());
//
//            modelAndView.setViewName("welcome");
//
//
//        }
//
//        return modelAndView;
//    }

        @GetMapping("/login")
    public String login() {
        return "login";
    }




    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        userValidator.validate(user, bindingResult);

//        Bill billExists = //userService.findUserByEmail(user.getEmail());
//        if (billExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (userService.findByEmail(user.getEmail()) != null) {
//            bindingResult.rejectValue("email", "error.user");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "password", "NotEmpty");
//        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
//            bindingResult.rejectValue("password", "error.user");
//        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.user", "Password do not match");
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }


        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("add-user");
        } else {
            //userService.saveUser(user);
            userService.save(user);
            modelAndView.addObject("successMessage", "user has been added successfully");
//            modelAndView.addObject("user", new User());
            securityService.autoLogin(user.getEmail(), user.getConfirmPassword());

            modelAndView.setViewName("welcome");

        }

        return modelAndView;
    }
}





//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getEmail(), userForm.getConfirmPassword());
//
//        return "redirect:/welcome";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
//
//    @GetMapping({"/", "/welcome"})
//    public String welcome(Model model) {
//        return "welcome";
//    }
//
//
//
//}