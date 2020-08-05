package com.example.demo.controler.user;

import com.example.demo.dto.user.UserDto;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "/register";
    }

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("user", new UserDto());
        return "/dashboard";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto user,
                           Model model) {
        user.setPassword(encoder.encode(user.getPassword()));
        String existedUsername;
        if (userService.getUserDtoByUsername(user.getUsername()) != null) {
            existedUsername = user.getUsername();
            model.addAttribute("existedUsername", existedUsername);
            return "/register";
        } else {
            final UserDto userSubmited = userService.create(user);
            model.addAttribute("user", userSubmited);
            return "/success";
        }
    }
}
