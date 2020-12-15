package listener;

import java.awt.event.ActionListener;
import action.ViewStatsAction;

public class ViewStatsButtonListener implements ButtonListener {
    
    @Override
    public ActionListener getListener() {
        return new CustomButtonListener(new ViewStatsAction());
    }
}