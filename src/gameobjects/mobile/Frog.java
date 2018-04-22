package gameobjects.mobile;

import main.Game;


public class Frog {

    // ATTRIBUTES
        private int X, Y;
        private Game GAME;
    
    // CONSTRUCTORS
        public Frog(int x, int y, Game game) {
            X = x;
            Y = y;
            GAME = game;
        }

    // DYNAMIC - METHODS
        // GETTERS
            public int getX() {
                return X;
            }
            
            public int getY() {
                return Y;
            }
        
        // SETTERS
            public void setX(int x) {
                if (x >= 0 && x < GAME.getSize().getX())
                    X = x;
            }
            
            public void setY(int y) {
                if (y >= 0 && y < GAME.getSize().getY())
                    Y = y;
            }
            
}