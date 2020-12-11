package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class SkipButton extends IconButton {

	public SkipButton(ActionListener mListener) {
		super(mListener);
	}

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(SkipButton.class.getResource("/res/skip.png"));
	}
}
