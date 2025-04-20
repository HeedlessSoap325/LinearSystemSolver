package de.heedlesssoap;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            IOHandler.queryInput();
        } catch (InputMismatchException e){
            System.out.println("Invalid input, please try again!");
        }
    }
}