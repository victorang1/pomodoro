package components.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StatsFrame extends BaseFrame {

    private JPanel statsPanel;

    public StatsFrame(JPanel statsPanel) {
        this.statsPanel = statsPanel;
    }
    
    @Override
    public JFrame getFrame() {
      return mBuilder.setDefaultPomodoroFrame()
        .useBoxLayout()
        .setCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        .addPanel(statsPanel)
        .setPack()
        .build();
    }
}
