# RTS-Labs-Exercise
## Running the command-line demo
If the Java JDK/JRE are installed on your machine, a convenient command line interface can be run to demonstrate the methods written for the exercise:
 - Download the RTS-Labs-Exercise.jar file
 - In a terminal/command prompt window, navigate to the location of the .jar file
 - Run `java -jar RTS-Labs-Exercise.jar`

## My Responses
The following are my responses to the code exercise in Java

1. Print the number of integers in an array that are above the given input and the number that are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.
```java
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
```
2. Rotate the characters in a string by a given input and have the overflow appear at the beginning, e.g. “MyString” rotated by 2 is “ngMyStri”.
```java
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
```

3. If you could change 1 thing about your favorite framework/language/platform (pick one), what would it be?
 - If I could change 1 thing about Java, I would add some succinct ways to declare/initialize common data types. For example, consider initializing a new File object: 
 `File newFile = new File(“newFile”);` This example is a little bit silly, but it's really not that far-fetched. Regardless of how "clean" a piece of Java code is, these commonplace type declarations/initializations will likely be littered throughout, masking whatever unique logic the developer actually wrote.
