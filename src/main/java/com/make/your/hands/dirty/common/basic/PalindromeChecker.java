package com.make.your.hands.dirty.common.basic;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }

    private static boolean isPalindrome(String str) {
        str = str.toLowerCase(); // Convert the string to lowercase for case-insensitive comparison
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // If characters at symmetric positions don't match, it's not a palindrome
            }
            left++;
            right--;
        }

        return true; // If the loop completes, the string is a palindrome
    }
}
