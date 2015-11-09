package com.gmail.mordress.lab2.controllers;

import com.gmail.mordress.lab2.models.Proffer;
import com.gmail.mordress.lab2.models.phones.Phone;
import com.gmail.mordress.lab2.models.phones.PhoneStorage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
*  номера телефонов в формате 8(XXX)XXX-XX-XX.
*
* */

public class PhoneParser extends Parser{

    private static final String phonePattern = "8\\(\\d{3}\\)\\d{3}\\-\\d{2}\\-\\d{2}";

    @Override
    protected void parseProffer(Proffer proffer) {
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(proffer.getProffer());
        while (matcher.find()) {
            PhoneStorage.getInstance().addPhone(new Phone(matcher.group()));
        }

    }
}
