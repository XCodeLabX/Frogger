package gameobjects.mobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class Player extends Thread {

    // STATES
        public static final int NULL = 0;
        public static final int QUEUING_SOLO = 1;
        public static final int QUEUING_1v1 = 2;
    
    // ATTRIBUTES
        private final Socket CLIENT;
        private BufferedReader INPUT = null;
        private PrintStream OUTPUT = null;
        private String MESSAGE;
        
        private final int STATE;
        
        public Frog FROG;
    
    // CONSTRUCTORS
        public Player(Socket client) throws IOException {
            CLIENT = client;
            INPUT = new BufferedReader(new InputStreamReader(CLIENT.getInputStream()));
            
            STATE = NULL;
            start();
        }

    // DYNAMIC - METHODS

        @Override
        public void run() {
            while(true) {
                try {
                    MESSAGE = INPUT.readLine();
                    if (MESSAGE.equals(null)) {
                        this.stop();
                        disconnect();
                    }
                    System.out.println(MESSAGE);
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }

        public void disconnect() throws IOException {
            INPUT.close();
            OUTPUT.close( );
            CLIENT.close();
        }
        
        // GETTERS
        
        
        // SETTERS

    // STATIC - METHODS
        
}
