package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValid {
    String message() default "Invalid Email format.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

