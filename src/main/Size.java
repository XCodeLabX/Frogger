package main;


public class Size {

    // ATTRIBUTES
        private int X, Y;
    
    // CONSTRUCTORS
        public Size(int x, int y) {
            X = x;
            Y = y;
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
                if (x >= 0)
                    X = x;
                else X = 0;
            }
            
            public void setY(int y) {
                if (y >= 0)
                    Y = y;
                else y = 0;
            }

    // STATIC - METHODS
        
}
