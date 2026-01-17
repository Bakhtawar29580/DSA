package com.mycompany.arraystack;

public class ArrayStack {

    private int maxSize;
    private String[] stackArray;
    private int top;

    // Constructor
    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1; // stack is empty
    }

    // Push operation
    public void push(String value) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        stackArray[++top] = value;
    }

    // Pop operation
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackArray[top--];
    }

    // Peek (top element)
    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackArray[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

public static void main(String[] args) {

        ArrayStack books = new ArrayStack(10);

        books.push("The Silent Patient");
        books.push("The Kite Runner");
        books.push("The Alchemist");
        books.push("Pir e Kamil");
        books.push("The power of now");

        String removedbook1 = books.pop();
        String removedbook2 = books.pop();

        System.out.println("Books removed:");
        System.out.println(removedbook1);
        System.out.println(removedbook2);

        System.out.println("\nRemaining books:");

        // Display remaining books
        while (!books.isEmpty()) {
            System.out.println(books.pop());
        }
    }
  }