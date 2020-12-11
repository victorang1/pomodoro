package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.frame.StatsFrame;
import components.viewstats.ViewStatsPanel;
import event.Observer;
import state.LongBreak;

public class ViewStat implements Observer {

	private static ViewStat instance;
	private JFrame statsFrame;
	private JPanel outerPanel;
	
	private ViewStat() {
		outerPanel = new ViewStatsPanel();
	}

	public synchronized static ViewStat getInstance() {
		if (instance == null) {
			instance = new ViewStat();
		}
		return instance;
	}

	@Override
	public void update() {
		if (GUIPomodoro.getInstance().getCurrentState() instanceof LongBreak) {
			((ViewStatsPanel) outerPanel).updateCounter();
		}
	}
	
	public void openFrame() {
		statsFrame = new StatsFrame(outerPanel).getFrame();
	}
}
