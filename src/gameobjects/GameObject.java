package gameobjects;

import gameobjects.mobile.Player;


public abstract class GameObject {

    // ATTRIBUTES
        public String ICON;
        
    
    // CONSTRUCTORS
        public GameObject(String icon) {
            ICON = icon;
        }
    
    // DYNAMIC METHODS
        public abstract void objectAction(Player player);
        
        public String getIcon() {
            return ICON;
        }
        
        public void setIcon(String icon) {
            ICON = icon;
        }
}
