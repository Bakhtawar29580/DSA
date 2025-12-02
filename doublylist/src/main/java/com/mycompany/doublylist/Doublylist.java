package com.mycompany.doublylist;

public class Doublylist {
    Node head;
    Node tail;
    
    public Doublylist(){
        this.head = null;
        this.tail = null;
    }
    
    class Node{
        int data;
        Node next;
        Node prev;
        
        public Node(int data,Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public void addfirst(int data){
        Node newnode = new Node(data,head,null);
        if(head != null){
            head.prev = newnode;
        } else{
            tail = newnode;
        }
        head = newnode;
    }
    
    public void addlast(int data){
        if(head == null){
            addfirst(data);
            return;
        }
        Node newnode = new Node(data,null,tail);
        tail.next = newnode;
        tail = newnode;
    }
     
    // ✅ Task 1: Delete Last Node
    public void deleteLast(){
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) { // Only one node
            head = null;
            tail = null;
            return;
        }

        // Move tail one step back and unlink the last node
        tail = tail.prev;
        tail.next = null;
    }
  
    // Display forward
    public void displayForward(){
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty.");  
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ✅ Task 2: Display backward
    public void displayBackward(){
        Node temp = tail;
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }   
    
    public static void main(String[] args) {
       Doublylist list = new Doublylist();

        System.out.println("Adding elements:-");
        list.addfirst(30);
        list.addfirst(20);
        list.addlast(40);
        list.addlast(50);

        System.out.println("\nList (forward):");
        list.displayForward();

        System.out.println("\nDeleting last node...");
        list.deleteLast();

        System.out.println("\nList (forward) after deletion:");
        list.displayForward();

        System.out.println("\nList (backward):");
        list.displayBackward();
    }
}
