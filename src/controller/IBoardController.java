package controller;

import controller.input.ICommand;
import controller.input.ICommandReceiver;
import model.interfaces.Movable;

public interface IBoardController extends Movable, ICommandReceiver {

    int getMissingPiece();

    default void moveHorizontally(final int i) {
        move(i);
    }

    default void moveVertically(final int i) {
        move(3 * i);
    }

    default void receive(final ICommand command) {
        command.act(this);
    }
}