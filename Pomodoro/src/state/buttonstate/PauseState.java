package state.buttonstate;

import GUI.GUIPomodoro;

public class PauseState extends ActionButtonState {
    
    @Override
    public ActionButtonState switchState() {
        GUIPomodoro.getInstance().btnPause.setVisible(true);
        GUIPomodoro.getInstance().btnPlay.setVisible(false);
        return new PlayState();
    }
}
