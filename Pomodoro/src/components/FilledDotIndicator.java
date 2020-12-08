package components;

import javax.swing.ImageIcon;

import GUI.GUIPomodoro;

public class FilledDotIndicator extends DotIndicator {

	@Override
	public ImageIcon getImageIcon() {
		// TODO Auto-generated method stub
		return new ImageIcon(GUIPomodoro.class.getResource("../res/filled_dot.png"));
	}

}
