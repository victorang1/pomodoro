package state;

import java.awt.Color;

public class Work extends PomodoroState {
    
    public Work(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected Double getTimer() {
        return 25.0;
    }

    @Override
    public PomodoroState nextState() {
        if (currentStateNumber == 4) {
            return new LongBreak(currentStateNumber);
        }
        else {
            return new Break(currentStateNumber);
        }
    }

    @Override
    protected Color getColor() {
        return new Color(229, 80, 57);
    }
}
