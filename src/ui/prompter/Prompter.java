package ui.prompter;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Prompter {
    
    private Component component;

    public Prompter(Component comp) {
        this.component = comp;
    }

    public void prompt(String message, String title , int messageType) {
        JOptionPane.showMessageDialog(component, message, title, messageType);
    }
}