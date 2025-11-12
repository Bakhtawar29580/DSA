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
        } else {
            System.out.println("Array is full!");
        }
    }      
     
    public void delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index!");
            return;
        }
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        size--;
    }
     
    public void display(){
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public void sort(){      
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }           
            }          
        }
    }
        
    public static void main(String[] args) {
        ArrayManager marks = new ArrayManager(5);
        
        marks.insert(78);
        marks.insert(85);
        marks.insert(69);
        marks.insert(90);
        marks.insert(56);
        
        System.out.print("Marks after insertion: ");
        marks.display();
        
        marks.delete(2); // delete element at index 2 (value 69)
        System.out.print("After deleting element at index 2: ");
        marks.display();
        
        marks.sort();
        System.out.print("After sorting: ");
        marks.display();
    }
}
