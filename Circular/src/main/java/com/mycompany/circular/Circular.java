package com.mycompany.circular;

public class Circular {

    public static class Circular_LL {

        private Node head;
        private Node tail;

        // Constructor
        public Circular_LL() {
            head = null;
            tail = null;
        }

        private static class Node {
            int data;
            Node next;
            Node prev;

            Node(int data) {
                this.data = data;
            }
        }

        // Add node at beginning
        public void addFirst(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                head.next = head;
                head.prev = head;
            } else {
                newNode.next = head;
                newNode.prev = tail;
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
            }
        }

        // Add node at end
        public void addLast(int data) {
            if (head == null) {
                addFirst(data);
                return;
            }

            Node newNode = new Node(data);

            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        
        public void deletefirst(){
            if(head==null){
                System.out.println("No List Exists");
            }
            else if(head == tail){
                head = null;
                tail = null;
                return;
            }
            else{
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
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
        tail.next = head;
        head.prev = tail;
      }

        // Display list
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node temp = head;

            do {
                System.out.print(temp.data + " <==> ");
                temp = temp.next;
            } while (temp != head);

            System.out.println("(back to head)");
        }
    }

    public static void main(String[] args) {
        Circular_LL list = new Circular_LL();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println("Before deleting first element");
        list.display();
        
        System.out.println();
        
        System.out.println("After deleting first element");
        list.deletefirst();
        list.display();
    }
}