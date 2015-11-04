package com.gmail.mordress.lab2;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File bookFile = new File("resources" + File.separator + "sometext.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(bookFile));
            System.out.println((char)bufferedReader.read());
            

        } catch (Exception e) {
            e.printStackTrace();
        }









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
