package controller;

import app.Game;
import controller.input.MyKeyListener;
import model.board.Board;
import ui.IGameGraphics;
import ui.SwingGraphics;
import ui.prompter.MsgType;


public class GameController {
    
    private final IGameGraphics graphics;
    private final Game game;
    private final Board board;

    public GameController(Game game, Board board) {
        this.board = board;
        graphics = new SwingGraphics();
        graphics.addKeyListener(
            new MyKeyListener(board.getController())
        );
        this.game = game;
        check(board);
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

    public void update() {
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