package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import GUI.GUIPomodoro;
import action.CustomButtonListener;
import action.SkipAction;

public class SkipButton extends ActionButton {

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(SkipButton.class.getResource("/res/skip.png"));
	}

	@Override
	protected void setListener() {
	    addActionListener(new CustomButtonListener(new SkipAction()));
	}
}
