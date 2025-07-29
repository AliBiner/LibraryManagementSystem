package com.alibiner.library.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomScanner {
    Scanner scanner = new Scanner(System.in);

    public CustomScanner() {
    }

    public CustomScanner(String welcomeText) {
        System.out.println(welcomeText);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    // This method asks user to enter an integer value using a String label
    public int getAbsoluteRange(String text,int minRange, int maxRange) {
        if (minRange<0)
            minRange=1;

        if (maxRange<0)
            maxRange = Math.abs(maxRange);

        int input = -1;
        while (input == -1) {
            try {
                System.out.print(text);
                int tmp = scanner.nextInt(); // read integer from user
                if (tmp < minRange || tmp > maxRange) {
                    System.out.println("Hatalı Giriş! Lütfen " + minRange + "(dahil) - " + maxRange + "(dahil) arasında bir değer giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
                else {
                    return tmp;
                }
            } catch (InputMismatchException e) {
                if (e.getMessage() == null)
                {
                    // if user enters a non-integer, show error and ask again
                    System.out.println("Hatalı giriş! Lütfen tam sayı giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
                else {
                    // If the value is too big or not a number, show this message
                    System.out.println("Hatalı Giriş! Lütfen " + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + " " +
                            "arasında bir değer giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
            }
        }
        return input;
    }

    // This method asks user to enter an integer value using a String label
    public int getAbsoluteRange(String text,int minRange) {
        if (minRange<0)
            minRange=1;

        int input = -1;
        while (input == -1){
            try {
                System.out.print(text);
                int tmp = scanner.nextInt(); // read integer from user
                if (tmp<minRange){
                    System.out.println("Hatalı Giriş! Lütfen " + minRange + "'den büyük bir değer giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
                else
                    return tmp;
            } catch (InputMismatchException e) {
                if (e.getMessage() == null)
                {
                    // if user enters a non-integer, show error and ask again
                    System.out.println("Hatalı giriş! Lütfen tam sayı giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
                else {
                    // If the value is too big or not a number, show this message
                    System.out.println("Hatalı Giriş! Lütfen " + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + " " +
                            "arasında bir değer giriniz.");
                    scanner.nextLine(); // clear the invalid input
                }
            }
        }
        return input;
    }

    // This method asks user to enter an integer value using a String label
    public String getSentencesRange(String text,int minRange) {
        int inputLength = 0;
        while (inputLength<minRange){
                System.out.print(text);
                String tmp = scanner.nextLine(); // read integer from user
                if (tmp.length()<minRange){
                    System.out.println("Hatalı Giriş! En az " + minRange + " karakter olmalı!" );
                }
                else
                    return tmp;
        }
        return null;
    }

    // This method asks user to enter an integer value using a String label
    public String getWordRange(String text,int minRange, int maxRange) {
        int inputLength = -1;
        while (inputLength<minRange){
            System.out.print(text);
            String tmp = scanner.next(); // read integer from user
            if (tmp.length()<minRange || tmp.length()>maxRange){
                System.out.println("Hatalı Giriş! En az " + minRange + " karakter, en fazla " + maxRange+ " karakter olmalı!" );
                scanner.nextLine(); // clear the invalid input
            }
            else
                return tmp;
        }
        return null;
    }
}
