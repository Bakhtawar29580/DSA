package com.mycompany.linkedlistmanager;

public class Linkedlistmanager {   
    
    Node head;
    Node tail;
    int size;
    
    public Linkedlistmanager(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    void addfirst(int data){
        Node temp = new Node(data);
        if(head==null){
            head = temp;
            tail = temp;
        } else{
            temp.next = head; //corrected
            head = temp;
        }
        size++;
    }
    
    void addlast(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp; //corrected
            tail = temp;
        } else{
            tail.next = temp; //corrected
            tail = temp;
        }
        size++;
    }
    
    void deletefirst(){
        if(head==null){
            System.out.println("List is empty!");
        } else{
            head = head.next;  //corrected
            if(head == null){
                tail = null;
            }
            size--;
        }       
    }
    
    void deletelast(){
        if(head==null){
            System.out.println("List is empty");
        } else if(head.next == null){
            head = null;
            tail = null;
        } else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;    //corrected
            tail = temp;  
        }
        size--;  //correct
    }
    
    void display(){
        if(head==null){
            System.out.println("Theres no node");
        } else{
            Node temp = head;
            while(temp != null){
                System.out.print( temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }
    
    public static void main(String[] args) {
        Linkedlistmanager list = new Linkedlistmanager();
        list.addfirst(24);
        list.addlast(65);
        list.addlast(98);
        list.addfirst(12);
        System.out.print("After adding customers: ");
        list.display();
        list.deletefirst();
        list.deletelast();
        System.out.print("After deleteing first and last customers: ");
        list.display();
    }
}