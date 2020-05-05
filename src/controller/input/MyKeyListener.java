package controller.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IBoardController;

public class MyKeyListener implements KeyListener {

    private final KeyMapper mapper;
    private final IBoardController controller;

    /** sends all the events to the IBoardController **/
    public MyKeyListener(IBoardController boardController) {
        this.controller = boardController;
        mapper = new KeyMapper();
    }

    public void keyPressed(KeyEvent keyEvent) {
        controller.receive(
            mapper.interpret(keyEvent.getKeyCode())
        );
    }
    
    public void keyReleased(KeyEvent keyEvent) { /* */}
    public void keyTyped(KeyEvent keyEvent) {/* */}
}

