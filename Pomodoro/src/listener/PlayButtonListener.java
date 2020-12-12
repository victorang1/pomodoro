package listener;

import java.awt.event.ActionListener;

import javax.swing.Timer;
import action.PlayAction;
import components.PomodoroTimer;

public class PlayButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        Timer timer = PomodoroTimer.getInstance().getTimer();
        return new CustomButtonListener(new PlayAction(timer));
    }
}
