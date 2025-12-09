package com.mycompany.delete;

public class Delete {

    // Method to remove element at given index and return new size
    
    public static int remove(int[] arr, int size, int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return size;  
        }

        // Shift elements left 
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        
        return size - 1;  // new size after deletion
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int size = arr.length;  // initial size
        int index = 3;          // index of element to delete (4th element)

        System.out.println("Original array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();

        size = remove(arr, size, index);

        long endTime = System.nanoTime();

        // Calculate elapsed time
        long elapsedTime = endTime - startTime;

        System.out.println("Array after deleting element at index " + index + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Time taken to delete element: " + elapsedTime + " nanoseconds");
    }
}
