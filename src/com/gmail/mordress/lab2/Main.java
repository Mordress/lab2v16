package com.gmail.mordress.lab2;

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

        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split("\\s+");
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
        for (String listOfProffer : listOfProffers) {
            System.out.println(listOfProffer);
        }

        //Pattern pattern = Pattern.compile("[\\.!?]+");


     /*   ArrayList<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("[�-�]+.*[\\.!?]+\\s+");
        //Pattern pattern = Pattern.compile("[�-�A-Z]((�.�.|�.�.|��.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!]");

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


        /*����������� ����������� � �������:

        ([�-�A-Z]((�.�.|�.�.|��.)|[^?!.\(]|\([^\)]*\))*[.?!])
        ((\d+\.\s*)*[�-�A-Z]((�.�.|�.�.|��.)|[^?!.\(]|\([^\)]*\))*[.?!])
        ������ ���� ����� ����������, ����� "�.�.", "�.�." � "��." ����� ����������� ������ � �������.*/

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
