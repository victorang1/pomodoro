package components.viewstats;

import javax.swing.JLabel;

public class CounterLabel extends JLabel {

    private Integer currentCounter = 0;

    public CounterLabel(int newCounter) {
        currentCounter = newCounter;
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