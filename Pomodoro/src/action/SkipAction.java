package action;

import GUI.GUIPomodoro;

public class SkipAction implements ActionCommand {

    private GUIPomodoro stateHolder;

    public SkipAction(GUIPomodoro stateHolder) {
        this.stateHolder = stateHolder;
    }
    
    @Override
    public void execute() {
        stateHolder.update();
    }
}
