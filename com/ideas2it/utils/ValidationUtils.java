package com.ideas2it.utils;

import java.util.regex.*;

/**
 * Holds the validation methods which returns a boolean statement,
i.e checks the inputted elements are actually valid to be as a element.
 *
 * @author name: Dinesh Kumar R
 *
 * @modified at: 14.09.2022
 *
 */
public class ValidationUtils {

    public boolean nameValidation(String name) {
        return Pattern.matches("^[a-zA-Z]{1}[a-zA-Z\s]+[^\s]$", name);
    } 

    public boolean departmentValidation(String dept) {
        return Pattern.matches("^[a-zA-Z]{1}[a-zA-Z\s]*$", dept);
    }

    public boolean phoneNumberValidation(String phoneNumber) {
        return Pattern.matches("[6-9]{1}[\\d]{9}", phoneNumber);
    }

    public boolean emailValidation(String Email) {
        return Pattern.matches("^[a-zA-Z]{1}[.\\w]{1,20}@[\\w]{1,10}[.a-zA-Z+]{2,6}", Email);
    } 

    public boolean dateValidation(String userDate) {
        return Pattern.matches("^[0-3]{1}[0-9]{1}[/][0-1]{1}[0-9]{1}[/][1-2]{1}[09]{1}[0-9]{2}", userDate);
    }
}