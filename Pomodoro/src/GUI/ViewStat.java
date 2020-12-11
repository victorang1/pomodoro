package GUI;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.frame.StatsFrame;

public class ViewStat {

	JButton jbutton;
	JPanel jpanel;
	JPanel OuterPanel = new JPanel();
	JLabel jlabel;
	String days[] = {"Tue","Wed","Thu","Fri","Sat","Sun","Mon"};
	
	public ViewStat() {

		for (String d : days) {
			JPanel jpanel = new JPanel();
		
			jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
			jpanel.add(new JLabel(d));
			jpanel.add(Box.createRigidArea(new Dimension(0,5)));
			jpanel.setPreferredSize(new Dimension(45, 45));
			jpanel.setMaximumSize(new Dimension(45, 45));
			jpanel.add(new JLabel("0"));
			
			OuterPanel.add(jpanel);
		}
		
		new StatsFrame(OuterPanel).getFrame();
	}
	
	public static void main(String[] args) {
		new ViewStat();
	}

}
