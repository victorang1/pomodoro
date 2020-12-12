package listener;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import action.PauseAction;
import components.PomodoroTimer;

public class PauseButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        Timer timer = PomodoroTimer.getInstance().getTimer();
        return new CustomButtonListener(new PauseAction(timer));
    }
}
