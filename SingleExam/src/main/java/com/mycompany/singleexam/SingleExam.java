package com.mycompany.singleexam;

public class SingleExam {

    int size;
    Node head;
    Node tail;
    
    public SingleExam(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    class Node{
        String data;
        Node next;
        
        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    
    void addfirst(String data){
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
    
    void addlast(String data){
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
            System.out.println("List is empty");
            return;
        } else{
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
        }
    }
    
    void deletelast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }else if(head.next == null){
            head = null;
            tail = null;
        }      
        else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }
    
    void display(){
        if(head == null){
            System.out.println("There are no nodes!");
        } else{
            Node temp = head;
            while(temp != null){
                System.out.print( temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println( );
        }
    }
    
    public static void main(String[] args) {
         SingleExam list = new SingleExam();
         
         list.addfirst("Manal");
         list.addlast("Bakhtawar");
         list.addfirst("Marium");
         list.addlast("Umaima");
         
         System.out.println("\nDisplaying names of all borrowers: ");
         list.display();
         
         list.deletefirst();
         list.deletelast();
         System.out.println("\nDisplaying names of borrowers after deleting first and last node: ");
         list.display();
        
    }
}
