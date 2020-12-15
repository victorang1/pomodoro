package state.buttonstate;

import GUI.GUIPomodoro;

public class PlayState extends ActionButtonState {
    
    public PlayState(GUIPomodoro guiPomodoro) {
		super(guiPomodoro);
		// TODO Auto-generated constructor stub
	}

	@Override
    public ActionButtonState switchState(GUIPomodoro guiPomodoro) {
        return new PauseState(guiPomodoro);
    }
    
	@Override
	public void setButtonsVisibility(GUIPomodoro guiPomodoro) {
		// TODO Auto-generated method stub
		guiPomodoro.getBtnPause().setVisible(true);
		guiPomodoro.getBtnPlay().setVisible(false);
	}
	
}
