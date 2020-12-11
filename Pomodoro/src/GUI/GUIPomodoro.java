package GUI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import action.CustomButtonListener;
import action.PauseAction;
import action.PlayAction;
import action.SkipAction;
import action.ViewStatsAction;
import components.buttons.Button;
import components.buttons.PauseButton;
import components.buttons.PlayButton;
import components.buttons.SkipButton;
import components.buttons.ViewStatsButton;
import components.IndicatorPane;
import components.frame.PomodoroFrame;
import components.TimeClass;
import event.Observer;
import state.PomodoroState;
import state.Work;
import state.buttonstate.ActionButtonState;
import state.buttonstate.PlayState;

public class GUIPomodoro implements Observer {

	private JFrame frame;
	private TimeClass timerLabel;
	public JPanel contentPane, actionPane, statePane, viewStatsPane,indicatorPane;
	public Button btnPlay, btnPause, btnSkip;
	private PomodoroState pomodoroState;
	private ActionButtonState mState;

	private static GUIPomodoro instance;
	
	private GUIPomodoro() {			
		//init main pane
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		//create all the components
		createComponents();
		
		//set the state
//		podomoroState = new Break(this);
		pomodoroState = new Work(this);
		mState = new PlayState();
		
		//populate main content
		contentPane.add(timerLabel);
		contentPane.add(actionPane);
		contentPane.add(indicatorPane);
		contentPane.add(viewStatsPane);
		
		frame = new PomodoroFrame().getFrame();
		frame.add(contentPane);
	}

	private void createComponents() {
		//create timer
		timerLabel = TimeClass.getInstance();
		timerLabel.addObserver(this);
		timerLabel.addObserver(ViewStat.getInstance());

		//create action button
		Timer pomodoroTimer = TimeClass.getInstance().getTimer();
		btnPause = new PauseButton(new CustomButtonListener(new PauseAction(pomodoroTimer)));
		btnSkip = new SkipButton(new CustomButtonListener(new SkipAction()));
		btnPlay = new PlayButton(new CustomButtonListener(new PlayAction(pomodoroTimer)));
		
		actionPane = new JPanel();
		actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
		actionPane.setOpaque(false);
		actionPane.add(btnPause);
		actionPane.add(btnPlay);
		actionPane.add(btnSkip);

		//create view state 
		viewStatsPane = new JPanel();
		viewStatsPane.setLayout(new BoxLayout(viewStatsPane, BoxLayout.LINE_AXIS));
		viewStatsPane.setOpaque(false);
		viewStatsPane.add(Box.createHorizontalGlue());
		viewStatsPane.add(new ViewStatsButton(new CustomButtonListener(new ViewStatsAction())));

		//create CycleIndicator
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
		pomodoroState = pomodoroState.nextState();
		TimeClass.getInstance().refreshTimerText(pomodoroState.getTimer());
	}

	public void switchActionState() {
		mState = mState.switchState();
	}
}
