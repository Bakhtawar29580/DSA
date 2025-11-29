package com.mycompany.queuell;

class Node{
        
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class QueueLL {
    
    private Node front;
    private Node rear;
    
    public QueueLL(){
        front = null;
        rear = null;
    }

    public boolean isEmpty(){
        return front == null;
    }
    
    public void enqueue(int data){
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }
    
    public int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;  // queue became empty
        }

        return value;
    }
    
    public int peek(){
            if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;
        System.out.print("Queue: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.enqueue(12);
        q.enqueue(23);
        q.enqueue(15);
        
        q.display();
        
        System.out.println("Dequeued: " + q.dequeue());
        q.display();

        System.out.println("Peek: " + q.peek());
         
    }
}
