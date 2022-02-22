package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(@ModelAttribute @Valid User user,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("error", errors);
            return "user/add";
        }

        model.addAttribute("user", user);
        if (user.getPassword().equals(user.getVerifyPassword())) {
            return "user/index";
        } else {
            model.addAttribute("verifyInvalid", "Passwords do not match");
            return "user/add";
        }

    }


}
