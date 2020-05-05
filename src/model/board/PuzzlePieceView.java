package model.board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Image;
import ui.IGameGraphics;
import model.Location;
import model.interfaces.Drawable;

public class PuzzlePieceView implements Drawable {

    protected Image image;
    protected Location loc;

    public PuzzlePieceView(Image image, Location loc) {
        this.image = image; 
        this.loc = loc;
    }

    protected Dimension getSize() {
        final Dimension size = IGameGraphics.getScreenSize();
        return new Dimension(size.width/3, size.height/3);
    }

    public void draw(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new java.awt.Color(10,10,10));
        g2.setStroke(new BasicStroke(4));
        g2.drawRect(
            loc.getX() * getSize().width,
            loc.getY() * getSize().height,
            getSize().width,
            getSize().height
        );
        g.drawImage(
            image, 
            loc.getX() * getSize().width,
            loc.getY() * getSize().height,
            getSize().width,
            getSize().height
            , null
        );
    }
}