package com.gmail.mordress.lab2.models.phones;

import java.util.ArrayList;
import java.util.List;

public class PhoneStorage {

    private static PhoneStorage instance;

    private List<Phone> phones;

    private PhoneStorage() {
        phones = new ArrayList<>();
    }

    public PhoneStorage getInstance() {
        if (instance == null) {
            instance = new PhoneStorage();
        }
        return instance;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
