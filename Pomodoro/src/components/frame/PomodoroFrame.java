package components.frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PomodoroFrame extends BaseFrame {
	private JPanel jPanel;
	public PomodoroFrame(JPanel jPanel) {
		super();
		this.jPanel = jPanel;
	}
    @Override
    public JFrame getFrame() {
      return mBuilder.setDefaultPomodoroFrame()
        .setCloseOperation(JFrame.EXIT_ON_CLOSE)
        .setVisibility(true)
        .setSize(new Dimension(300, 200))
        .addPanel(jPanel)
        .build();
    }
}
