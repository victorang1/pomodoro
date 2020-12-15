package listener;

import java.awt.event.ActionListener;
import action.PauseAction;

public class PauseButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        return new CustomButtonListener(new PauseAction());
    }

}
