package com.mycompany.doubleexam;

public class DoubleExam {

    Node head;
    Node tail;
    
    public DoubleExam(){
        this.head = null;
        this.tail = null;
    }
    
    class Node{
        String data;
        Node next;
        Node prev;
        
        public Node(String data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    
    void addfront(String data){
        Node newnode = new Node(data,head,null);
        if(head != null){
            head.prev = newnode;
        } else{
            tail = newnode;
        }
        head = newnode;
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
        Node temp= head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }    
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("null");
   }
    
    void displaybackward(){
        Node temp = tail;
        if(tail == null){
            System.out.println("List is empty");
            return;
        }
          while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
          }
          System.out.println("null");
    }
    
    
    public static void main(String[] args) {
         DoubleExam list = new DoubleExam();
         
         list.addfront("The power of now");
         list.addfront("40 Rules of love");
         list.addfront("Intro to marketing");
         list.addfront("Aab e hayaat");
         
         System.out.println("Displaying list in forward order: ");
         list.displayforward();
                  
         System.out.println("\nDisplaying list backward after deleting the last element:");       
         list.displaybackward();
         
    }
}
