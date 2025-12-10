package com.mycompany.mavenproject4;

public class Mavenproject4 {
   
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

        // Call the remove method
        size = remove(arr, size, index);

        System.out.println("Array after deleting element at index " + index + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
