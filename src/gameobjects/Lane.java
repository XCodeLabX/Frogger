package gameobjects;

import gameobjects.mobile.*;
import gameobjects.textures.*;
import java.util.Arrays;


public class Lane {
    
    public static final int SAFE_ZONE = 1;
    public static final int ROAD = 2;
    public static final int WATER = 3;
    public static final int ENDING = 4;
    
    // ATTRIBUTES
        private GameObject TEXTURE;
        
        private Mobile[] MOBILE_OBJECTS;
        private float SPEED;
        private int SPACING;
        private int LENGTH;
    
    // CONSTRUCTORS
        public Lane(int length, int texture, int objectsNumber, float speed, int spacing) {
            MOBILE_OBJECTS = new Mobile[objectsNumber];
            SPEED = speed;
            SPACING = spacing;
            LENGTH = length;
            init(texture);
        }
        
        public Lane(int length) {
            this(length, 1, 0, 0, 0);
        }

    // DYNAMIC - METHODS
        public void init(int type) {
            switch(type) {                    
                case ROAD :
                    for (int i = 0; i < MOBILE_OBJECTS.length; i++) {
                        int length = 2;
                        MOBILE_OBJECTS[i] = new Car(i*(SPACING + length), length);
                        
                        if (SPEED < 0)
                            MOBILE_OBJECTS[i].setIcon("<");
                    }
                    
                    TEXTURE = new Road();
                    break;
                    
                case WATER :
                    for (int i = 0; i < MOBILE_OBJECTS.length; i++) {
                        int length = 2;
                        MOBILE_OBJECTS[i] = new Log(i*(SPACING + length), length);
                        MOBILE_OBJECTS[i].setIcon("" + i);
                    }
                    
                    TEXTURE = new Water();
                    break;
                    
                default :
                    TEXTURE = new SafeZone();
                    break;
            }
            
            if (SPEED > 0)
                for (int i = 0; i < MOBILE_OBJECTS.length; i++)
                    MOBILE_OBJECTS[i].setFollower(MOBILE_OBJECTS[(i + 1) % MOBILE_OBJECTS.length]);
            else if (SPEED < 0)
                for (int i = 0; i < MOBILE_OBJECTS.length; i++)
                    MOBILE_OBJECTS[i].setFollower(MOBILE_OBJECTS[getMod(i - 1)]);
        }
        
        public String display() {
            String render[] = new String[LENGTH];

            switch(MOBILE_OBJECTS.length) {
                case 0 :
                    for (int i = 0; i < LENGTH; i++)
                        render[i] = TEXTURE.getIcon();
                    break;
                    
                default:
                    for (int i = 0; i < LENGTH; i++)
                        for (Mobile o : MOBILE_OBJECTS)
                            if (o.isIntersecting(i)) {
                                render[i] = o.getIcon();
                                break;
                            }
                            else render[i] = TEXTURE.getIcon();
            }
            
            return Arrays.toString(render);
        }
        
        public void motion() {
            for (Mobile m : MOBILE_OBJECTS)
                m.motion(SPEED, LENGTH, SPACING);
            
            /**
            if (SPEED > 0) {
                for (int i = 0; i < MOBILE_OBJECTS.length; i++)
                    if (MOBILE_OBJECTS[i].getIndex() >= LENGTH && getDistance(MOBILE_OBJECTS[i], MOBILE_OBJECTS[(i + 1)%MOBILE_OBJECTS.length]) >= SPACING) {
                        MOBILE_OBJECTS[i].setIndex(0);
                        System.out.println("Hello");
                    }
            } else if (SPEED < 0) {
                for (int i = 0; i < MOBILE_OBJECTS.length; i++)
                    if (MOBILE_OBJECTS[i].getEdge() < 0 && getDistance(MOBILE_OBJECTS[i], MOBILE_OBJECTS[(i + 1)%MOBILE_OBJECTS.length]) >= SPACING) {
                        MOBILE_OBJECTS[i].setIndex(LENGTH);
                        System.out.println("-Hello");
                    }
            }
            **/
        }
        
        private int getMod(int i) {
            if (i < 0)
                return MOBILE_OBJECTS.length - 1;
            else return i%MOBILE_OBJECTS.length;
        }
        
        // GETTERS
            public int generateLength() {
                int x = (int) (100.0*Math.random());
                
                int length = 1;
                if (x > 66)
                    length = 3;
                else if (x > 33)
                    length = 2;
                
                return length;
            }
        
        // SETTERS
            

    // STATIC - METHODS
        
}
