package action;

import GUI.ViewStat;

public class ViewStatsAction implements ActionCommand {
    
    @Override
    public void execute() {
        ViewStat.getInstance().openFrame();
    }
}