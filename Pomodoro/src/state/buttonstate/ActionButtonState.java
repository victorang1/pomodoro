package state.buttonstate;

import GUI.GUIPomodoro;

public abstract class ActionButtonState {
	
	public ActionButtonState(GUIPomodoro guiPomodoro) {
		setButtonsVisibility(guiPomodoro);
	}
    public abstract ActionButtonState switchState(GUIPomodoro guiPomodoro);
    
    public abstract void setButtonsVisibility(GUIPomodoro guiPomodoro);
    
}
