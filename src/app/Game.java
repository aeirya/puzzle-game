package app;

import model.board.Board;
import model.board.BoardFactory;
import controller.BoardController;
import controller.IBoardController;
import controller.GameController;
import util.config.Config;
import util.config.ConfigLoader;

public class Game {
    
    private GameController controller;
    private final Board board;
    private boolean isFinished = false;

    public Game(Board board) {
        this.board = board;
        start();
        update();
    }

    public static void main(String[] args) {
        Config config = ConfigLoader.getConfig(); //singleton
        IBoardController controller = new BoardController(7);
        Board board = BoardFactory.getInstance().provide(config, controller).build();
        new Game(board);
    }

    private void start() {
        controller = new GameController(this, board);
    }

    private void update() {
        Waiter.doWait();
        controller.update(board);
        if (!isFinished) update();
    }

    public void quit() {
        isFinished = true;
    }

    private static class Waiter {
        private static final int FPS = 60;
        
        private static void doWait() {
            try {
                Thread.sleep(1000 / FPS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}