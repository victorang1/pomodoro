package components;

import javax.swing.ImageIcon;

public class TwoToneDotIndicator extends DotIndicator {

	@Override
	public ImageIcon getImageIcon() {
		return new ImageIcon(TwoToneDotIndicator.class.getResource("../res/twotone_dot.png"));
	}

}
