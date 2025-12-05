package com.mycompany.linearlab;

public class Linearlab {

    public int Linearsearch(int[] arr, int key){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    
    
        public void Linear2d(int[][] Arr, int key){
        for(int i = 0;i < Arr.length; i++){
            for(int j = 0; j < Arr[i].length ; j++){
                if(Arr[i][j]== key){
                    System.out.println("The Element in 2D array is at index: " + i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Not found");
    }
    
    public int LinearString(String[] arrS, String key){
        for(int i = 0; i < arrS.length; i++){
            if(arrS[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

        
    public static void main(String[] args) {
           Linearlab l = new Linearlab();
         int[] arr = {10, 2, 50, 40, 35};
         
         System.out.println("The Element in 1D Array is at index: " + l.Linearsearch(arr,50));
         
         int[][] Arr = {
             {10,21,34},
             {56,65,41}
         };
         l.Linear2d(Arr,21);
         
         String[] arrS = {"Manal", "Bakhtawar", "omaima", "Maryam"};
         int index = l.LinearString(arrS, "Bakhtawar");
         System.out.println("Word is at index: "+ index);
    }
}
