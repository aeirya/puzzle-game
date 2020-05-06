package app;

import model.board.Board;
import model.board.BoardFactory;
import controller.GameController;
import util.config.Config;
import util.config.ConfigLoader;

public class Game {
    
    private boolean isFinished = false;
    private GameController controller;

    public Game(Board board) {
        controller = new GameController(this, board);
        update();
    }

    public static void main(String[] args) {
        Config config = ConfigLoader.getConfig(); //singleton
        Board board = BoardFactory.getInstance().provide(config).build();
        new Game(board);
    }

    private void update() {
        Waiter.doWait();
        controller.update();
        if (!isFinished) update();
    }

    public void quit() {
        isFinished = true;
    }

    private static class Waiter {
        private static final int FPS = 30;
        
        private static void doWait() {
            try {
                Thread.sleep(1000 / FPS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}