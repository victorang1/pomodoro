//package Default;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Font;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//import components.ContentPane;
//import components.PauseButton;
//import components.PomodoroFrame;
//import components.SkipButton;
//import components.TimeClass;
//import state.PomodoroState;
//
//public class GUIPomodoro {
//	public JFrame frame;
//	public JLabel label, viewStatsLabel;
//	public TimeClass timerLabel;
//	public JPanel contentPane, actionPane, statePane, viewStatsPane;
//	public JButton btnPlay, btnPause, btnSkip;
//	public Timer timer;
//	int count=1;
//	public ArrayList<JLabel> circleIndicator = new ArrayList<>();
//	private PomodoroState podomoroState;
//	
//	public GUIPomodoro() {
//		contentPane = new JPanel();
//		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
//		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
//		contentPane.setBackground(new Color(229, 80, 57));
//
//		timerLabel = new TimeClass(15);
//		contentPane.add(timerLabel);
//
//		btnPause = new PauseButton().getButton();
//		btnSkip = new SkipButton().getButton();
//		
//		JPanel actionPane = ContentPane.getActionPane(btnPause);
//		
//		contentPane.add(actionPane);
//		
//
//
//		JPanel viewStatsPane = new JPanel();
//		viewStatsPane.setLayout(new BoxLayout(viewStatsPane, BoxLayout.LINE_AXIS));
//		viewStatsPane.setBackground(new Color(229, 80, 57));
//
//		viewStatsLabel = new JLabel("view stats");
//		viewStatsLabel.setForeground(Color.BLACK);
//		viewStatsPane.add(Box.createHorizontalGlue());
//		viewStatsPane.add(viewStatsLabel);
//		contentPane.add(viewStatsPane);
//		
//		frame = new PomodoroFrame();
//		frame.add(contentPane);
//	}
//
//	public static void main(String[] args) {
//		new GUIPomodoro();
//	}
//}
