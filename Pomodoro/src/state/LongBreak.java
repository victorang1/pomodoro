package state;

import GUI.GUIPomodoro;
import java.awt.Color;

public class LongBreak extends Break {
    
    public LongBreak(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

    @Override
    public int getTimer() {
        return 3;
    }
}
