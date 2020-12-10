package state;

import java.awt.Color;

import state.Config;
import GUI.GUIPomodoro;
import components.IndicatorPane;

public class Work extends PomodoroState {
    
    public Work(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

	@Override
	public int getTimer() {
       return Config.WORK_TIME;
	}

	@Override
	public PomodoroState nextState() {
		IndicatorPane.getInstance().incrementCycle();
		if (IndicatorPane.getInstance().getCurrentIndex() % 8 == 0) {
			return new LongBreak(guiPomodoro);
		}
		else {
			return new Break(guiPomodoro);
		}
	}

	@Override
	public void setBackGroundColor() {
		guiPomodoro.contentPane.setBackground(new Color(229, 80, 57));
	}

	@Override
	public void setDisplayComponents() {
		guiPomodoro.btnPause.setVisible(true);
		guiPomodoro.btnSkip.setVisible(false);
	}
}
