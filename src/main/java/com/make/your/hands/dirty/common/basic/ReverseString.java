package com.make.your.hands.dirty.common.basic;

public class ReverseString {
    public static void main(String[]args) {
        String originalString = "Hello, World!";
        String reversedString = reverseString(originalString);

        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reverseString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Initialize pointers for the beginning and end of the array
        int start = 0;
        int end = charArray.length - 1;

        // Reverse the characters in the array
        while (start < end) {
            // Swap characters at start and end
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        // Convert the character array back to a string
        return new String(charArray);
    }

}
