package com.seandtrent.rtslabscodingexercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int[] EXAMPLE_NUMBERS = { 1, 5, 2, 1, 10 };
    private static final int EXAMPLE_COMPARISON_NUMBER = 6;
    private static final String EXAMPLE_WORD = "MyString";
    private static final int EXAMPLE_AMOUNT_TO_ROTATE = 2;
    private static final String FIRST_EXERCISE_DESCRIPTION = "Print the number of integers in an array that are above the given input and the number that are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print 'above: 1, below: 4'";
    private static final String SECOND_EXERCISE_DESCRIPTION = "Rotate the characters in a string by a given input and have the overflow appear at the beginning, e.g. 'MyString' rotated by 2 is 'ngMyStri'";

    private static void printRTSLabsLogo() {
        System.out.println("\n    ____  ___________    __          __        ");
        System.out.println("   / __ \\/_  __/ ___/   / /   ____ _/ /_  _____");
        System.out.println("  / /_/ / / /  \\__ \\   / /   / __ `/ __ \\/ ___/");
        System.out.println(" / _, _/ / /  ___/ /  / /___/ /_/ / /_/ (__  ) ");
        System.out.println("/_/ |_| /_/  /____/  /_____/\\__,_/_.___/____/  ");
        System.out.println("                                               Sean Trent's coding exercise\n");
    }

    private static void printInstructions() {
        System.out.println("Type the number for the method you would like to see and press Enter.");
        System.out.printf("1. printAboveBelow\n" + "2. rotateString\n");
        System.out.println("Type 'quit' to quit the program.");
    }

    private static void printExerciseDescription(int chosenExercise) {
        String exerciseDescription = chosenExercise == 1 ? FIRST_EXERCISE_DESCRIPTION : SECOND_EXERCISE_DESCRIPTION;

        String sampleInput = chosenExercise == 1
                ? (java.util.Arrays.toString(EXAMPLE_NUMBERS) + ", " + EXAMPLE_COMPARISON_NUMBER)
                : (EXAMPLE_WORD + ", " + EXAMPLE_AMOUNT_TO_ROTATE);

        System.out.println(exerciseDescription);

        System.out.println("Sample input: " + sampleInput);

        System.out.print("Output: ");
    }

    private static void handleBadIntegerInput(Exception e) {
        System.out.println("Please make sure you input an integer such as '2' or '-9000'");
        e.printStackTrace();
    }

    private static void runFirstExercise(RTSLabsCodingExercises codingExercises, Scanner scanner) {
        printExerciseDescription(1);
        codingExercises.printAboveBelow(EXAMPLE_NUMBERS, EXAMPLE_COMPARISON_NUMBER);
        System.out.println("Enter your own array of integers separated by spaces:");
        int[] numbers = getNumbersFromUser(scanner);
        System.out.println("Enter comparison number: ");
        int comparisonNumber = 0;
        try {
            comparisonNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            handleBadIntegerInput(e);
        }
        System.out.println("Input: " + java.util.Arrays.toString(numbers) + ", " + comparisonNumber);
        System.out.print("Output: ");
        codingExercises.printAboveBelow(numbers, comparisonNumber);
    }

    private static int[] getNumbersFromUser(Scanner scanner) {
        String numbersString = scanner.nextLine();
        String[] numbersStringAfterSplit = numbersString.split("\\s+");
        int[] numbers = new int[numbersStringAfterSplit.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numbersStringAfterSplit[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter your array in the form '1 5 2 1 10'");
            e.printStackTrace();
        }
        return numbers;
    }

    private static void runSecondExercise(RTSLabsCodingExercises codingExercises, Scanner scanner) {
        printExerciseDescription(2);
        try {
            System.out.println(codingExercises.rotateString(EXAMPLE_WORD, EXAMPLE_AMOUNT_TO_ROTATE));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.println("Enter your own word to be rotated:");
        String wordToBeRotated = scanner.nextLine();
        System.out.println("Enter amount to rotate word:");
        int amountToRotate = 0;
        try {
            amountToRotate = scanner.nextInt();
        } catch (InputMismatchException e) {
            handleBadIntegerInput(e);
        }
        System.out.println("Input: " + wordToBeRotated + ", " + amountToRotate);
        System.out.println("Output: " + codingExercises.rotateString(wordToBeRotated, amountToRotate));
    }

    public static void main(String[] args) {
        RTSLabsCodingExercises codingExercises = new RTSLabsCodingExercises();
        printRTSLabsLogo();
        printInstructions();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (!userInput.equals("quit")) {
            switch (userInput) {
                case "1":
                    runFirstExercise(codingExercises, scanner);
                    break;
                case "2":
                    runSecondExercise(codingExercises, scanner);
                    break;
                default:
                    System.out.println("Please enter '1', '2', or 'quit'");
            }
            userInput = scanner.nextLine();
        }
    }
}