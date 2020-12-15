package action;

import GUI.GUIPomodoro;

public class PlayAction implements ActionCommand {

    public PlayAction() {

    }
    
    @Override
    public void execute() {
        GUIPomodoro.getInstance().switchActionState();
        GUIPomodoro.getInstance().getTimerLabel().getTimer().start();
    }
}
