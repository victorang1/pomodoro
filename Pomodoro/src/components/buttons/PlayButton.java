package components.buttons;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class PlayButton extends IconButton {

	public PlayButton(ActionListener mListener) {
		super(mListener);
	}

	@Override
	protected Icon getButtonIcon() {
		return new ImageIcon(PlayButton.class.getResource("/res/play.png"));
	}
}
