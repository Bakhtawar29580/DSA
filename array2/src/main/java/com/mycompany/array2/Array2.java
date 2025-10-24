package com.mycompany.array2;

public class Array2 {

    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        System.out.println("Array first element is: " + arr[0]);
        
        System.out.println("All elements of the array: ");
        for(int i = 0; i < arr.length;i++){
            System.out.println("Element at index " + i + ": " + arr[i]);
        }
    }
}
