package com.mycompany.large;

public class Large {

    public static void main(String[] args) {
        
        int num1 = 60;
        int num2 = 89;
        int num3 = 43;
        
        if(num1>num2 && num1>num3){
            System.out.println("Largest number is: ");
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("Largest number is: " + num2);
        } else if (num3 > num1 && num3 > num2) {
            System.out.println("Largest number is: " + num3);
        } else {
            System.out.println("There is a tie among the largest numbers.");
        }
    }
}
