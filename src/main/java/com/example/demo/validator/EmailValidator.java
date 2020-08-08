package com.example.demo.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
@Component
public class EmailValidator implements ConstraintValidator<EmailValid, String> {

    // Java email validation permitted by RFC 5322
    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";


    @Override
    public void initialize(EmailValid constraintAnnotation) {
        LOGGER.info("Init Email validation constraint");
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return email != null && email.matches(regex);
    }
}
