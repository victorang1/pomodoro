package action;

import javax.swing.Timer;

import GUI.GUIPomodoro;

public class PauseAction implements ActionCommand {

    public PauseAction() {

    }
    
    @Override
    public void execute() {
        GUIPomodoro.getInstance().switchActionState();
        GUIPomodoro.getInstance().getTimerLabel().getTimer().stop();
    }
}
