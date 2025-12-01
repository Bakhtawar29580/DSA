package com.mycompany.doublee;

public class Doublee {
    
    Node head;
    Node tail;
    
    public Doublee(){
        this.head = null;
        this.tail = null;
    }
    
    class Node{
        int data;
        Node next;
        Node prev;
        
        public Node(int data, Node next, Node prev){ 
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    void addfirst(int data){
        Node newnode = new Node(data,head,null);
        if(head !=null){ 
            head.prev = newnode;
        } else{
            tail = newnode;
        }
        head = newnode;
    }
    
    void addlast(int data){ 
        if(head == tail){
            addfirst(data);
            return;
        }
        Node newnode = new Node(data,null,tail); 
        tail.next = newnode;
        tail = newnode;
        
    }
  
    void deletelast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }        
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    
    void displayforward(){
        Node temp = head;
        if(head == null){
            System.out.println("List is empty"); 
            return;
        }    
            while(temp != null){
            System.out.print( temp.data + " --> ");
            temp = temp.next;
            }
            System.out.print("null"); 
    }       
    
    void displaybackward(){
        Node temp = tail;
        if(tail == null){
            System.out.println("List is epmty"); 
            return;
        }    
            while(temp != null){
            System.out.print( temp.data + " --> ");
            temp = temp.prev;
            }
            System.out.print("null");
   }

    public static void main(String[] args) {
       Doublee list = new Doublee();
        System.out.println("Adding elements...");
       list.addfirst(25);
       list.addlast(87);
       list.addfirst(98);
       list.addlast(43);
       
        System.out.println("\nList forward: ");
        list.displayforward();
        
        System.out.println("\nDeleting last node... ");
        list.deletelast();
        
        System.out.println("\nList forward after deletion: ");
        list.displayforward();
        
        System.out.println("\nList Backward: ");
        list.displaybackward();
    }    
}