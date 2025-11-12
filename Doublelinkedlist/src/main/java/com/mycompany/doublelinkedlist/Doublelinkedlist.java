package com.mycompany.doublelinkedlist;

public class Doublelinkedlist {
    Node head;
    Node tail;
    
    public Doublelinkedlist(){
        this.head = null;
        this.tail = null;
    }
    
    private class Node {
        int data;
        Node next;
        Node prev;

        // Constructor for Node
        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public void addfirst(int data){
        if(head==null){
            Node temp = new Node(data,null,null);
            head = temp;
            tail = temp; //1 node will point to head + tail
        } // if no node
        else{
            Node newnode = new Node(data,head,null);
            newnode.next = head;
            head.prev = newnode;
            head = newnode; // giving references
        }
    }
    
    public void addlast(int data){
        if(head == null){
            addfirst(data);
        }
        else{
            Node newnode = new Node (data,null,tail);
            tail.next = newnode;
            tail= newnode;
        }
    }
    
     public void deletefirst(){
        Node temp = head;
        if(head == null){
            System.out.println("No list Exists");
    }
        else{
            temp = temp.next;
            head = temp;
            head.prev = null;
        }
    }
    
    public void display(){
        Node temp = head;
        if(head == null){
            System.out.println("List is Empty");
        }
        else{
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
   
    public static void main(String[] args) {
        Doublelinkedlist marks = new Doublelinkedlist();
        System.out.println("Marks");
        marks.addfirst(100);
        marks.addfirst(90);
        marks.addfirst(70);
        marks.addfirst(110);
        System.out.println("Befor deletion");
        
        marks.display();
        marks.deletefirst();
        System.out.println("After deletion");
        marks.display();
    }
}
