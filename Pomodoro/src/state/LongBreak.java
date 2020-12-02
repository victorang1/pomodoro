package state;

import java.awt.Color;

public class LongBreak extends PomodoroState {
    
    public LongBreak(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected Double getTimer() {
        return 30.0;
    }

    @Override
    public PomodoroState nextState() {
        return new Work(0);
    }

    @Override
    protected Color getColor() {
        return new Color(229, 80, 57);
    }
}
