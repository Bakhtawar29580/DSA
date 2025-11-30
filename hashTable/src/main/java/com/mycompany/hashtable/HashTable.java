package com.mycompany.hashtable;

class HashNode{
     int key;
     String value;
     HashNode next;

     public HashNode(int key, String value){
         this.key = key;
         this.value = value;
         this.next = null;
     }
}

public class HashTable {
   HashNode [] table;
    int size;
     public HashTable(int size){
         this.size = size;
         table = new HashNode[size];
     }
    
     public int Hash_Table(int key){
         return key % size;
    }
     
     public void put(int key, String value){
         int index = Hash_Table(key);
         HashNode newNode = new HashNode(key,value);
         
         //if bucket empty insert directly
         if(table[index] == null){
             table[index] = newNode;
             return;
         }
         
         //otherwise insert at the end of the linked list 
         HashNode temp = table[index];
         while(temp.next != null){
             
             //if key exists, update
             if(temp.key == key){
                 temp.value = value;
                 return;
             }
             temp = temp.next;
         }
  
         if(temp.key == key){
             temp.value = value;
             return;
         }
         temp.next = newNode;
     }
     
     public String Search(int key){
         int index = Hash_Table(key);
         HashNode temp = table[index];
         while( temp != null){
             if(temp.key == key){
                 return temp.value;
                 
             }
             temp = temp.next;            
         }
         return null;
     }
     
     public void print(){
         for(int i = 0; i < size; i++){
             System.out.println("Bucket" + i + ":");
             HashNode temp = table[i];
             while(temp != null){
                 System.out.println("[ " + temp.key + " -> " + temp.value + " ]");
                 temp = temp.next;
             }
             System.out.println();
         }
     }
     
     public void remove(int key) {
    int index = Hash_Table(key);
    HashNode temp = table[index];
    HashNode prev = null;

    // Case: bucket empty
    if (temp == null) {
        System.out.println("Key not found");
        return;
    }

    // Case 1: key found at beginning of chain
    if (temp.key == key) {
        table[index] = temp.next;  // remove head
        System.out.println("Key " + key + " removed");
        return;
    }

    // Case 2 & 3: key in middle or end
    while (temp != null && temp.key != key) {
        prev = temp;
        temp = temp.next;
    }

    // key not found
    if (temp == null) {
        System.out.println("Key not found");
        return;
    }

    // Remove the node
    prev.next = temp.next;
    System.out.println("Key " + key + " removed");
}


    public static void main(String[] args) {
         HashTable ht = new HashTable(5);
         ht.put(1, "Bakhtawar");
         ht.put(6, "Manal");
         ht.put(5, "Umaima");
         ht.put(0, "Maryam");
         ht.print();
         System.out.println("Value is: " + ht.Search(1));
         
         ht.remove(0);
         ht.remove(6);
         ht.print();
    }
}
