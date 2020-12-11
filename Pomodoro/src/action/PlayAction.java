package action;

import javax.swing.Timer;

import GUI.GUIPomodoro;

public class PlayAction implements ActionCommand {

    private Timer timer;

    public PlayAction(Timer timer) {
        this.timer = timer;
    }
    
    @Override
    public void execute() {
        GUIPomodoro.getInstance().switchActionState();
        timer.start();
    }
}
