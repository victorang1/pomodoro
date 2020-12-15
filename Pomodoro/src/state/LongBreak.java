package state;

import GUI.GUIPomodoro;

import components.IndicatorPane;

public class LongBreak extends Break {
    
    public LongBreak(GUIPomodoro guiPomodoro){
    	super(guiPomodoro);
    }

    @Override
    public int getTimer() {
        return Config.LONG_BREAK;
    }

    @Override
    public PomodoroState nextState(GUIPomodoro guiPomodoro) {
    	((IndicatorPane) GUIPomodoro.getInstance().getIndicatorPane()).resetCycle();
		return new Work(guiPomodoro);
    }
   
}
