package gameobjects.mobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Player extends Socket {

    // ATTRIBUTES
        BufferedReader INPUT = null;
        PrintStream OUTPUT = null;
    
    // CONSTRUCTORS
        public Player() throws IOException {
            super("localhost", 8080);
            
            INPUT = new BufferedReader(new InputStreamReader(this.getInputStream()));
            OUTPUT = new PrintStream(this.getOutputStream());
        }

    // DYNAMIC - METHODS
        
        
        public void push(String message) {
            OUTPUT.flush();
        }

        public void stop() throws IOException {
            INPUT.close();
            OUTPUT.close();
            this.close();
        }
        // GETTERS
            
        
        // SETTERS

    // STATIC - METHODS
        
}
