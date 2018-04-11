package gameobjects;


public abstract class Texture {
    
    // ATTRIBUTES
        public String ICON;
    
    // CONSTRUCTORS
        public Texture(String icon) {
            ICON = icon;
        }
    
    // DYNAMIC METHODS
        public abstract void textureAction(Player player);
    
}
