package com.mycompany.insertend;
import java.util.Arrays;
// insertAtEnd(int arr[], int element)

public class InsertEnd {

    public static void main(String[] args) {
        int arr[] = {10,15,20};
        int element = 25;
        
        int[] newArr = new int[arr.length + 1];
        
        long startTotal = System.nanoTime();
        
        long startFirstLoop = System.nanoTime();
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i]; //10,15,20 (0,1,2)
        }       
        long endFirstLoop = System.nanoTime();
        
        long startInsert = System.nanoTime();
        newArr[arr.length] = element;  // 25 (3)
        long endInsert = System.nanoTime();
        
        long endTotal = System.nanoTime();
        
        System.out.println("New array: " + Arrays.toString(newArr));
        
        System.out.println("\nExecution Time (nanoseconds):");
        System.out.println("Copying original array: " + (endFirstLoop - startFirstLoop));
        System.out.println("Insertion at end:       " + (endInsert - startInsert));
        System.out.println("Total execution time:   " + (endTotal - startTotal));
    }
}
