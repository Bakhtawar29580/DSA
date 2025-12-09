package com.mycompany.table;

public class Table {

    public static void main(String[] args) {
        
        int n = 2;
        
        System.out.println("Table of " + n + ":");
        for(int i = 1; i <= 10; i++){            
            int table = n * i;
            System.out.println( n + " x " + i + " = " + table);
        }     
    }
}