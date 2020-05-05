package controller;

import controller.input.ICommand;
import controller.input.ICommandReceiver;
import model.interfaces.Movable;

public interface IBoardController extends Movable, ICommandReceiver {

    int getMissingPiece();
    boolean isMissing(int i);

    default void receive(ICommand command) {
        command.act(this);
    }
}