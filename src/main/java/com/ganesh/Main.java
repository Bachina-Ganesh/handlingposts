package com.ganesh;

import com.ganesh.handlers.InputHandlers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            InputHandlers.displayQueryInputMessage();
            System.out.print("Choose the above input - ");
            int userInput = scanner.nextInt();
            if(userInput >= 1 && userInput <= 6)
                InputHandlers.processUserInput(userInput);
            else {
                System.out.println("=======================");
                System.out.println("Invalid Input");
                System.out.println("=======================");
            }
        }
    }
}