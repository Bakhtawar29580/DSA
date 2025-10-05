package com.mycompany.deleteelement;

public class DeleteElement {

    public static int deleteElement(int[] arr, int n, int key) {
        int pos = -1;

        // find position of key
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                pos = i;
                break;
            }
        }

        // if element not found
        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        // shift elements left
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return n - 1; // new size
    }

    // Function to print array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[10]; // extra space for safety
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        int n = 5; // current size

        System.out.println("Original Array:");
        printArray(arr, n);

        int key = 30; // element to delete
        n = deleteElement(arr, n, key);

        System.out.println("Array after deleting " + key + ":");
        printArray(arr, n);
    }
}