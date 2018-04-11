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
        } while (true);
    }
    
    private static void showMenu() {
        System.out.println(
                "-------- MENU -------"
                + "\n Press 1 : Mode Solo"
                + "\n Press 2 : Mode 2v2"
                + "\n Press 3 : Mode 3v3\n"
                + "\n Press S : Settings"
                + "\n Press 0 : Exit"
                + "\n---------------------"
        );
        System.out.print(" Your choice : ");
        choice = readInput.next();
        
    }
    
    private static void init() {
        readInput = new Scanner(System.in);
    }
    
}
