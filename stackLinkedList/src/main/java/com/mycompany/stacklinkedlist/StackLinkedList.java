package com.mycompany.stacklinkedlist;

public class StackLinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public StackLinkedList(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;  // link new node to current first
        head = newNode;       // newNode becomes the first (top)
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }

        int value = head.data;
        head = head.next;   // remove first node
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return head.data;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }

        Node current = head;
        System.out.print("Stack: ");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        StackLinkedList stack = new StackLinkedList();

        stack.push(12);
        stack.push(14);
        stack.push(45);
        stack.display();
        System.out.println("Peek: " + stack.peek()); 
        System.out.println("Pop: " + stack.pop());   
        stack.display(); 
    }
}
