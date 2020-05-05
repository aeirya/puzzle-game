package model.interfaces;

public interface Movable {
    void moveVertically(int i);
    void moveHorizontally(int i);
    
    default void moveUp() { 
        moveVertically(-1);
    }

    default void moveDown() {
        moveVertically(1);
    }

    default void moveLeft() {
        moveHorizontally(-1);
    }
    
    default void moveRight() {
        moveHorizontally(1);
    }
}