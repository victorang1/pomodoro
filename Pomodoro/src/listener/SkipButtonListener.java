package listener;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import action.SkipAction;
import components.PomodoroTimer;

public class SkipButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
    	Timer timer = PomodoroTimer.getInstance().getTimer();
        return new CustomButtonListener(new SkipAction(timer));
    }
}