package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import action.CustomButtonListener;
import action.PauseAction;
import components.TimeClass;

public class PauseButton extends ActionButton {

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(PauseButton.class.getResource("/res/pause.png"));
	}

	@Override
	protected void setListener() {
	    addActionListener(new CustomButtonListener(new PauseAction(TimeClass.getInstance().getTimer())));
	}
}
