package state;

import GUI.GUIPomodoro;
import java.awt.Color;
import components.IndicatorPane;

public class LongBreak extends Break {
    
    public LongBreak(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

    @Override
    public int getTimer() {
        return 7;
    }

    @Override
    public PomodoroState nextState() {
        IndicatorPane.getInstance().resetCycle();
		return new Work(guiPomodoro);
    }
}
