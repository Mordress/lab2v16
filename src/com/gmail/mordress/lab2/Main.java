package com.gmail.mordress.lab2;
/*
* Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
* Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
* Программа должна обрабатывать как отдельные слова адреса электронной почты, номера телефонов в формате 8(XXX)XXX-XX-XX.
* 16. В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
*
* TODO: try refactor EmailStorage and PhoneStorage, add comments and Java code conventions
*
* */

import com.gmail.mordress.lab2.controllers.*;
import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.Text;
import com.gmail.mordress.lab2.models.emails.EmailStorage;
import com.gmail.mordress.lab2.models.phones.PhoneStorage;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        try {
            File bookFile = new File("resources" + File.separator + "sometextRU.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(bookFile), Constants.encoding);
            TextCreator textCreator = new TextCreator(reader);
            textCreator.createText();
        } catch (UnsupportedEncodingException|FileNotFoundException e) {
            e.printStackTrace();
        }

        ProfferReplacer profferReplacer = new ProfferReplacer(Constants.profferNumberToReplace,
                Constants.wordReplacer,
                Constants.wordReplaceLength);
        profferReplacer.replace();

        Text.getInstance().printText();

        Parser emailParser = new EmailParser();
        emailParser.parse(Text.getInstance());
        EmailStorage.getInstance().printEmails();

        Parser phoneParser = new PhoneParser();
        phoneParser.parse(Text.getInstance());
        PhoneStorage.getInstance().printPhones();
    }
}
