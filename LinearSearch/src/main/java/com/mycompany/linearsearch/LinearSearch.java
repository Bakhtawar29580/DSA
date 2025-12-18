package com.mycompany.linearsearch;

public class LinearSearch{
    public static void main(String[] args) {
        int arr[] = {12,32,45,65,20};
        int search = 43;
        boolean found = false;
        
        for(int i = 0; i <arr.length; i++){
            if(arr[i] == search){
                System.out.println("Element found at index " + i);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("not found");
        }
    }
}

