package main;

import java.util.Scanner;

public class Main {

    // ATTRIBUTES
        private static Scanner readInput;
        private static String choice;
    
    public static void main(String[] args) {
        init();
        
        do {
            showMenu();
            choice = readInput.next();
            System.out.println(choice);
        } while (true);
    }
    
    private static void showMenu() {
        System.out.println("Press 1 : Mode Solo");
        System.out.println("Press 2 : Mode 2v2");
        System.out.println("Press 3 : Mode 3v3");
    }
    
    private static void init() {
        readInput = new Scanner(System.in);
    }
    
}
