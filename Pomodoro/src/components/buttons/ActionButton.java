package components.buttons;

import javax.swing.Icon;
import java.awt.event.ActionListener;

public abstract class ActionButton extends Button {

    public ActionButton(ActionListener mListener) {
        super(mListener);
        setVisible(false);
        setIcon(getButtonIcon());
    }

    protected abstract Icon getButtonIcon();
}
