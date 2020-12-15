package GUI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import components.buttons.Button;
import components.buttons.PauseButton;
import components.buttons.PlayButton;
import components.buttons.SkipButton;
import components.buttons.ViewStatsButton;
import components.IndicatorPane;
import components.PomodoroTimer;
import components.frame.PomodoroFrame;
import event.Observer;
import state.PomodoroState;
import state.Work;
import state.buttonstate.ActionButtonState;
import state.buttonstate.PlayState;
import util.LogsUtil;

public class GUIPomodoro implements Observer {

	private JFrame frame;
	private PomodoroTimer timerLabel;
	private JPanel contentPane, actionPane, viewStatsPane,indicatorPane;
	private Button btnPlay, btnPause, btnSkip;

	private PomodoroState pomodoroState;
	private ActionButtonState mState;

	private static GUIPomodoro instance;
	
	private GUIPomodoro() {			
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		createComponents();
		
		pomodoroState  = new Work(this);
		mState = new PlayState(this);
		
		frame = new PomodoroFrame(contentPane).getFrame();
	}

	private void createComponents() {
		timerLabel = new PomodoroTimer();
		timerLabel.addObserver(this);
		timerLabel.addObserver(ViewStat.getInstance());

		btnPause = new PauseButton();
		btnSkip = new SkipButton();
		btnPlay = new PlayButton();
		
		actionPane = new JPanel();
		actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
		actionPane.setOpaque(false);
		actionPane.add(btnPause);
		actionPane.add(btnPlay);
		actionPane.add(btnSkip);

		viewStatsPane = new JPanel();
		viewStatsPane.setLayout(new BoxLayout(viewStatsPane, BoxLayout.LINE_AXIS));
		viewStatsPane.setOpaque(false);
		viewStatsPane.add(Box.createHorizontalGlue());
		viewStatsPane.add(new ViewStatsButton());

		indicatorPane = new IndicatorPane();
		
		contentPane.add(timerLabel);
		contentPane.add(actionPane);
		contentPane.add(indicatorPane);
		contentPane.add(viewStatsPane);
	}

	public static GUIPomodoro getInstance() {
		if (instance == null) {
			instance = new GUIPomodoro();
		}
		return instance;
	}

	public PomodoroState getCurrentState() {
		return pomodoroState;
	}

	@Override
	public void update() {
		if (pomodoroState instanceof Work) {
			LogsUtil.getInstance().export(((Work) pomodoroState).getNotes());
		}
		
		pomodoroState = pomodoroState.nextState(this);
		timerLabel.refreshTimerText(pomodoroState.getTimer());
	}

	public void switchActionState() {
		mState = mState.switchState(this);
	}
	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getActionPane() {
		return actionPane;
	}

	public JPanel getViewStatsPane() {
		return viewStatsPane;
	}

	public JPanel getIndicatorPane() {
		return indicatorPane;
	}

	public Button getBtnPlay() {
		return btnPlay;
	}

	public Button getBtnPause() {
		return btnPause;
	}

	public Button getBtnSkip() {
		return btnSkip;
	}
	
	public PomodoroTimer getTimerLabel() {
		return timerLabel;
	}

	public PomodoroState getPomodoroState() {
		return pomodoroState;
	}

	public ActionButtonState getmState() {
		return mState;
	}
	
	public void resetMState() {
		this.mState = new PlayState(this);
	}
}
