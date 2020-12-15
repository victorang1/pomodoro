package action;


import GUI.GUIPomodoro;

public class SkipAction implements ActionCommand {

    public SkipAction() {
    }
    @Override
    public void execute() {
        
        GUIPomodoro.getInstance().update();
        
        if(!GUIPomodoro.getInstance().getTimerLabel().getTimer().isRunning())
        	GUIPomodoro.getInstance().getTimerLabel().getTimer().start();
        
        GUIPomodoro.getInstance().resetMState();
    }
}
