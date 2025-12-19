package com.mycompany.sortarray;

import java.util.Arrays;  

public class SortArray {

    // Function to sort using built-in method
    public static void sortArray(int[] arr, int n) {
        Arrays.sort(arr, 0, n); // 
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {50, 20, 40, 10, 30};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr, n);

        sortArray(arr, n);

        System.out.println("Sorted Array:");
        printArray(arr, n);
    }
}
