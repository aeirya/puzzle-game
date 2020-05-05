package ui.prompter;

import javax.swing.JOptionPane;

public enum MsgType {
    WARNING(JOptionPane.WARNING_MESSAGE)
    , NOTIFICATION(JOptionPane.INFORMATION_MESSAGE);

    private int type;

    MsgType(int type) {
        this.type = type;
    }

    public int toInt() {
        return type;
    }
}