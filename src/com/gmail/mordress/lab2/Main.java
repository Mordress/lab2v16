package com.gmail.mordress.lab2;
/*
* Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др.
* Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.
* Программа должна обрабатывать как отдельные слова адреса электронной почты, номера телефонов в формате 8(XXX)XXX-XX-XX.
* 16. В некотором предложении текста слова заданной длины заменить указанной подстрокой, длина которой может не совпадать с длиной слова.
* */
import com.gmail.mordress.lab2.models.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
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

        /*for (String s : listOfWords) {
            System.out.println(s);
        }*/

        String temp = new String();

        for (String iter : listOfWords) {
            temp += " " + iter;
            if (temp.charAt(temp.length() - 1) == '.' || temp.charAt(temp.length() - 1) == '?' || temp.charAt(temp.length() - 1) == '!') {
                listOfProffers.add(temp.trim());
                temp = "";
            }
        }
        /*for (String listOfProffer : listOfProffers) {
            System.out.println(listOfProffer);
        }*/


        for (String s : listOfProffers) {
            Text.getInstance().addProffer(s);
        }

        System.out.println(Arrays.asList(Text.getInstance().getProffersList()));

        //Pattern pattern = Pattern.compile("[\\.!?]+");


     /*   ArrayList<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("[А-Я]+.*[\\.!?]+\\s+");
        //Pattern pattern = Pattern.compile("[А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]");

        Scanner scanner = new Scanner(bookFile);
        String s = "";
        while (scanner.hasNextLine()) {
            s += scanner.nextLine();
            Matcher matcher = pattern.matcher(s);

            while (matcher.matches()) {
                list.add(matcher.group());

                s = s.substring(matcher.end()-1);

            }

        }
        for (String string : list) {
            System.out.println(string);
            System.out.println("* * *");
        }*/





        /*Scanner scanner = new Scanner(bookFile);
        scanner.useDelimiter(pattern);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
            System.out.println("* * *");
        }*/


        /*Предложения разбиваются с помощью:

        ([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\(]|\([^\)]*\))*[.?!])
        ((\d+\.\s*)*[А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\(]|\([^\)]*\))*[.?!])
        Только если любые сокращения, кроме "т.д.", "т.п." и "пр." будут встречаться только в скобках.*/

/*
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("resources/sometext.txt")));
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
*/

    }
}
