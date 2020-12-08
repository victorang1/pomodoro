package components;

import javax.swing.ImageIcon;

import GUI.GUIPomodoro;

public class TwoToneDotIndicator extends DotIndicator {

	@Override
	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(GUIPomodoro.class.getResource("../res/twotone_dot.png"));
	}

}
