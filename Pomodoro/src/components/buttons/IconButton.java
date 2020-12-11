package components.buttons;

import javax.swing.Icon;
import java.awt.event.ActionListener;

public abstract class IconButton extends Button {

    public IconButton(ActionListener mListener) {
        super(mListener);
        setVisible(false);
        setIcon(getButtonIcon());
    }

    protected abstract Icon getButtonIcon();
}
