package state;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.ContentPane;
import components.TimeClass;

public class Break extends PomodoroState {
    
    public Break(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected int getTimer() {
        return 10;
    }

    @Override
    public PomodoroState nextState() {
        currentStateNumber++;
        return new Work(currentStateNumber);
    }

    @Override
    protected Color getColor() {
        return new Color(7, 153, 146);
    }
}
