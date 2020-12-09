package state;

import java.awt.Color;

import GUI.GUIPomodoro;
import components.IndicatorPane;

public class Break extends PomodoroState {
    
    public Break(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

	@Override
	public int getTimer() {
		return 2;
	}

	@Override
	public PomodoroState nextState() {
		IndicatorPane.getInstance().incrementCycle();
		return new Work(guiPomodoro);
	}
	

	@Override
	public void setBackGroundColor() {
		guiPomodoro.contentPane.setBackground(new Color(7, 153, 146));
	}

	@Override
	public void setDisplayComponents() {
		guiPomodoro.btnPause.setVisible(!guiPomodoro.btnPause.isVisible());
		guiPomodoro.btnSkip.setVisible(!guiPomodoro.btnSkip.isVisible());
	}
}
