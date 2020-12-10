package components.buttons;

import javax.swing.Icon;

public abstract class ActionButton extends Button {

    public ActionButton() {
        setVisible(false);
        setIcon(getButtonIcon());
    }

    protected abstract Icon getButtonIcon();
}
