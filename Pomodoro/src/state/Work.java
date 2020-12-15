package state;

import java.awt.Color;

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
	public PomodoroState nextState(GUIPomodoro guiPomodoro) {
		IndicatorPane indicatorPane = ((IndicatorPane)guiPomodoro.getIndicatorPane());
		
		if (indicatorPane.getCurrentIndex() != 0 && indicatorPane.getCurrentIndex() % 3 == 0)
			return new LongBreak(guiPomodoro);
	
		else 
			return new Break(guiPomodoro);
		
	}

	@Override
	public void setBackGroundColor(GUIPomodoro guiPomodoro) {
		guiPomodoro.getContentPane().setBackground(new Color(229, 80, 57));
	}

	@Override
	public void setDisplayComponents(GUIPomodoro guiPomodoro) {
		guiPomodoro.getBtnPause().setVisible(true);
		guiPomodoro.getBtnSkip().setVisible(false);
	}

    public String getNotes() {
        return "Thankyou for working";
    }

	@Override
	public void setIndicatorPane(GUIPomodoro guiPomodoro) {
		// TODO Auto-generated method stub
        ((IndicatorPane)guiPomodoro.getIndicatorPane()).setCurrentDotToWork();
	}
}
