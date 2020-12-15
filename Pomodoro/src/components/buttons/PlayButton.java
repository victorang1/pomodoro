package components.buttons;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import listener.ButtonListener;
import listener.PlayButtonListener;

public class PlayButton extends Button {

	@Override
	protected Icon getButtonIcon() {
		setVisible(false);
		return new ImageIcon(PlayButton.class.getResource("/res/play.png"));
	}

	@Override
	protected ButtonListener getButtonListener() {
		return new PlayButtonListener();
	}
}
