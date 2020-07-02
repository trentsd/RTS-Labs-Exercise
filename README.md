# RTS-Labs-Exercise

These are my responses for the coding tests given by RTS Labs. My responses are in Java.

#``1  Print the number of integers in an array that are above the given input and the number that are below, e.g. for the array [1, 5, 2, 1, 10] with input 6, print “above: 1, below: 4”.

    /**
     * Prints the number of integers in an array that are above the given input 
     * and the number that are below
     * 
     * @param array
     *  The integer array to be scanned e.g [1, 5, 2, 1, 10]
     * @param input
     *  The integer to which compare the members of the array e.g 6
     * 
     */
    public void aboveBelow(int[] array, int input) {
        //Initialize counters for above and below
        int above = 0;
        int below = 0;
        
        //Step through array checking if each member is above or below input
        for (int i : array) {
            if (i > input) {
                above++;
            }
            else if (i < input) {
                below++;
            }
        }
        
        //Print results
        System.out.printf("above: %d, below: %d%n", above, below);
    }







#2  Rotate the characters in a string by a given input and have the overflow appear at the beginning, e.g. “MyString” rotated by 2 is “ngMyStri”.

    /**
     * Rotates the characters in a string by a given input and has the overflow 
     * appear at the beginning. O(n) complexity.
     * 
     * @param inputString
     *  The string to be rotated, input as a String e.g. "MyString"
     * @param inputInc
     *  The amount to rotate the string, input as an Integer e.g. 2
     * @return The rotated string as a String
     */
    public String rotateString(String inputString, int inputInc) {
        //Validate that the input is non-negative
        if (inputInc < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }
        
        int stringLength = inputString.length();
        
        //A string can only be rotated at most by its own length
        int inc = inputInc % stringLength;
        
        //Create char arrays for string manipulation
        char[] original = inputString.toCharArray();
        char[] rotated = new char[stringLength];
        
        //Reverse step through resulting char array, populating it
        for (int i = stringLength - 1; i >= 0; i--) {
            //Calculate index of desired character
            int targetCharIndex = i - inc;
            //If past beginning of OG string, pull from the end of it
            if (targetCharIndex < 0) {
                targetCharIndex = (stringLength) - (-1 * targetCharIndex);
            }
            //Populate resulting char array
            rotated[i] = original[targetCharIndex];
        }
        
        //Instantiate resulting char array as String and return it
        return new String(new String(rotated));
    }


#3  If you could change 1 thing about your favorite framework/language/platform (pick one), what would it be?

	If I could change 1 thing about Java, I would add some succinct ways to initialize common data types. For example, consider initializing a new File object:
	
	File newFile = new File(“inputFile.txt”);
	
	Reading this, my brain begins to filter out the word “file”, and suddenly the concept of a file is as abstract as a neural network. 
I understand that this syntax is designed to prevent type mismatching, and for some people this is a much more readable style. Personally, I would have an easier time reading through somebody’s code if there was a good alternative to Java’s excessive verbosity.

Let us know if you have any questions! If you're good to go, please send us back your exercise at your convenience (please upload your response to a public git repository, such as Github).




