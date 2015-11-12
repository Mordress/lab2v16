package com.gmail.mordress.lab2;
/*
* Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
* Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
* Программа должна обрабатывать как отдельные слова адреса электронной почты, номера телефонов в формате 8(XXX)XXX-XX-XX.
* 16. В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
*
*
*
* */

import com.gmail.mordress.lab2.controllers.*;
import com.gmail.mordress.lab2.helpers.Constants;
import com.gmail.mordress.lab2.models.Text;


import java.io.*;

public class Main {

    public static void main(String[] args) {

        /*reading file and create Text*/
        try {
            File bookFile = new File("resources" + File.separator + "sometextRU.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(bookFile), Constants.encoding);
            TextCreator textCreator = new TextCreator(reader);
            textCreator.createText();
        } catch (UnsupportedEncodingException|FileNotFoundException e) {
            e.printStackTrace();
        }

        /*replacing words in Proffer*/
        ProfferReplacer profferReplacer = new ProfferReplacer(Constants.profferNumberToReplace,
                Constants.wordReplacer,
                Constants.wordReplaceLength);
        profferReplacer.replace();

        Text.getInstance().printText();

        Text.getInstance().getProfferByNumber(Text.getInstance().getCountOfProffers() - 2).printClassNames();
    }
}
