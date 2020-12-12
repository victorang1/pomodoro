package components.buttons;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import listener.ButtonListener;
import listener.PlayButtonListener;

public class PlayButton extends IconButton {

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(PlayButton.class.getResource("/res/play.png"));
	}

	@Override
	protected ButtonListener getButtonListener() {
		return new PlayButtonListener();
	}
}
