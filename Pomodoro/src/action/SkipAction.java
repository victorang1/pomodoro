package action;

import javax.swing.Timer;

import GUI.GUIPomodoro;
import state.buttonstate.PlayState;

public class SkipAction implements ActionCommand {
    private Timer timer;

    public SkipAction(Timer timer) {
        this.timer = timer;
    }
    @Override
    public void execute() {
        
        GUIPomodoro.getInstance().update();
        
        if(!timer.isRunning())
        	timer.start();
        
        GUIPomodoro.getInstance().resetMState();
    }
}
