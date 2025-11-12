package com.mycompany.linkedlistsearch;

public class LinkedlistSearch {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void search(int target) {
    Node current = head;
    int position = 0;

    while (current != null) {
        if (current.data == target) {
            System.out.println("Value " + target + " found at position " + position);
            return;
        }
        current = current.next;
        position++;
    }
    System.out.println("Value " + target + " not found in the list");
}
    
    public void deleteFromStart(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }

    public void deleteFromIndex(int index){
        if (head == null){
            System.out.println("List is Empty");
            return;
        }
        if(index == 0){
            deleteFromStart();
            return;
        }
        Node current = head;
        int count = 0;

        while(current != null && count < index - 1){
            current = current.next;
            count++;
        }
        if (current == null || current.next == null){
            System.out.println("Index out of bounds");
            return;
        }
        current.next = current.next.next;
    }

    public void display() {
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedlistSearch list = new LinkedlistSearch();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        System.out.print("Original List: ");
        list.display();

        // Delete from start
        System.out.print("Start Node Deleted: ");
        list.deleteFromStart();
        list.display();
        
        // Delete from end
        System.out.print("End Node Deleted: ");
        list.deleteFromEnd();
        list.display();

        // Delete using Index
        System.out.print("1 Index Node Deleted: ");
        list.deleteFromIndex(1);
        list.display();
        
        System.out.print("Search for value 30: ");
        list.search(30);

        System.out.print("Search for value 100: ");
        list.search(100);


    }
}