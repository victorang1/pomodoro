package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import listener.ButtonListener;
import listener.SkipButtonListener;

public class SkipButton extends Button {

	@Override
	protected Icon getButtonIcon() {
		setVisible(false);
		return new ImageIcon(SkipButton.class.getResource("/res/skip.png"));
	}

	@Override
	protected ButtonListener getButtonListener() {
		return new SkipButtonListener();
	}
}
