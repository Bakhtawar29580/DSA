package com.mycompany.singlylinked;

public class SinglyLinked {    
    Node head;
    Node tail;
    int size;
    
    public SinglyLinked(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    class Node{
        int data;
        Node next;
        
        public Node(int data){           
            this.data = data;
            this.next = null;
        }
    }
    
    void addfirst(int data){
            Node temp = new Node(data);
            if(head == null){
                head = temp;
                tail = temp;
        } else{
                temp.next = head;
                head = temp;
            }
            size++;
    }
    
    void addlast(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        } else{
                tail.next = temp;
                tail = temp;
            }
        size++;
    }

    void deletefirst(){
        if(head == null){
            System.out.println("List is empty!");
        } else{
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
        }
    }
    
    void deletelast(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        } else if(head.next == null){
            head = null;
            tail = null;
        } else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }
    
    public void display(){
        if(head==null){
            System.out.println("There are no nodes!");
        } else{
            Node temp = head;
            while(temp!= null){
               System.out.print( temp.data + " --> ");
               temp = temp.next;
            }
            System.out.println(" null ");
        }
    }
    
    public static void main(String[] args) {
        SinglyLinked list = new SinglyLinked();
        
        list.addfirst(23);
        list.addlast(45);
        list.addlast(65);
        list.addlast(11);
        System.out.print("After adding customers: ");
        list.display();
        list.deletefirst();
        list.deletelast();
        System.out.print("After deleting first and last customers: ");
        list.display();
    }
}
