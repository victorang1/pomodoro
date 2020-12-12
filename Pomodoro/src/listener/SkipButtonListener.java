package listener;

import java.awt.event.ActionListener;

import action.SkipAction;

public class SkipButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        return new CustomButtonListener(new SkipAction());
    }
}