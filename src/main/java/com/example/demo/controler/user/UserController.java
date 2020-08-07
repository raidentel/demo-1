package com.example.demo.controler.user;

import com.example.demo.dto.user.UserDto;
import com.example.demo.service.user.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

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
        model.addAttribute("user", UserDto.builder().profile("USER").build());
        return "/register";
    }

    @GetMapping("/user/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("user", new UserDto());
        return "/dashboard";
    }


    @RequestMapping(value = "/user/username/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> checkUsernameExists(Model model, @RequestBody UserDto user) {

        final UserDto exist = userService.checkUsernameExists(user.getUsername());
        if (exist == null) {
            return ResponseEntity.ok().body(new Gson().toJson(user));
        } else {
            return ResponseEntity.badRequest().body(new Gson().toJson(user));
        }

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto user, BindingResult result,
                           Errors errors, RedirectAttributes atts, Model model) {


        if (result.hasErrors()) {
            model.addAttribute("errors",
                    result.getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList()));
            return "/register";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        String existedUsername;
        if (userService.checkUsernameExists(user.getUsername()) != null) {
            existedUsername = user.getUsername();
            model.addAttribute("existedUsername", existedUsername);
            return "/register";
        } else {
            final UserDto userSubmited = userService.create(user);
            final UserDto created = userService.getById(userSubmited.getId());
            model.addAttribute("user", created);
            return "/success";
        }
    }
}
