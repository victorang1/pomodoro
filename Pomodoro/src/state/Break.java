package state;

import java.awt.Color;

public class Break extends PomodoroState {
    
    public Break(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected Double getTimer() {
        return 10.0;
    }

    @Override
    public PomodoroState nextState() {
        return new Work(currentStateNumber++);
    }

    @Override
    protected Color getColor() {
        return Color.blue;
    }
}
