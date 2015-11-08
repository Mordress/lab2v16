package com.gmail.mordress.lab2;
/*
* Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
* Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
* Программа должна обрабатывать как отдельные слова адреса электронной почты, номера телефонов в формате 8(XXX)XXX-XX-XX.
* 16. В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
* */
import com.gmail.mordress.lab2.controllers.ProfferReplacer;
import com.gmail.mordress.lab2.models.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        File bookFile = new File("resources" + File.separator + "sometext.txt");

        ArrayList<String> listOfWords = new ArrayList<>();
        ArrayList<String> listOfProffers = new ArrayList<>();

        Scanner scanner = new Scanner(bookFile);
        Pattern pattern = Pattern.compile("\\s+");

        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(pattern.toString());
            for (String iter : s) {
                listOfWords.add(iter);
            }
        }
        scanner.close();

        String temp = new String();

        for (String iter : listOfWords) {
            temp += " " + iter;
            if (temp.charAt(temp.length() - 1) == '.' || temp.charAt(temp.length() - 1) == '?' || temp.charAt(temp.length() - 1) == '!') {
                listOfProffers.add(temp.trim());
                temp = "";
            }
        }

        for (String s : listOfProffers) {
            Text.getInstance().addProffer(s);
        }

        Text.getInstance().printText();

        System.out.println("-----------------");
        ProfferReplacer profferReplacer = new ProfferReplacer(3, "+++++", 2);
        profferReplacer.replace();

        Text.getInstance().printText();


    }
}
