package com.mycompany.queuearray;

public class QueueArray {
    int [] queue;
    int front;
    int rear;
    int size;
    
    public QueueArray(int capacity){
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }
    
    public boolean isfull(){
        return (rear + 1) % size == front; //enqueue
    }
    
    public boolean isEmpty(){
        return front == -1;
    }
    
    public int dequeue(){
        if(isEmpty()){
            System.out.println(" Queue is Empty. Unable to dequeue");
            return -1;
        }
        //int data;
        if (front == rear){
            front = -1;
            rear = -1;
        }
        else{
            // data = (data + 1) % size;
            front = front + 1;
        }        
        return queue[front - 1];
        //return front;
    }
    
    public void enqueue(int data){
        if(isfull()){
            System.out.println(" Queue is full. Unable to enqueue");
            return;
        }
        if (isEmpty()){
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = data;
    }
        
    // size = 5
    // front = -1
    // rear = -1
    // q = [_______]
    // enqueue = 10
    // queue[0] = 10
    // q = [10,____]
    
    public void print(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        int data = front;    // starting from front till rear
        //System.out.println("Queue");
        while(true){
            System.out.println(queue[data] + " ");
            if(rear == data)break;
                data = (data + 1) % size ;
            }
            System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(30);
        q.enqueue(34);
        q.enqueue(36);
        q.enqueue(38);
        System.out.println("Original Queue:");
        q.print();
        System.out.println("Dequeue element: " + q.dequeue());
        System.out.println("Queue after dequeue: ");
        //q.dequeue();
        q.print();
    }
}
