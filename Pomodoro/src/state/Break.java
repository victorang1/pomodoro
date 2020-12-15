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
		return Config.BREAK_TIME;
	}

	@Override

	public PomodoroState nextState(GUIPomodoro guiPomodoro) {
		return new Work(guiPomodoro);	
	}
	
	@Override
	public void setBackGroundColor(GUIPomodoro guiPomodoro) {
		GUIPomodoro.getInstance().getContentPane().setBackground(new Color(7, 153, 146));
	}

	@Override
	public void setDisplayComponents(GUIPomodoro guiPomodoro) {
		GUIPomodoro.getInstance().getBtnPause().setVisible(true);
		GUIPomodoro.getInstance().getBtnSkip().setVisible(true);
	}

	@Override
	public void setIndicatorPane(GUIPomodoro guiPomodoro) {
		// TODO Auto-generated method stub
		 ((IndicatorPane)GUIPomodoro.getInstance().getIndicatorPane()).setCurrentDotToBreak();
	}
}
