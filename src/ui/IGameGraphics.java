package ui;

import model.interfaces.Listener;
import model.interfaces.Updatable;
import ui.prompter.MsgType;
import model.interfaces.Drawable;
import java.awt.Dimension;
import java.awt.Toolkit;


public interface IGameGraphics extends Updatable <Drawable> , Listener {

    void setup();
    void update(Drawable drawable);
    void prompt(String msg, String title, int type);
    
    default void prompt(String msg, String title, MsgType type) {
        prompt(msg, title, type.toInt());
    }
    
    static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}