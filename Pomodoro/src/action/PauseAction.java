package action;

import javax.swing.Timer;

import GUI.GUIPomodoro;

public class PauseAction implements ActionCommand {

    private Timer timer;

    public PauseAction(Timer timer) {
        this.timer = timer;
    }
    
    @Override
    public void execute() {
        GUIPomodoro.getInstance().switchActionState();
        timer.stop();
    }
}
