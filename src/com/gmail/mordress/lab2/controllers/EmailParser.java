/*
package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.emails.Email;
import com.gmail.mordress.lab2.models.emails.EmailStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailParser extends Parser{

    @Override
    protected void parseProffer(Proffer proffer) {
        Pattern pattern = Pattern.compile(Constants.emailPattern);
        Matcher matcher = pattern.matcher(proffer.getProffer());
        while (matcher.find()) {
            EmailStorage.getInstance().addEmail(new Email(matcher.group()));
        }

    }
}
*/
