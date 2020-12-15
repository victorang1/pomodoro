package state.buttonstate;

import GUI.GUIPomodoro;

public class PauseState extends ActionButtonState {
    
    public PauseState(GUIPomodoro guiPomodoro) {
		super(guiPomodoro);

	}

	@Override
    public ActionButtonState switchState(GUIPomodoro guiPomodoro) { 
        return new PlayState(guiPomodoro);
    }

	@Override
	public void setButtonsVisibility(GUIPomodoro guiPomodoro) {
		// TODO Auto-generated method stub
		 GUIPomodoro.getInstance().getBtnPause().setVisible(false);
	     GUIPomodoro.getInstance().getBtnPlay().setVisible(true);
	}
}
