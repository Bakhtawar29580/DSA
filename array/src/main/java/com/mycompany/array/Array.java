package com.mycompany.array;

public class Array {

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4};
        
        System.out.println("Array elements: ");
        for(int i = 0; i < arr.length;i++){
            System.out.println("Element at index " + i + ": " + arr[i]);
        }
    }
}

