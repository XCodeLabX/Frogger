package main;

import gameobjects.*;
import gameobjects.textures.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

    // ATTRIBUTES
        // FRAME
            private Size SIZE;
            private JPanel contentPane;
    
        private Lane MAP[];
    
    // CONSTRUCTORS
        public Game(int x, int y) {
            SIZE = new Size(x, y);
            initComponents();
            display();
        }

    // DYNAMIC - METHODS        
        private void initComponents() {
            MAP = new Lane[9];
                MAP[0] = new Lane(SIZE.getX());
                MAP[1] = new Lane(SIZE.getX(), Lane.WATER, 6, 1.2f, 4);
                MAP[2] = new Lane(SIZE.getX(), Lane.WATER, 4, -1.5f, 3);
                MAP[3] = new Lane(SIZE.getX(), Lane.WATER, 2, 1.0f, 2);
                MAP[4] = new Lane(SIZE.getX());
                MAP[5] = new Lane(SIZE.getX(), Lane.ROAD, 3, 1.2f, 4);
                MAP[6] = new Lane(SIZE.getX(), Lane.ROAD, 4, -1.5f, 3);
                MAP[7] = new Lane(SIZE.getX(), Lane.ROAD, 2, 1.0f, 2);
                MAP[8] = new Lane(SIZE.getX());
        }
        
        private void display() {
            String display = "";
            
            for (Lane lane : MAP) {
                display += lane.display() + "\n";
            }
            
            System.out.println(display);
        }
        
        // GETTERS
            public Size getSize() {
                return SIZE;
            }
        
        // SETTERS
            

    // STATIC - METHODS

    
        
}