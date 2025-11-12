package com.mycompany.singlelist;

public class Singlelist <Anydatatype> {
      Node head;
      Node tail;
      int size;
      
      public Singlelist(){
          this.head = null;
          this.tail = null;
          this.size = 0;
      }
      
      private class Node {
          Anydatatype data;
          Node next;
          
          public Node(Anydatatype data, Node next){
              this.data = data;
              this.next = next;
          }
      }
      
      public void addfirst(Anydatatype data){
          Node temp = new Node(data,null);
          if(head==null){
              head = temp;
              tail = temp;
          }
          else{
              temp.next = head;
              head = temp;
          }
          size++;
      }
      
      public void addLast(Anydatatype data){
          Node temp = new Node(data, null);
          if(head==null){
              head = temp;
              tail = temp;
          }
          else{
              tail.next = temp;
              tail = temp;
          }
          size++;
      }
      
      public void display(){
          if(head == null){
              System.out.println("Theres no any node");
          }
          else{
              Node temp = head;
              while(temp != null){
                  System.out.print(temp.data + "--> ");
                  temp = temp.next;
              }
              System.out.println("null");
          }
      }
       
        public int getSize() {
          return size;
       }
       
        public void deletefirst(){
            if(head==null){
                System.out.println("List is empty");
            }
            else{
                head  = head.next;
                if(head == null){
                    tail = null;
                }
                size--;
            }
        }
        
    public void deleteLast() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    } else if (head.next == null) {
        head = null;
        tail = null;
    } else {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }
    size--;
}

    public static void main(String[] args) {
        Singlelist<String> list = new Singlelist<>(); 
        System.out.println("list is created!");
        
        System.out.println();
        
        list.addfirst("Khan");
        list.addfirst("Bakhtawar");
       
        list.addLast("Manal");
        list.addLast("Lodhi");
       
        System.out.println("All elements are added!");
        System.out.println();
        
        list.display();
        list.deleteLast();
        
        list.display();
        list.deletefirst();
        
        list.display();
     }
}