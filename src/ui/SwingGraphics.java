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
    private Drawable drawable;

    public SwingGraphics() {
        frame = new JFrame();  
        panel = new JPanel() {
            private static final long serialVersionUID = 1L;
            @Override
            public void paintComponent(final Graphics g) {
                super.printComponents(g);
                draw(g);
            }
        };
        prompter = new Prompter(frame);
        setup();
    }

    public void prompt(final String msg, final String title, final int type) {
        prompter.prompt(msg, title, type);
    }

    public void update(final Drawable drawable) {
        this.drawable = drawable;
        EventQueue.invokeLater(this::repaint);
    }

    protected void draw(final Graphics g) {
        if (drawable != null)
            drawable.draw(g);
    }

    protected void repaint() {
        panel.repaint();
        frame.repaint();
    }

    public void setup() {
        initiateFrame();
    }

    public void addKeyListener(final KeyListener listener) {
        frame.addKeyListener(listener);
    }

    private void initiateFrame() {
        frame.setLocation(panel.getLocation());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSizes();
        frame.add(panel);
        frame.setBackground(new java.awt.Color(50, 50, 50));
        frame.setVisible(true);
    }

    private void setSizes() {
        final Dimension size = IGameGraphics.getScreenSize();
        panel.setSize(size);
        frame.setSize(panel.getSize());
        final int maxSize = Math.max(size.width, size.height) / 3;
        panel.setLocation(size.width / 2 - maxSize / 2, size.height / 2 - maxSize / 2);
    }
}