package model.board;

import model.Location;
import model.interfaces.Drawable;
import test.LoudPuzzlePieceView;

import java.awt.Graphics;
import java.awt.Image;

public class PuzzlePiece implements Drawable {
    private Image img;
    private Location location;
    private int pieceNumber;
    private Drawable view;
    
    public PuzzlePiece(Image img, Location location, int pieceIdentifier) {
        this.img = img;
        this.location = location;
        this.view = new PuzzlePieceView(img, location);
        // this.view = new LoudPuzzlePieceView(img, location);
        this.pieceNumber = pieceIdentifier;
    }

    public int getPieceNumber() {
        return pieceNumber;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public Image getImage() {
        return img;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public PuzzlePiece getClone() {
        return new PuzzlePiece(img, location, pieceNumber);
    }

    public void swap(PuzzlePiece other) {
        this.setImage(other.getImage());
        this.setPieceNumber(other.getPieceNumber());
    }

    public void draw(Graphics g) {
        view.draw(g);
    }
}

