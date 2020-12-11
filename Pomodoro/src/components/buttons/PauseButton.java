package components.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class PauseButton extends IconButton {

	public PauseButton(ActionListener mListener) {
		super(mListener);
	}

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(PauseButton.class.getResource("/res/pause.png"));
	}
}
