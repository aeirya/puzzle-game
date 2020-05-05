package controller;

import app.Game;
import controller.input.MyKeyListener;
import model.board.Board;
import model.interfaces.Updatable;
import ui.IGameGraphics;
import ui.SwingGraphics;
import ui.prompter.MsgType;


public class GameController implements Updatable <Board> {
    
    private final IGameGraphics graphics;
    private final Game game;

    public GameController(Game game, Board board) {
        graphics = new SwingGraphics();
        graphics.addKeyListener(
            new MyKeyListener(board.getController())
        );
        this.game = game;
        check(board);
        update(board);
    }
    
    private void check(Board board) {
        if (!board.isSolvable()) {
            graphics.prompt(
                "this puzzle is not solvable, change your config and try again",
                "Puzzle not solvable",
                MsgType.WARNING
            );
            game.quit();
        }
    }

    public void update(Board board) {
        graphics.update(board);
        if (board.isGameFinished()) {
            graphics.prompt(
                "You finished the game, congratulation",
                "game finished",
                MsgType.NOTIFICATION
            );
            game.quit();
        }
    }
}