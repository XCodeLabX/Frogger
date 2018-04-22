package main;

import gameobjects.*;
import gameobjects.textures.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements KeyListener {

    // ATTRIBUTES
        // FRAME
            private Size SIZE;
            private JPanel contentPane;
    
        private Lane MAP[];
    
    // CONSTRUCTORS
        public Game(int x, int y) {
            SIZE = new Size(x, y);
            init();
            initComponents();
            display();
        }

    // DYNAMIC - METHODS
        private void init() {
            contentPane = new JPanel();
            contentPane.setPreferredSize(new java.awt.Dimension(600, 400));
            
            this.setSize(50*SIZE.X, 50*9);
            this.setContentPane(contentPane);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.addKeyListener(this);
            this.setVisible(true);
        }
        
        private void initComponents() {
            MAP = new Lane[9];
                MAP[0] = new Lane(SIZE.X);
                MAP[1] = new Lane(SIZE.X, Lane.WATER, 6, 1.2f, 4);
                MAP[2] = new Lane(SIZE.X, Lane.WATER, 4, -1.5f, 3);
                MAP[3] = new Lane(SIZE.X, Lane.WATER, 2, 1.0f, 2);
                MAP[4] = new Lane(SIZE.X);
                MAP[5] = new Lane(SIZE.X, Lane.ROAD, 3, 1.2f, 4);
                MAP[6] = new Lane(SIZE.X, Lane.ROAD, 4, -1.5f, 3);
                MAP[7] = new Lane(SIZE.X, Lane.ROAD, 2, 1.0f, 2);
                MAP[8] = new Lane(SIZE.X);
        }
        
        private void display() {
            String display = "";
            
            for (Lane lane : MAP) {
                display += lane.display() + "\n";
            }
            
            System.out.println(display);
        }
        
        @Override
        public void keyTyped(KeyEvent key) {
            
        }

        @Override
        public void keyPressed(KeyEvent key) {
            switch(key.getKeyCode()) {
                case KeyEvent.VK_Z :
                    for (Lane lane : MAP)
                        lane.motion();
                    System.out.println("====================================");
                    display();
                    break;
                case KeyEvent.VK_S :
                    System.out.println("DOWN");
                    break;
                case KeyEvent.VK_Q :
                    System.out.println("LEFT");
                    break;
                case KeyEvent.VK_D :
                    System.out.println("RIGTH");
                    break;
                    
            }
        }

        @Override
        public void keyReleased(KeyEvent key) {
            
        }
        
        // GETTERS
            
        
        // SETTERS
            

    // STATIC - METHODS

    
        
}

class Size {
    
    int X, Y;
    
    public Size(int x, int y) {
        if (x < 0)
            X = 0;
        else X = x;
        
        if (y < 0)
            Y = 0;
        else Y = y;
    }
    
    public Size() {
        this(0, 0);
    }
    
}