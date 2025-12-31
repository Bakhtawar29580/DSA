package com.mycompany.bubble;

public class Bubble {
    
    public void BubbleSort(int [] arr){
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bubble sort = new Bubble();
        int[] arr = {10,23,45,32,12,5};
        sort.BubbleSort(arr);
        for(int arr1: arr){
               System.out.println(arr1);           
        }
    }
  }
