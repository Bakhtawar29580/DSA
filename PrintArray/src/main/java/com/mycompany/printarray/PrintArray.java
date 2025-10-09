package com.mycompany.printarray;

public class PrintArray {

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;

        System.out.println("Array elements are:");
        printArray(arr, n);
    }
}
