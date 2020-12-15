package state;

import GUI.GUIPomodoro;

public abstract class PomodoroState {
     
    public PomodoroState(GUIPomodoro guiPomodoro) {        
        setBackGroundColor(guiPomodoro);
        setDisplayComponents(guiPomodoro);
        setIndicatorPane(guiPomodoro);
    }
    
    public abstract void setBackGroundColor(GUIPomodoro guiPomodoro);
    public abstract void setDisplayComponents(GUIPomodoro guiPomodoro);
    public abstract void setIndicatorPane(GUIPomodoro guiPomodoro);
    
    public abstract int getTimer();
    public abstract PomodoroState nextState(GUIPomodoro guiPomodoro);
}
