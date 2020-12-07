package state;

import java.awt.Color;

public class Work extends PomodoroState {
    
    public Work(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected int getTimer() {
        return 25;
	}
	
	@Override
	protected Color getColor() {
		return Color.RED;
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
}
