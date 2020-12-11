package components.viewstats;

import javax.swing.JLabel;

public class CounterLabel extends JLabel {

    private Integer currentCounter;

    public CounterLabel() {
        currentCounter = 0;
        updateText();
    }

    public void increaseCounter() {
        currentCounter++;
        updateText();
    }

    public void updateText() {
        setText(currentCounter.toString());
    }
}