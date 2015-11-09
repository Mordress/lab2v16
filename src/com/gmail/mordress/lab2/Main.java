package com.gmail.mordress.lab2;
/*
* Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
* Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
* Программа должна обрабатывать как отдельные слова адреса электронной почты, номера телефонов в формате 8(XXX)XXX-XX-XX.
* 16. В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
* */

import com.gmail.mordress.lab2.controllers.EmailParser;
import com.gmail.mordress.lab2.controllers.PhoneParser;
import com.gmail.mordress.lab2.controllers.ProfferReplacer;
import com.gmail.mordress.lab2.controllers.TextCreator;
import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.Text;
import com.gmail.mordress.lab2.models.emails.EmailStorage;
import com.gmail.mordress.lab2.models.phones.PhoneStorage;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {
            File bookFile = new File("resources" + File.separator + "sometext.txt");
            TextCreator textCreator = new TextCreator(bookFile);
            textCreator.createText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ProfferReplacer profferReplacer = new ProfferReplacer(Constants.profferNumberToReplace,
                Constants.wordReplacer,
                Constants.wordReplaceLength);
        profferReplacer.replace();

        Text.getInstance().printText();

        EmailParser emailParser = new EmailParser();
        emailParser.parse(Text.getInstance());
        EmailStorage.getInstance().printEmails();

        PhoneParser phoneParser = new PhoneParser();
        phoneParser.parse(Text.getInstance());
        PhoneStorage.getInstance().printPhones();

    }
}
