package controller;

import controller.input.ICommand;
import controller.input.ICommandReceiver;
import model.interfaces.Movable;

public interface IBoardController extends Movable, ICommandReceiver {

    int getMissingPiece();

    default void moveHorizontally(int i) {
        move(i);
    }

    default void moveVertically(int i) {
        move(3*i);
    }

    default void receive(ICommand command) {
        command.act(this);
    }
}