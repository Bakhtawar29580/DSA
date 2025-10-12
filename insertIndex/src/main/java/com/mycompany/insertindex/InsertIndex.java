package com.mycompany.insertindex;
import java.util.Arrays;
// insertAtIndex(int arr[], int index, int element)

public class InsertIndex {

    public static void main(String[] args) {
        int arr[] = {9,11,12};
        int index = 1;
        int element = 10;
        
        int[] newArr = new int[arr.length + 1];
        
        long startTotal = System.nanoTime();
        
        long startFirstLoop= System.nanoTime();
        for(int i= 0; i < index; i++){
            newArr[i] = arr[i];         
        }
        long endFirstLoop = System.nanoTime();
        
        long startInsert = System.nanoTime();
        newArr[index] = element;
        long endInsert = System.nanoTime();
        
        long startSecondLoop = System.nanoTime();
        for(int i= index; i < arr.length; i++){
            newArr[i + 1] = arr[i];         
        }
        long endSecondLoop = System.nanoTime();
        
        long endTotal = System.nanoTime();
        
        System.out.println( "New array: "+ Arrays.toString(newArr));
        System.out.println("\nExecution Time (nanoseconds):");
        System.out.println("First loop (copy before index): " + (endFirstLoop - startFirstLoop));
        System.out.println("Insertion at index:            " + (endInsert - startInsert));
        System.out.println("Second loop (shift elements):  " + (endSecondLoop - startSecondLoop));
        System.out.println("Total execution time:          " + (endTotal - startTotal));
    }
}
