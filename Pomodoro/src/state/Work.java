package state;

import java.awt.Color;

import GUI.GUIPomodoro;

public class Work extends PomodoroState {
    
    public Work(GUIPomodoro guiPomodoro) {
        super(guiPomodoro);
    }

//    @Override
//    protected int getTimer() {
//        return 25;
//	}
//	
//	@Override
//	protected Color getColor() {
//		return Color.RED;
//	}
//
//    @Override
//    public PomodoroState nextState() {
//        if (currentStateNumber == 4) {
//            return new LongBreak(currentStateNumber);
//        }
//        else {
//            return new Break(currentStateNumber);
//        }
//    }

	@Override
	public void setBackGroundColor() {
		// TODO Auto-generated method stub
		guiPomodoro.contentPane.setBackground(new Color(229, 80, 57));
		guiPomodoro.viewStatsPane.setBackground(new Color(229, 80, 57));
	}

	@Override
	public void setDisplayComponents() {
		// TODO Auto-generated method stub
		guiPomodoro.btnPause.setVisible(!guiPomodoro.btnPause.isVisible());
	}
}
