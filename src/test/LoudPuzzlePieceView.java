package test;

import java.awt.Image;

import model.Location;
import model.board.PuzzlePieceView;

public class LoudPuzzlePieceView extends PuzzlePieceView {

    public LoudPuzzlePieceView(Image image, Location loc) {
        super(image, loc);
    }
    
    @Override
    public void draw(java.awt.Graphics g) {
        super.draw(g);
        // System.out.println(
        //     "image: " + image.toString() +
        //     "location: " + loc + 
        //     "size: " + getSize().toString()
        // )
    }

}