package GUI;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.IndicatorPane;
import components.PauseButton;
import components.PlayButton;
import components.PomodoroFrame;
import components.SkipButton;
import components.TimeClass;
import event.Observer;
import state.Break;
import state.PomodoroState;
import state.Work;

public class GUIPomodoro implements Observer {
	public JFrame frame;
	public JLabel label, viewStatsLabel;
	public TimeClass timerLabel;
	public JPanel contentPane, actionPane, statePane, viewStatsPane,indicatorPane;
	public JButton btnPlay, btnPause, btnSkip;
	public Timer timer;
	int count=1;
	public ArrayList<JLabel> circleIndicator = new ArrayList<>();
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
		timerLabel = new TimeClass();
		timerLabel.addObserver(this);

		//create action button
		btnPause = new PauseButton().getButton();
		btnSkip = new SkipButton().getButton();
		btnPlay = new PlayButton().getButton();
		
		btnPause.setVisible(false);
		btnSkip.setVisible(false);
		btnPlay.setVisible(false);
		
		actionPane = new JPanel();
		actionPane.setLayout(new BoxLayout(actionPane, BoxLayout.LINE_AXIS));
		actionPane.setOpaque(false);
		actionPane.add(btnPause);
		actionPane.add(btnPlay);
		actionPane.add(btnSkip);

		
		//create view state 
		viewStatsPane = new JPanel();
		viewStatsPane.setLayout(new BoxLayout(viewStatsPane, BoxLayout.LINE_AXIS));
		viewStatsLabel = new JLabel("view stats");
		viewStatsLabel.setForeground(Color.BLACK);
		viewStatsPane.setOpaque(false);
		viewStatsPane.add(Box.createHorizontalGlue());
		viewStatsPane.add(viewStatsLabel);

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
