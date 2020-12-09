package state;

import java.awt.Color;

import GUI.GUIPomodoro;

public abstract class PomodoroState {

    protected GUIPomodoro guiPomodoro;
     
    public PomodoroState(GUIPomodoro guiPomodoro) {
        this.guiPomodoro = guiPomodoro;
        
        setBackGroundColor();
        setDisplayComponents();
    }
    
    public abstract void setBackGroundColor();
    public abstract void setDisplayComponents();
    public abstract int getTimer();
    public abstract PomodoroState nextState();
}
