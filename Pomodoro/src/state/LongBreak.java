package state;

public class LongBreak extends Break {
    
    public LongBreak(Integer currentStateNumber) {
        super(currentStateNumber);
    }

    @Override
    protected int getTimer() {
        return 50;
    }

    @Override
    public PomodoroState nextState() {
        return new Work(1);
    }
}
