package state;

import java.awt.Color;

import GUI.GUIPomodoro;
import components.PauseButton;
import components.SkipButton;

public class Break extends PomodoroState {
    
    public Break(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

//    @Override
//    protected int getTimer() {
//        return 10;
//    }
//
//    @Override
//    public PomodoroState nextState() {
//        currentStateNumber++;
//        return new Work(currentStateNumber);
//    }
//
//    @Override
//    protected Color getColor() {
//        return new Color(7, 153, 146);
//    }

	@Override
	public void setBackGroundColor() {
		// TODO Auto-generated method stub
		guiPomodoro.contentPane.setBackground(new Color(7, 153, 146));
		guiPomodoro.viewStatsPane.setBackground(new Color(7, 153, 146));
	}

	@Override
	public void setDisplayComponents() {
		// TODO Auto-generated method stub
		guiPomodoro.btnPause.setVisible(!guiPomodoro.btnPause.isVisible());
		guiPomodoro.btnSkip.setVisible(!guiPomodoro.btnSkip.isVisible());
	}
}
