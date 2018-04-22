package main;

// NET IMPORTS
import java.net.ServerSocket;
import java.net.Socket;

// UTILS
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

// PROJECT IMPORTS
import gameobjects.mobile.Player;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends ServerSocket {

    // ATTRIBUTES    
        private List<Player> CLIENTS;
        
    
    // CONSTRUCTORS
        public Server() throws IOException {
            super(8080);
            
            CLIENTS = new ArrayList<>();
            Thread connexion = new Thread(new ClientConnexion(this));
            connexion.start();
        }

    // DYNAMIC - METHODS
        public void addClient(Player client) throws IOException {
            CLIENTS.add(client);
        }

        // GETTERS
            
        
        // SETTERS
            

    // STATIC - METHODS
        
}

// SERVER THREADS
    class ClientConnexion implements Runnable {

        // ATTRIBUTES
            private Server SERVER;
            private Socket CLIENT;
            private int CLIENT_NUMBER = 0;

        // CONSTRUCTOR
            public ClientConnexion(Server server) {
                SERVER = server;
            }
        
        // DYNAMIC - METHODS
            @Override
            public void run() {
                try {
                    while (true) {
                        CLIENT = SERVER.accept();
                        SERVER.addClient(new Player(CLIENT));
                        CLIENT_NUMBER++;
                        System.out.println("Le client numéro " + CLIENT_NUMBER + " est connecté !");
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }

    }

    class GameSearcher implements Runnable {
        
        // ATTRIBUTES
            
        
            @Override
            public void run() {
                
            }
        
    }

    class Talker implements Runnable {

        // ATTRIBUTES
            BufferedReader READER;
            String MESSAGE;
        
        // CONSTRUCTOR
            public Talker(BufferedReader reader) {
                READER = reader;
                MESSAGE = "";
            }
        
        // DYNAMIC - METHODS
            @Override
            public void run() {
                while (true) {
                    try {
                        MESSAGE = READER.readLine();
                        System.out.println(MESSAGE);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        
    }