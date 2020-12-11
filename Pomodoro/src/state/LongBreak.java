package state;

import GUI.GUIPomodoro;

import components.IndicatorPane;

public class LongBreak extends Break {
    
    public LongBreak(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

    @Override
    public int getTimer() {
        return Config.LONG_BREAK;
    }

    @Override
    public PomodoroState nextState() {
        IndicatorPane.getInstance().resetCycle();
		return new Work(guiPomodoro);
    }
}
