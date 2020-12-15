package listener;

import java.awt.event.ActionListener;

import action.PlayAction;

public class PlayButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        return new CustomButtonListener(new PlayAction());
    }
   
}

