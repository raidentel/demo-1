package com.example.demo.validator;

import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameUnicityValidator implements ConstraintValidator<EmailUnique, String> {

    @Autowired
    private IUserService userService;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (userService.checkUsernameExists(value) == null ? true : false);
    }
}
