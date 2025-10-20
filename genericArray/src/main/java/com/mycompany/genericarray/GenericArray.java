package com.mycompany.genericarray;

class MyGenericArray<T> {
    private Object[] arr;  // store elements (Object, then cast to T)
    private int size;

    // Constructor to create array with given size
    public MyGenericArray(int size) {
        this.size = size;
        arr = new Object[size];
    }

    // Add element at specific index
    public void addElement(int index, T element) {
        if (index >= 0 && index < size) {
            arr[index] = element;
        } else {
            System.out.println("Index out of bounds!");
        }
    }

    // Get element from specific index
    @SuppressWarnings("unchecked")
    public T getElement(int index) {
        if (index >= 0 && index < size) {
            return (T) arr[index];
        } else {
            System.out.println("Index out of bounds!");
            return null;
        }
    }

    // Print all elements
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Search element and return its position
    public int searchElement(T element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(element)) {
                return i; // return index
            }
        }
        return -1; // not found
    }

    // Delete element at specific index
    public void deleteElement(int index) {
        if (index >= 0 && index < size) {
            arr[index] = null;
        } else {
            System.out.println("Index out of bounds!");
        }
    }
}

public class GenericArray {  

    public static void main(String[] args) {
        
         // Create a GenericArray of Integers
        MyGenericArray<Integer> intArray = new MyGenericArray<>(5);

        intArray.addElement(0, 10);
        intArray.addElement(1, 20);
        intArray.addElement(2, 30);
        intArray.addElement(3, 40);
        intArray.addElement(4, 50);

        System.out.println("Integer Array:");
        intArray.printArray();

        System.out.println("Element at index 2: " + intArray.getElement(2));
        System.out.println("Position of 30: " + intArray.searchElement(30));

        intArray.deleteElement(2);
        System.out.println("Array after deleting index 2:");
        intArray.printArray();

        // Create a GenericArray of Strings
        MyGenericArray<String> strArray = new MyGenericArray<>(3);

        strArray.addElement(0, "Hello");
        strArray.addElement(1, "World");
        strArray.addElement(2, "Java");

        System.out.println("\nString Array:");
        strArray.printArray();

        System.out.println("Element at index 1: " + strArray.getElement(1));
        System.out.println("Position of 'Java': " + strArray.searchElement("Java"));

        strArray.deleteElement(1);
        System.out.println("Array after deleting index 1:");
        strArray.printArray();
    }
}