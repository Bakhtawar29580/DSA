package com.mycompany.calculate;
public class Calculate {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0; 
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculate c1 = new Calculate();

        System.out.println("Sum of two digits is: " + c1.add(6, 90));
        System.out.println("Difference of two digits is: " + c1.subtract(90, 6));
        System.out.println("Product of two digits is: " + c1.multiply(6, 6));
        System.out.println("Quotient of two digits is: " + c1.divide(90, 6));
    }
}
