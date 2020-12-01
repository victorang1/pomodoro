import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GUIPomodoro implements ActionListener{

	JFrame frame;
	JLabel label,timerLabel;
	JPanel panel;
	JButton button;
	Timer timer;
	int count=20;
	
	public GUIPomodoro() {
		frame = new JFrame();
		panel = new JPanel();
		panel.setBackground(Color.red);
//		panel.setLayout(new GridLayout(2,2,5,5));
		
		button = new JButton("Start");
		button.addActionListener(this);
		frame.setTitle("Pomodoro");
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));
		button.setAlignmentX(Component.BOTTOM_ALIGNMENT);
		panel.add(button);
		timerLabel = new JLabel("",SwingConstants.CENTER);
		panel.add(timerLabel);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		timerLabel.setText("Time left :" + count);
		
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
					timerLabel.setText("Time left : " + counter);
				}
				else {
					timer.stop();
					timerLabel.setText("Done");
				}
			}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIPomodoro();
	}
	
}
