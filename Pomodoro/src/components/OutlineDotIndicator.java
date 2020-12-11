package components;

import javax.swing.ImageIcon;

public class OutlineDotIndicator extends DotIndicator {

	@Override
	public ImageIcon getImageIcon() {
		return new ImageIcon(OutlineDotIndicator.class.getResource("../res/outline_dot.png"));
	}
}
