package com.mycompany.circularlinkedlist;

public class CircularLinkedlist {
    
       class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void addFirst(int data){
        Node newNode = new Node(data);

        // If list is empty
        if(head == null){
            head = tail = newNode;
            tail.next = head;  // circular link
            return;
        }

        newNode.next = head; // link new node to old head
        head = newNode;      // update head
        tail.next = head;    // maintain circular link
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        // If list is empty
        if(head == null){
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode; // old tail points to new node
        tail = newNode;      // newNode becomes new tail
        tail.next = head;    // circular link
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }

        // If only one node
        if(head == tail){
            head = tail = null;
            return;
        }

        head = head.next;    // move head forward
        tail.next = head;    // maintain circular link
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }

        // If only one node
        if(head == tail){
            head = tail = null;
            return;
        }

        Node current = head;

        // Traverse to 2nd last node
        while(current.next != tail){
            current = current.next;
        }

        tail = current;      // 2nd last becomes tail
        tail.next = head;    // maintain circular nature
    }

    public void display(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while(current != head);

        System.out.println();
    }

   
    public static void main(String[] args) {
        CircularLinkedlist cll = new CircularLinkedlist();

        cll.addLast(15);
        cll.addLast(20);
        cll.addLast(25);
        cll.display(); 

        cll.addFirst(5);
        cll.display(); 

        cll.deleteFirst();
        cll.display();  

        cll.deleteLast();
        cll.display();  
    }
}