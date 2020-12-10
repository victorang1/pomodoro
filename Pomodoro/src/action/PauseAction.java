package action;

import javax.swing.Timer;

public class PauseAction implements ActionCommand {

    private Timer timer;

    public PauseAction(Timer timer) {
        this.timer = timer;
    }
    
    @Override
    public void execute() {
        timer.stop();
    }
}
