package com.seandtrent.rtslabscodingexercises;

public class RTSLabsCodingExercises {

    /**
     * Prints the amount of integers in an array that are greater than the given
     * input and the amount that are less than 
     * Complexity O(n), where n is the length of the given array of integers.
     *
     * @param numbers          The integer array to be scanned 
     *                         e.g [1, 5, 2, 1, 10]
     * @param comparisonNumber The integer to which compare the members of the array
     *                         e.g 6
     * 
     */
    public void printAboveBelow(int[] numbers, int comparisonNumber) {
        int aboveCount = 0;
        int belowCount = 0;
        for (int i : numbers) {
            if (i > comparisonNumber) {
                aboveCount++;
            } else if (i < comparisonNumber) {
                belowCount++;
            }
        }
        System.out.printf("above: %d, below: %d%n", aboveCount, belowCount);
    }

    /**
     * Gives an appearance of "rotating" a word by a given input. 
     * 1. Calculate where the original string will begin once rotated. 
     * 2. Split the string into two halves at this position. 
     * 3. Swap the order of these two halves to form the new "rotated" form of the string. 
     * Complexity O(n), where n is the length of the string to be rotated.
     * 
     * @param wordToBeRotated The word to be rotated, input as a String
     *                        e.g."MyString"
     * @param amountToRotate  The amount to rotate the string, input as an Integer
     *                        e.g. 2
     * @return The rotated word as a String
     */
    public String rotateString(String wordToBeRotated, int amountToRotate) {
        int rotatedWordStartingIndex = getRotatedWordStartingIndex(amountToRotate, wordToBeRotated.length());
        String rotatedWordFirstHalf = getRotatedWordFirstHalf(wordToBeRotated, rotatedWordStartingIndex);
        String rotatedWordSecondHalf = getRotatedWordSecondHalf(wordToBeRotated, rotatedWordStartingIndex);
        return rotatedWordFirstHalf.concat(rotatedWordSecondHalf);
    }

    private int getRotatedWordStartingIndex(int amountToRotate, int wordLength) {
        if (wordLength < 1) {
            return 0;
        }
        return Math.floorMod(amountToRotate, wordLength);
    }

    private String getRotatedWordFirstHalf(String wordToBeRotated, int rotatedWordStartingIndex) {
        return wordToBeRotated.substring(wordToBeRotated.length() - rotatedWordStartingIndex);
    }

    private String getRotatedWordSecondHalf(String wordToBeRotated, int rotatedWordStartingIndex) {
        return wordToBeRotated.substring(0, wordToBeRotated.length() - rotatedWordStartingIndex);
    }

}
