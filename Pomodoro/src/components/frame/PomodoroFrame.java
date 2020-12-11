package components.frame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class PomodoroFrame extends BaseFrame {

    @Override
    public JFrame getFrame() {
      return mBuilder.setDefaultPomodoroFrame()
        .setSize(new Dimension(300, 200))
        .build();
    }
}
