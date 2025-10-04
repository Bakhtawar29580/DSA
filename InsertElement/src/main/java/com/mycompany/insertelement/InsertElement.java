package com.mycompany.insertelement;

public class InsertElement {

    public static void insertElement(int[] arr, int n, int pos, int element) {
        // shift elements to the right
        for (int i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = element; // insert element
    }

    // Function to print array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[10]; // bigger size for insertion
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        int n = 5;  // current size
        int pos = 2;  // insert at index 2
        int element = 25;

        System.out.println("Original Array:");
        printArray(arr, n);

        insertElement(arr, n, pos, element);
        n++; // increase size

        System.out.println("Array after inserting " + element + " at position " + pos + ":");
        printArray(arr, n);
    }
}