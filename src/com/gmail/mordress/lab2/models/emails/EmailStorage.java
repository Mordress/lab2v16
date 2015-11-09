package com.gmail.mordress.lab2.models.emails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmailStorage {

    private static EmailStorage instance;

    private List<Email> emails;

    private EmailStorage() {
        emails = new ArrayList<>();
    }

    public static EmailStorage getInstance() {
        if (instance == null) {
            instance = new EmailStorage();
        }
        return instance;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void addEmail(Email email) {
        emails.add(email);
    }

    public void printEmails() {
        System.out.println("\nParsed emails:");
        for (Email email : emails) {
            System.out.println(email);
        }
    }
}
