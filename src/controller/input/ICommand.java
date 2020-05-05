package controller.input;

import controller.IBoardController;

public interface ICommand {
    void act(IBoardController controller);
}