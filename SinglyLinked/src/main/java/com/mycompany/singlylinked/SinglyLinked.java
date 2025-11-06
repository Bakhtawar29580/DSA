package com.mycompany.singlylinked;

public class SinglyLinked <datatype> {
    Node head;
    Node tail;
    int size;
    
    public SinglyLinked(){
        this.head = head;
        this.tail = tail;
        this.size = 0;
    }
    
    class Node{
        datatype data;
        Node next;
        Node(datatype data){
            this.data = data;
            this.next = null;
        }
    }
    
    public void addfirst(datatype data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }
    
    public void addlast(datatype data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    
    public void deletefirst(){
        if(head == null){
            System.out.println("List is epmty!");
        } else{
            head = head.next;
            if(head == null){
                tail = null;
            }
            size--;
        }
    }
    
    public void deletelast(){
        if(head == null){
            System.out.println("List is empty");
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
        if(head == null){
            System.out.println("Theres no any node");
        }
        else{
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SinglyLinked<String> list = new SinglyLinked<>();
        System.out.println("List is created!");
        
        System.out.println();
        
        list.addfirst("Manal");
        list.addlast("Lodhi");
        list.addfirst("Bakhtawar");
        list.addlast("Khan");
        
        list.display();
        
        list.deletefirst();
        list.deletelast();
        
        list.display();
    }
}
