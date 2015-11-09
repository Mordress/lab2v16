package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.phones.Phone;
import com.gmail.mordress.lab2.models.phones.PhoneStorage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneParser extends Parser{

    @Override
    protected void parseProffer(Proffer proffer) {
        Pattern pattern = Pattern.compile(Constants.phonePattern);
        Matcher matcher = pattern.matcher(proffer.getProffer());
        while (matcher.find()) {
            PhoneStorage.getInstance().addPhone(new Phone(matcher.group()));
        }

    }
}
