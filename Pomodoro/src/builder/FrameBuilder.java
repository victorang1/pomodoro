package builder;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBuilder {
    
    private JFrame frame;
    private ArrayList<JPanel> components;

    public FrameBuilder() {
        frame = new JFrame();
        components = new ArrayList<>();
    }

    public FrameBuilder(ArrayList<JPanel> components) {
        this.components = components;
    }

    public FrameBuilder(JPanel contentPane) {
        this.components.add(contentPane);
    }

    public FrameBuilder setDefaultPomodoroFrame() {
        setTitle("Pomodoro");
        setIcon(new ImageIcon(FrameBuilder.class.getResource("/res/tomato.png")));
		setCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisibility(true);
		setResizable(false);
        frame.setLocationRelativeTo(null);
        return this;
    }

    public FrameBuilder setTitle(String title) {
        frame.setTitle(title);
        return this;
    }

    public FrameBuilder setIcon(ImageIcon icon) {
        frame.setIconImage(icon.getImage());
        return this;
    }

    public FrameBuilder setCloseOperation(int type) {
        frame.setDefaultCloseOperation(type);
        return this;
    }

    public FrameBuilder setVisibility(boolean isVisible) {
        frame.setVisible(isVisible);
        return this;
    }

    public FrameBuilder setResizable(boolean isRezisable) {
        frame.setResizable(isRezisable);
        return this;
    }

    public FrameBuilder setSize(Dimension dimension) {
        frame.setSize(dimension);
        return this;
    }

    public FrameBuilder setPack() {
        frame.pack();
        return this;
    }

    public FrameBuilder useBorderLayout() {
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        return this;
    }

    public FrameBuilder addPanel(JPanel jPanel) {
        frame.add(jPanel);
        return this;
    }

    public JFrame build() {
        for (JPanel panel: components) {
            frame.add(panel);
        }
        return frame;
    }
}
