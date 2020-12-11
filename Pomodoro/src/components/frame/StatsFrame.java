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
        .useBorderLayout()
        .addPanel(statsPanel)
        .setPack()
        .build();
    }
}
