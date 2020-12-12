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
	public JPanel contentPane, actionPane, statePane, viewStatsPane,indicatorPane;
	public Button btnPlay, btnPause, btnSkip;
	private PomodoroState pomodoroState;
	private ActionButtonState mState;

	private static GUIPomodoro instance;
	
	private GUIPomodoro() {			
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		createComponents();
	
		pomodoroState = new Work(this);
		mState = new PlayState();

		contentPane.add(timerLabel);
		contentPane.add(actionPane);
		contentPane.add(indicatorPane);
		contentPane.add(viewStatsPane);
		
		frame = new PomodoroFrame().getFrame();
		frame.add(contentPane);
	}

	private void createComponents() {
		timerLabel = PomodoroTimer.getInstance();
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

		indicatorPane = IndicatorPane.getInstance().getStatePane();
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
		pomodoroState = pomodoroState.nextState();
		PomodoroTimer.getInstance().refreshTimerText(pomodoroState.getTimer());
	}

	public void switchActionState() {
		mState = mState.switchState();
	}
}
