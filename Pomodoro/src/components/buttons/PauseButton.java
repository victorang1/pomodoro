package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import listener.ButtonListener;
import listener.PauseButtonListener;

public class PauseButton extends Button {

	@Override
	protected Icon getButtonIcon() {
		setVisible(false);
		return new ImageIcon(PauseButton.class.getResource("/res/pause.png"));
	}

	@Override
	protected ButtonListener getButtonListener() {
		return new PauseButtonListener();
	}
}
