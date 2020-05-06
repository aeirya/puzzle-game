package model.board;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import model.interfaces.Drawable;

public class BoardView implements Drawable {

    List<Drawable> list = new ArrayList<>();

    public <T extends Drawable> BoardView(final List<T> list) {
        list.forEach(this.list::add);
    }

    public void draw(final Graphics g) {
        list.forEach(d->d.draw(g));
    }
    
}