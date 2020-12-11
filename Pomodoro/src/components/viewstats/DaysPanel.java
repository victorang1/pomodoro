package components.viewstats;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class DaysPanel extends JPanel {
    
    private JLabel days;
    private CounterLabel counterLabel;

    public DaysPanel(JLabel days, CounterLabel counterLabel) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(days);
        add(Box.createRigidArea(new Dimension(0,5)));
        setPreferredSize(new Dimension(45, 45));
        setMaximumSize(new Dimension(45, 45));
        add(counterLabel);
        this.days = days;
        this.counterLabel = counterLabel;
    }

    public void updateCounter() {
        this.counterLabel.increaseCounter();
    }
}
