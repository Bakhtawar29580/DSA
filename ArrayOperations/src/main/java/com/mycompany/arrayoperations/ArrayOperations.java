package com.mycompany.arrayoperations;
import java.util.Arrays;
public class ArrayOperations {
    // Function 1: Insert at a specific index
    public static int[] insertAtIndex(int[] arr, int index, int element) {
        int[] newArr = new int[arr.length + 1];

        long startTime = System.nanoTime();

        // Copy elements before index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Insert new element
        newArr[index] = element;

        // Copy rest of the elements
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        long endTime = System.nanoTime();
        System.out.println("insertAtIndex() execution time: " + (endTime - startTime) + " ns");

        return newArr;
    }

    // Function 2: Insert at the end
    public static int[] insertAtEnd(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];

        long startTime = System.nanoTime();

        // Copy existing elements
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // Insert at the end
        newArr[arr.length] = element;

        long endTime = System.nanoTime();
        System.out.println("insertAtEnd() execution time: " + (endTime - startTime) + " ns");

        return newArr;
    }

    // Function 3: Delete element at specified index
    public static int[] deleteAtIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index for deletion.");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        long startTime = System.nanoTime();

        // Copy before the index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Copy after the index
        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        long endTime = System.nanoTime();
        System.out.println("deleteAtIndex(" + index + ") execution time: " + (endTime - startTime) + " ns");

        return newArr;
    }

    public static void main(String[] args) {
        int[] originalArray = {5, 10, 15, 20, 25};

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.err.println(" ");

        // Insert at index 2
        int[] afterInsertAtIndex = insertAtIndex(originalArray, 2, 12);
        System.out.println("After insertAtIndex(2, 12): " + Arrays.toString(afterInsertAtIndex));
        System.err.println(" ");

        // Insert at end
        int[] afterInsertAtEnd = insertAtEnd(originalArray, 30);
        System.out.println("After insertAtEnd(30): " + Arrays.toString(afterInsertAtEnd));
        System.err.println(" ");

        // Delete from start
        int[] afterDeleteStart = deleteAtIndex(originalArray, 0);
        System.out.println("After deleteAtIndex(0): " + Arrays.toString(afterDeleteStart));
        System.err.println(" ");

        // Delete from middle
        int[] afterDeleteMiddle = deleteAtIndex(originalArray, 2);
        System.out.println("After deleteAtIndex(2): " + Arrays.toString(afterDeleteMiddle));
        System.err.println(" ");

        // Delete from end
        int[] afterDeleteEnd = deleteAtIndex(originalArray, originalArray.length - 1);
        System.out.println("After deleteAtIndex(end): " + Arrays.toString(afterDeleteEnd));
        System.err.println(" ");
    }
}

