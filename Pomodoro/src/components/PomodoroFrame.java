package components;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PomodoroFrame extends JFrame {
    
    public PomodoroFrame() {
        setTitle("Pomodoro");
		setSize(300, 200);
		setIconImage(new ImageIcon(PomodoroFrame.class.getResource("/res/tomato.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
    }
}
