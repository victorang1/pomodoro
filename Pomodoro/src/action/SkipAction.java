package action;

import GUI.GUIPomodoro;

public class SkipAction implements ActionCommand {
    
    @Override
    public void execute() {
        GUIPomodoro.changeState();
    }
}
