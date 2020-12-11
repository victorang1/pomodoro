package state.buttonstate;

import GUI.GUIPomodoro;

public class PlayState extends ActionButtonState {
    
    @Override
    public ActionButtonState switchState() {
        GUIPomodoro.getInstance().btnPause.setVisible(false);
        GUIPomodoro.getInstance().btnPlay.setVisible(true);
        return new PauseState();
    }
}
