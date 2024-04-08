package com.example.demo.validators;

import javax.validation.Payload;

/**
 *
 *
 *
 *
 */
public @interface ValidInventory {
    String message() default "Part inventory is not within the minimum and maximum.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
