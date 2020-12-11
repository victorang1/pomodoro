package components;

import javax.swing.ImageIcon;

public class FilledDotIndicator extends DotIndicator {

	@Override
	public ImageIcon getImageIcon() {
		return new ImageIcon(FilledDotIndicator.class.getResource("../res/filled_dot.png"));
	}

}
