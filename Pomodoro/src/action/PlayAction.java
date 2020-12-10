package action;

import javax.swing.Timer;

public class PlayAction implements ActionCommand {

    private Timer timer;

    public PlayAction(Timer timer) {
        this.timer = timer;
    }
    
    @Override
    public void execute() {
        timer.start();
    }
}
