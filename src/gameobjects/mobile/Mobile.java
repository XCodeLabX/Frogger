package gameobjects.mobile;

import gameobjects.GameObject;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Mobile extends GameObject {

    // ATTRIBUTES
        private int LENGTH;
        private int INDEX;
        
        private Mobile FOLLOWER;
    
    // CONSTRUCTORS
        public Mobile(String icon) {
            super(icon);
        }

    // DYNAMIC - METHODS
        public boolean isIntersecting(int i) {
            if (i >= getIndex() && i <= getEdge())
                return true;
            
            return false;
        }
        
        public void motion(float speed, int length, int spacing) {
            /**
            if (speed > 0) {
                INDEX++;
                if (INDEX >= length)
                    INDEX = -1;
            }
            else {
                INDEX--;
                if (INDEX < 0)
                    INDEX = length;
            }
            **/
            if (speed > 0) {
                if (Mobile.getDistance(this, FOLLOWER) >= spacing)
                    INDEX++;
                if (INDEX > length)
                    INDEX = -1;
            }
            else if (speed < 0) {
                if (Mobile.getDistance(FOLLOWER, this) >= spacing)
                    INDEX--;
                if (getEdge() < 0)
                    INDEX = length;
            }
        }

        // GETTERS
            public int getLength() {
                return LENGTH;
            }
            
            public int getIndex() {
                return INDEX;
            }
            
            public int getEdge() {
                return INDEX + LENGTH - 1;
            }
            
            public Mobile getFollower() {
                return FOLLOWER;
            }
        
        // SETTERS
            public void setLength(int length) {
                if (length < 1)
                    LENGTH = 1;
                else LENGTH = length;
            }
            
            public void setIndex(int index) {
                INDEX = index;
            }
            
            public void setFollower(Mobile folower) {
                FOLLOWER = folower;
            }
        
    // STATIC - METHODS
        public static int getDistance(Mobile A, Mobile B) {
            return Math.abs(B.getIndex() - A.getEdge()) - 1;
        }
}
