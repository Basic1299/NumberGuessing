package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    private Random random = new Random();
    private int randomNumber;
    private int scope = 100; // Default scope range
    private int count = 0;

    public NumberGuess(int scope) {
        if (scope >= 2) {
            this.scope = scope;
        }

        this.randomNumber = random.nextInt(this.scope) + 1;
    }

    public void play() {
        System.out.println("You are playing 'Guessing number'");
        System.out.println("The random number was generated, your task is to find out which one it is");
        System.out.println("Range is 1 to " + this.scope);
        System.out.println("*************************");

        int result;

        do {
            int userGuess = userInput();
            this.count++;
            result = compareNumbers(userGuess);
            printResultMessage(result);
        } while (result != 1);

        printFinalMessage();
    }

    private void printFinalMessage() {
        System.out.println("You have guessed the number in " + this.count + " rounds.");
        System.out.println("Congratulations!");
    }

    private void printResultMessage(int result) {
        switch (result) {
            case -1:
                System.out.println("The random number is greater than your guess");
                break;
            case 0:
                System.out.println("The random number is lesser than your guess");
                break;
            case 1:
                System.out.println("The random number is " + this.randomNumber + "!");
                break;
        }
    }

    private int compareNumbers(int number) {
        if (number == this.randomNumber) {
            return 1;
        } else if (number > this.randomNumber) {
            return 0;
        } else {
            return -1;
        }
    }

    private boolean isParsable(String s) {
        try {
            int intValue = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int userInput() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Guess the number: ");
            input = scanner.nextLine();
        } while (!isParsable(input));

        return Integer.parseInt(input);
    }
}
