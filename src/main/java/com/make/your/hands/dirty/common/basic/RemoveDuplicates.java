package com.make.your.hands.dirty.common.basic;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9};

        System.out.println("Original Array: " + Arrays.toString(array));

        int[] uniqueArray = removeDuplicates(array);

        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));
    }

    private static int[] removeDuplicates(int[] array) {
        int n = array.length;
        int[] uniqueArray = new int[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            // Check if the current element is a duplicate
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            // If not a duplicate, add it to the uniqueArray
            if (!isDuplicate) {
                uniqueArray[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        // Trim the uniqueArray to remove unused elements
        return Arrays.copyOf(uniqueArray, uniqueCount);
    }
}
