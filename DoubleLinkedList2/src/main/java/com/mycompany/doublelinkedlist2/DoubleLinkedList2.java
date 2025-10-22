package com.mycompany.doublelinkedlist2;

public class DoubleLinkedList2 {

    Node head;
    Node tail;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Constructor
    public DoubleLinkedList2() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        System.out.print("List (forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail;
        System.out.print("List (backward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList2 list = new DoubleLinkedList2();

      
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10); // List: 10 20 30

        list.addLast(40);
        list.addLast(50);  // List: 10 20 30 40 50

      
        list.displayForward(); // Expected: 10 20 30 40 50

      
        list.deleteLast();     // Removes 50

      
        list.displayForward();   // Expected: 10 20 30 40
        list.displayBackward();  // Expected: 40 30 20 10
    }
}