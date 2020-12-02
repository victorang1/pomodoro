import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import components.ContentPane;
import components.PomodoroFrame;
import state.Progress;

public class GUIPomodoro implements ActionListener{

	JFrame frame;
	JLabel label, timerLabel, viewStatsLabel;
	JPanel contentPane, actionPane, statePane;
	JButton btnPlay, btnPause, btnSkip;
	Timer timer;
	int count=1;
	
	public GUIPomodoro() {
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setBackground(new Color(229, 80, 57));

		timerLabel = new JLabel("15:00");
		timerLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
		timerLabel.setForeground(Color.BLACK);
		timerLabel.setBounds(0, 0, 130, 80);
		timerLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		contentPane.add(timerLabel);

		initButtonPause();
		initButtonSkip();

		JPanel actionPane = ContentPane.getActionPane(btnPause);
		
		contentPane.add(actionPane);
		
		Progress progress = Progress.getInstance();

		contentPane.add(progress.newIndicatorPane());

		JPanel viewStatsPane = new JPanel();
		viewStatsPane.setLayout(new BoxLayout(viewStatsPane, BoxLayout.LINE_AXIS));
		viewStatsPane.setBackground(new Color(229, 80, 57));

		viewStatsLabel = new JLabel("view stats");
		viewStatsLabel.setForeground(Color.BLACK);
		viewStatsPane.add(Box.createHorizontalGlue());
		viewStatsPane.add(viewStatsLabel);
		contentPane.add(viewStatsPane);
		
		frame = new PomodoroFrame();
		frame.add(contentPane);
	}

	private void initButtonPause() {
		btnPause = new JButton();
		btnPause.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPause.setBorderPainted(false);
		btnPause.setBorder(null);
		btnPause.setOpaque(false);
		btnPause.setMargin(new Insets(0, 0, 0, 0));
		btnPause.setSize(0, 0);
		btnPause.setFocusPainted(false);
		btnPause.setContentAreaFilled(false);
		btnPause.setIcon(new ImageIcon(GUIPomodoro.class.getResource("/res/pause.png")));
		btnPause.addActionListener(this);
	}

	private void initButtonSkip() {
		btnSkip = new JButton();
		btnSkip.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSkip.setBorderPainted(false);
		btnSkip.setBorder(null);
		btnSkip.setOpaque(false);
		btnSkip.setMargin(new Insets(0, 0, 0, 0));
		btnSkip.setSize(0, 0);
		btnSkip.setFocusPainted(false);
		btnSkip.setContentAreaFilled(false);
		btnSkip.setIcon(new ImageIcon(GUIPomodoro.class.getResource("/res/skip.png")));
		btnSkip.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timerLabel.setText(String.valueOf(count));
		
		TimeClass tc = new TimeClass(count);
		timer = new Timer(1000,tc);
		timer.start();
		
	}

	public class TimeClass implements ActionListener{
			
			int counter;
			public TimeClass(int counter) {
				this.counter = counter;
			}
			
			public void actionPerformed(ActionEvent tc) {
				counter--;
				
				if(counter >= 1) {
					timerLabel.setText(String.valueOf(counter));
				}
				else {
					timer.stop();
					timerLabel.setText("Done");
				}
			}
			
	}
	
	public static void main(String[] args) {
		new GUIPomodoro();
	}
}
