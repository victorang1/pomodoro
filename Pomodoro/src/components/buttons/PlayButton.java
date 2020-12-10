package components.buttons;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import action.CustomButtonListener;
import action.PlayAction;
import components.TimeClass;

public class PlayButton extends ActionButton {

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(PlayButton.class.getResource("/res/play.png"));
	}

	@Override
	protected void setListener() {
	    addActionListener(new CustomButtonListener(new PlayAction(TimeClass.getInstance().getTimer())));
	}
}
