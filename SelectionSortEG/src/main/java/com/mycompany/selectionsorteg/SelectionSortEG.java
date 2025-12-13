package com.mycompany.selectionsorteg;

public class SelectionSortEG {
    public void SelectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++){
            int minvalue = i;
            for(int j=i+1; j < n ;j++){
            if(arr[j]<arr[minvalue]){
                minvalue = j;
            }
        }
            int temp = arr[minvalue];
            arr[minvalue] = arr[i];
            arr[i] = temp;
        }
    }
    
     public void SelectionSortString(String[] arr){
        int n = arr.length;
        for(int i = 0;i < n-1;i++){
            int minvalue = i;
            for(int j=i+1; j < n ;j++){
            if(arr[j].compareTo(arr[minvalue]) < 0){
                minvalue = j;
            }
        }
            String temp = arr[minvalue];
            arr[minvalue] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSortEG sort = new SelectionSortEG();
        int[] marks = {99,34,54,67,12,2,89};
        sort.SelectionSort(marks);
        for(int arr1: marks){
               System.out.println(arr1);           
        }
     
        String[] arr2 = {"Manal", "Maryam", "Omaiyann", "Bakhtawar"};
        sort.SelectionSortString(arr2);
        for(String arr3: arr2){
               System.out.println(arr3);           
        }
    }
}
