package com.mycompany.array3;

import java.util.Scanner;

public class Array3 {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        
         int marks[] = new int[5];
        
        System.out.println("Enter marks of 5 students: ");
        
        for(int i = 0; i < marks.length; i++){
            System.out.println("Enter mark for student " + (i + 1) + ": ");
            marks[i] = s1.nextInt();
        }
        System.out.println("Marks entered are: ");
        for(int i = 0; i < 5;i++){
            System.out.println("Student" + (i + 1) + ": " + marks[i]);
        }
        s1.close();
    }
}
