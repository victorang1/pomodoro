package components.frame;


import javax.swing.JFrame;

import builder.FrameBuilder;

public abstract class BaseFrame extends JFrame {

    protected FrameBuilder mBuilder;

    public BaseFrame() {
        mBuilder = new FrameBuilder();
    }

    public abstract JFrame getFrame();
}
