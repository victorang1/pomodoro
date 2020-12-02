
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewStat {
	JFrame jframe;
	JButton jbutton;
	JPanel jpanel;
	JPanel OuterPanel = new JPanel();
	JLabel jlabel;
	String days[] = {"Tue","Wed","Thu","Fri","Sat","Sun","Mon"};
	
	public ViewStat() {
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setLayout(new BoxLayout(jframe.getContentPane(),BoxLayout.X_AXIS));

		
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
		
		jframe.add(OuterPanel);	
		jframe.setVisible(true);
		jframe.setIconImage(new ImageIcon("res\tomato.png").getImage());
		jframe.pack();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewStat();
	}

}
