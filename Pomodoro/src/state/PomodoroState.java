package state;

import java.awt.Color;

public abstract class PomodoroState {

    protected Integer currentStateNumber;

    protected abstract Double getTimer();
    protected abstract Color getColor();
    public abstract PomodoroState nextState();
    
    public PomodoroState(Integer currentStateNumber) {
        this.currentStateNumber = currentStateNumber;
    }
}
