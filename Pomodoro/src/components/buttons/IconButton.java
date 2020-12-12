package components.buttons;

import javax.swing.Icon;

public abstract class IconButton extends Button {

    public IconButton() {
        super();
        setVisible(false);
        setIcon(getButtonIcon());
    }

    protected abstract Icon getButtonIcon();
}
