package test;

import model.interfaces.Drawable;
import ui.SwingGraphics;

public class LoudSwingGraphics extends SwingGraphics {
    
    @Override
    protected void repaint() {
        super.repaint();
        log("repainting");
    }

    @Override
    public void update(Drawable drawable) {
        super.update(drawable);
        log("updating graphics");
    }

    @Override
    protected void draw(java.awt.Graphics g) {
        super.draw(g);
        log("draaaawing graphics");
    }

    void log(String str) {
        //System.out.println()
    }
}