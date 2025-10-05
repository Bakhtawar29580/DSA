package com.mycompany.linearsearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {7, 14, 21, 28, 35};
        int search = 21;  
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                System.out.println("Element found at index " + i);
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }
}
