package com.alibiner.library.App;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CustomScanner is a helper class for taking safe user input from the console.
 * It validates the input and gives error messages when the user enters wrong data.
 */
public class CustomScanner {
    /** Scanner object to read from console */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor.
     * Does not print anything when called.
     */
    public CustomScanner() {
    }

    /**
     * Constructor with a welcome message.
     * This shows a message and adds a few empty lines.
     *
     * @param welcomeText the text to show when the program starts
     */
    public CustomScanner(String welcomeText) {
        System.out.println(welcomeText);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /**
     * Asks the user to enter an integer value within a range.
     * If user enters invalid input, it keeps asking until correct input is given.
     *
     * @param text the message to show before user input
     * @param minRange the minimum allowed value (if negative, it becomes 1)
     * @param maxRange the maximum allowed value (if negative, absolute value is used)
     * @return a valid integer between minRange and maxRange (inclusive)
     */
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
                    System.out.println(
                            "Invalid input! Please enter a value between " + minRange + " and " + maxRange + ".");
                    scanner.nextLine(); // Clear buffer
                }
                else {
                    scanner.nextLine(); // Clear buffer
                    return tmp;
                }
            } catch (InputMismatchException e) {
                if (e.getMessage() == null)
                {
                    // if user enters a non-integer, show error and ask again
                    System.out.println("Invalid input! Please enter a integer.");
                }
                else {
                    // If the value is too big or not a number, show this message
                    System.out.println("Invalid input! Please enter a value between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + ".");
                }
                scanner.nextLine(); // Clear buffer
            }
        }
        return input;
    }

    /**
     * Asks the user to enter an integer value greater than or equal to minRange.
     *
     * @param text the message to show before user input
     * @param minRange the minimum allowed value (if negative, it becomes 1)
     * @return a valid integer greater than or equal to minRange
     */
    public int getAbsoluteRange(String text,int minRange) {
        if (minRange<0)
            minRange=1;

        int input = -1;
        while (input == -1){
            try {
                System.out.print(text);
                int tmp = scanner.nextInt(); // read integer from user
                if (tmp<minRange){
                    System.out.println("Invalid input! Please enter a value greater than " + minRange + ".");
                    scanner.nextLine(); // Clear buffer
                }
                else
                    return tmp;
            } catch (InputMismatchException e) {
                if (e.getMessage() == null)
                {
                    // if user enters a non-integer, show error and ask again
                    System.out.println("Invalid input! Please enter a integer.");
                }
                else {
                    // If the value is too big or not a number, show this message
                    System.out.println("Invalid input! Please enter a value between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + ".");
                }
                scanner.nextLine(); // Clear buffer
            }
        }
        return input;
    }

    /**
     * Asks the user to enter a sentence (line) with a minimum character length.
     * Keeps asking until the input length is equal or greater than minRange.
     *
     * @param text the message to show before user input
     * @param minRange the minimum number of characters required
     * @return a valid string with at least minRange characters
     */
    public String getSentencesRange(String text,int minRange) {
        int inputLength = 0;
        while (inputLength<minRange){
                System.out.print(text);
                String tmp = scanner.nextLine(); // read integer from user
                if (tmp.length()<minRange){
                    System.out.println("Invalid input! Must be at least " + minRange + " characters." );
                }
                else{
                    scanner.reset();
                    return tmp;
                }
        }
        return null;
    }

    /**
     * Asks the user to enter a single word (no spaces) with character count in a given range.
     *
     * @param text the message to show before user input
     * @param minRange the minimum number of characters
     * @param maxRange the maximum number of characters
     * @return a valid word with length between minRange and maxRange
     */
    public String getWordRange(String text,int minRange, int maxRange) {
        int inputLength = -1;
        while (inputLength<minRange){
            System.out.print(text);
            String tmp = scanner.next(); // read integer from user
            if (tmp.length()<minRange || tmp.length()>maxRange){
                if(minRange!=maxRange)
                    System.out.println("Invalid input! Must be at least " + minRange + " and no more than " + maxRange +
                        " characters." );
                else
                    System.out.println("Invalid input! Must be "+ minRange + " characters." );
                scanner.nextLine(); // Clear buffer
            }
            else
                return tmp;
        }
        return null;
    }
}
