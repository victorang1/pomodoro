package GUI;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.buttons.Button;
import components.buttons.PauseButton;
import components.buttons.PlayButton;
import components.buttons.SkipButton;
import components.buttons.ViewStatsButton;
import components.IndicatorPane;
import components.PomodoroFrame;
import components.TimeClass;
import event.Observer;
import state.PomodoroState;
import state.Work;

public class GUIPomodoro implements Observer {

	public JFrame frame;
	public TimeClass timerLabel;
	public JPanel contentPane, actionPane, statePane, viewStatsPane,indicatorPane;
	public Button btnPlay, btnPause, btnSkip;
	public Timer timer;
	private PomodoroState pomodoroState;
	
	public GUIPomodoro() {			
		//init main pane
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		//create all the components
		createComponents();
		
		//set the state
//		podomoroState = new Break(this);
		pomodoroState = new Work(this);
		
		//populate main content
		contentPane.add(timerLabel);
		contentPane.add(actionPane);
		contentPane.add(indicatorPane);
		contentPane.add(viewStatsPane);
		
		frame = new PomodoroFrame();
		frame.add(contentPane);
	}

	private void createComponents() {
		//create timer
		timerLabel = TimeClass.getInstance();
		timerLabel.addObserver(this);

		//create action button
		btnPause = new PauseButton();
		btnSkip = new SkipButton(this);
		btnPlay = new PlayButton();
		
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
		viewStatsPane.add(new ViewStatsButton());

		//create CycleIndicator
		indicatorPane = IndicatorPane.getInstance().getStatePane();
	}

	@Override
	public void update() {
		pomodoroState = pomodoroState.nextState();
		timerLabel.refreshTimerText(pomodoroState.getTimer());
	}	
//	public static void main(String[] args) {
//		new GUIPomodoro();
//	}
}
