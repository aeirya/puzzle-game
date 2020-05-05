package controller.input;

import java.awt.event.KeyEvent;
import java.util.Map;
import controller.IBoardController;

public class KeyMapper {
    
    private Map<Integer, ICommand> map = Map.of(
        KeyEvent.VK_RIGHT, IBoardController::moveRight,
        KeyEvent.VK_LEFT, IBoardController::moveLeft,
        KeyEvent.VK_UP, IBoardController::moveUp,
        KeyEvent.VK_DOWN, IBoardController::moveDown
    );

    public ICommand interpret(int keyCode) {
        if (map.containsKey(keyCode))
            return map.get(keyCode);
        else return cmdr -> {};
    } 
}