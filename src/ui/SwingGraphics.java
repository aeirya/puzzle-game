package ui;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.KeyListener;
import model.interfaces.Drawable;
import ui.prompter.Prompter;

public class SwingGraphics implements IGameGraphics {

    private final JFrame frame;
    private final JPanel panel;
    private final Prompter prompter;
    protected Drawable drawable;

    public SwingGraphics() {
        frame = new JFrame();  
        panel = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            public void paintComponent(Graphics g) {
                super.printComponents(g);
                draw(g);
            }
        };
        prompter = new Prompter(frame);
        setup();
    }

    public void prompt(String msg, String title, int type) {
        prompter.prompt(msg, title, type);
    }

    public void update(Drawable drawable) {
        this.drawable = drawable;
        EventQueue.invokeLater( 
                this::repaint
            );
    }
    
    protected void draw(Graphics g) {
        if (drawable != null) drawable.draw(g);
    }

    protected void repaint() {
        panel.repaint();
        frame.repaint();
    }

    public void setup() {
        initiateFrame();
    }

    public void addKeyListener(KeyListener listener) {
        frame.addKeyListener(listener);
    }

    private void initiateFrame() {
        frame.setLocation(panel.getLocation());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSizes();
        frame.add(panel);
        frame.setVisible(true);
    }

    private void setSizes() {
        Dimension size = IGameGraphics.getScreenSize();
        panel.setSize(size);
        frame.setSize(panel.getSize());
        int maxSize = Math.max(size.width, size.height) / 3;
        panel.setLocation(size.width / 2 - maxSize / 2, size.height / 2 - maxSize / 2);
    }
}