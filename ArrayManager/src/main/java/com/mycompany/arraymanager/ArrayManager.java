package com.mycompany.arraymanager;

public class ArrayManager {
    
    int[] arr;
    int capacity;
    int size;   
        
    public ArrayManager(int capacity){
            this.capacity = capacity;
            arr = new int[capacity];
            size = 0;
    }

    public void insert(int value){
            if(size < capacity){
                arr[size] = value;
                size++;
        }
        else{
            System.out.println("Array is full!");
          }
       }      
    
    public void delete(int index){
        if(index < 0 || index >= size){
              System.out.println("Array invalid");
              return;
        }
        for(int i = index; i < size - 1 ;i++){
           arr[i] = arr[i+1];          
      }
       size--;
    }
    
    public void display(){
        System.out.print("Elements in array:");
        for(int i = 0; i < size;i++){
             System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void sort(){      
        for(int i = 0; i <size -1;i++){
            for(int j = 0; j <size -1;j++){
                if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }           
          }          
        }
    }
    
    public static void main(String[] args) {
        ArrayManager array = new ArrayManager(4);
        array.insert(10);
        array.insert(25);
        array.insert(23);
        array.insert(15);
        array.insert(17);  // Will print "Array is full!"
        System.out.println();
        
        System.out.println("Array after insertion:");
        array.display();
        System.out.println();

        array.delete(3); // deletes element at index 3 (value 25)
        System.out.println("Array after deletion:");
        array.display();
        System.out.println();

        array.sort();
        System.out.println("Array after sorting:");
        array.display();
    }
}