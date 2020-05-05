package model.interfaces;

public interface Updatable <T> {
    default void update(T t){
        //do nothing
    }
}