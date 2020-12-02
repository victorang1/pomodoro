import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIStats {
	JFrame frame;
	JLabel labels;
	JPanel panel;
	
	
	public GUIStats() {
		frame = new JFrame();
		panel = new JPanel();
		
		JLabel[] labels = new JLabel[7];
		
		frame.setTitle("Pomodoro");
		panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUIStats();
	}

}
