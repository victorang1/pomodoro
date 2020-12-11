package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import components.frame.StatsFrame;
import components.viewstats.ViewStatsPanel;
import event.Observer;
import state.Break;
import state.LongBreak;
import state.PomodoroState;
import util.LogsUtil;

public class ViewStat implements Observer {

	private static ViewStat instance;
	private JFrame statsFrame;
	private JPanel outerPanel;
	private boolean isOpen = false;
	
	private ViewStat() {
		LogsUtil.getInstance().readLog();
		outerPanel = new ViewStatsPanel();
		statsFrame = new StatsFrame(outerPanel).getFrame();
		statsFrame.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e) {
                isOpen = false;
            }
		});
	}

	public synchronized static ViewStat getInstance() {
		if (instance == null) {
			instance = new ViewStat();
		}
		return instance;
	}

	@Override
	public void update() {
		if (shouldUpdate()) {
			((ViewStatsPanel) outerPanel).updateCounter();
		}
	}
	
	public void openFrame() {
		if (!isOpen) {
			statsFrame.setVisible(true);
		}
	}

	private boolean shouldUpdate() {
		PomodoroState mState = GUIPomodoro.getInstance().getCurrentState();
		return mState instanceof LongBreak || mState instanceof Break;
	}
}
