package com.mycompany.reversee;

public class Reversee {

    public static void main(String[] args) {
        String str = "University";
        String reverse = " ";
        
        for(int i = str.length() - 1; i >= 0; i--){
            reverse += str.charAt(i);
        } 
        System.out.println("Reversed String is: " + reverse);
    }
}