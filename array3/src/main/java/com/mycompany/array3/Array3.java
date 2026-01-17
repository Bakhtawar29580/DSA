package com.mycompany.array3;

import java.util.Scanner;

public class Array3 {

    // Function to calculate average
    public static double calculateAverage(int[] marks) {
        int sum = 0;

        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }

        return (double) sum / marks.length;
    }

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        int marks[] = new int[5];

        System.out.println("Enter marks of 5 students:");

        // Insert (input) marks
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            marks[i] = s1.nextInt();
        }

        // Display marks
        System.out.println("\nMarks entered are:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }

        // Call average function
        double average = calculateAverage(marks);
        System.out.println("\nAverage marks: " + average);

        s1.close();
    }
}
